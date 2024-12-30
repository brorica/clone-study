package study.clone.article.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.clone.article.controller.request.MediaCreateDto;
import study.clone.article.controller.response.MediaCreateResponseDto;
import study.clone.article.domain.Article;
import study.clone.article.domain.Media;
import study.clone.article.repository.MediaRepository;
import study.clone.member.domain.Member;
import study.clone.member.service.MemberService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MediaService {

    private final MediaRepository mediaRepository;

    private final MemberService memberService;

    /**
     * 미디어 업로드(이미지 or 동영상)
     * 게시글 최종 업로드 전까진, 게시글 FK가 NULL
     * @param createDto 업로드할 미디어 (바이너리, 파일 유형)
     * @return 미디어 id가 포함된 생성 정보. 게시글 최종 업로드시, 해당 id들을 사용해야 한다.
     */
    @Transactional
    public MediaCreateResponseDto saveMedia(final MediaCreateDto createDto) {
        Member member = memberService.findMember(1);
        Media initialMedia = Media.builder()
            .member(member)
            .mediaType(createDto.getMediaType())
            .fileData(createDto.binaryStringToByteArray())
            .build();
        Media save = mediaRepository.save(initialMedia);
        return save.getCreateResponseDto();
    }

    public List<Media> findArticleMedia(final Integer articleId) {
        return mediaRepository.findAllByArticleId(articleId);
    }

    /**
     * 미디어 entity 조회
     * @param mediaId 조회할 미디어 id
     * @return 미디어 entity / 없는 id라면 예외
     */
    public Media findMedia(final Integer mediaId) {
        return mediaRepository.findById(mediaId)
            .orElseThrow(() -> new RuntimeException("존재하지 않는 미디어: " + mediaId));
    }

    /**
     * 게시글 최종 업로드시 미디어 entity 에서 수행할 작업
     * 1. 미디어 entity에 최종 업로드된 게시글 entity 매핑
     * 2. 게시글 entity와 매핑되지 않은 미디어들 전부 삭제 (article = NULL로 판별)
     * @param article 최종 업로드된 게시글 entity
     * @param includeMediaIdList 게시글 안에 포함된 미디어 id 리스트
     * @return 게시글 entity 정보가 매핑된 미디어 entity 리스트
     */
    @Transactional
    public List<Media> finalizeArticleUpload(final Article article, final List<Integer> includeMediaIdList) {
        List<Media> media = mappingArticle(article, includeMediaIdList);
        deleteUnRelateMedia();
        return media;
    }

    /**
     * 게시글 최종 업로드시, 해당 게시글에 업로드된 모든 미디어에 게시글 entity 매핑
     * @param article 최종 업로드된 게시글 entity
     * @param includeMediaIdList 게시글 안에 포함되 미디어 id 리스트
     * @return 게시글 entity 정보가 매핑된 미디어 entity 리스트
     */
    @Transactional
    private List<Media> mappingArticle(final Article article, final List<Integer> includeMediaIdList) {
        List<Media> entityList = new ArrayList<>(16);   // 10개 미만으로 받을 생각이라 초기값을 16으로 함
        for (Integer mediaId : includeMediaIdList) {
            Media media = findMedia(mediaId);   // 미디어 entity 조회
            media.mappingArticle(article);      // article entity 매핑
            entityList.add(media);              // 반환할 리스트에 미디어 entity 추가
        }
        return entityList;
    }

    /**
     * 게시글 최종 업로드시, article이 포함되지 않은 미디어 entity 전부 삭제
     */
    @Transactional
    private void deleteUnRelateMedia() {
        Member member = memberService.findMember(1);
        mediaRepository.deleteUnRelatedMedia(member);
    }
}
