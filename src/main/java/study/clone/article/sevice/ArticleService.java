package study.clone.article.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.clone.article.controller.request.ArticleCreateDto;
import study.clone.article.domain.Article;
import study.clone.article.domain.Media;
import study.clone.article.repository.ArticleRepository;
import study.clone.member.domain.Member;
import study.clone.member.service.MemberService;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    private final MemberService memberService;

    private final MediaService mediaService;

    /**
     * 1. 게시글 entity 생성
     * 2. 첨부된 미디어가 있다면 연관관계 매핑 후, 게시글에 미디어 정보 set
     * @param createDto 게시글 생성에 관련된 정보들
     */
    @Transactional
    public void saveArticle(final ArticleCreateDto createDto) {
        Member member = memberService.findMember(1);
        // 게시글 entity 생성
        Article initialArticle = Article.builder()
            .member(member)
            .title(createDto.getTitle())
            .build();
        Article save = articleRepository.save(initialArticle);
        // 첨부된 미디어가 있다면 연관관계 매핑 후, 게시글에 미디어 정보 set
        List<Media> mediaList = mediaService.finalizeArticleUpload(save, createDto.getMediaIdList());
        save.mappingMedia(mediaList);
    }

    public Article findArticle(final Integer articleId) {
        return articleRepository.findById(articleId)
            .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글: " + articleId));
    }
}
