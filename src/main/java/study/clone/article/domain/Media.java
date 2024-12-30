package study.clone.article.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import study.clone.article.controller.response.MediaCreateResponseDto;
import study.clone.common.dto.BaseTimeEntity;
import study.clone.member.domain.Member;

import static study.clone.common.RandomHash.generateRandomHash32;

@Getter
@Entity
@Table(schema = "public", name = "media")
public class Media  extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "media_seq")
    @SequenceGenerator(name = "media_seq", sequenceName = "media_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = true)
    private Article article;

    @Column(nullable = false)
    private String uri;

    @Column(columnDefinition = "bytea")
    private byte[] fileData;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MediaType mediaType;

    /**
     * 미디어 entity builder
     * @param member    작성자
     * @param mediaType 미디어 유형 (이미지 or 동영상)
     * @param fileData  base64로 인코딩된 미디어 바이너리
     */
    @Builder
    public Media(Member member, final MediaType mediaType, final byte[] fileData) {
        this.member = member;
        this.uri = generateRandomHash32();
        this.mediaType = mediaType;
        this.fileData = fileData;
    }

    /**
     * 게시글 엔티티를 미디어 엔티티에 매핑
     * 게시글 최종 업로드시, 호출돼야 함
     * @param article 해당 미디어가 있는 게시글
     */
    public void mappingArticle(final Article article) {
        this.article = article;
    }

    /**
     * 미디어 업로드 성공시, 반환 정보 생성
     * 게시글이 최종 업로드되면, 이 id로 매핑할 미디어 entity를 찾는다.
     * @return 미디어 생성 정보
     */
    public MediaCreateResponseDto getCreateResponseDto() {
        return MediaCreateResponseDto.builder()
            .mediaId(id)
            .mediaUri(uri)
            .createdAt(getCreatedAt())
            .build();
    }

    protected Media() {
    }
}