package study.clone.article.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import study.clone.common.dto.BaseTimeEntity;
import study.clone.member.domain.Member;

import java.util.List;

@Getter
@Entity
@Table(schema = "public", name = "article")
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq")
    @SequenceGenerator(name = "article_seq", sequenceName = "article_seq", allocationSize = 1)
    private Integer id;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<Media> mediaList;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ArticleStatus status; // 게시글 상태


    /**
     * 게시글 entity builder
     * @param member 작성자
     * @param title 제목
     */
    @Builder
    public Article(final Member member, final String title) {
        this.member = member;
        this.title = title;
        this.status = ArticleStatus.PUBLISHED;
    }

    /**
     * 주어진 미디어 리스트를 게시글에 매핑한다.
     * 게시글 최종 업로드시 호출돼야 함.
     * @param mediaList 게시글에 포함된 미디어 entity 리스트
     *                  게시글에 연결될 모든 미디어 엔티티를 포함해야 한다.
     */
    public void mappingMedia(final List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    /**
     * 게시글 상태 변경시, 호출
     */
    public void changeStatus(ArticleStatus status) {
        this.status = status;
    }

    protected Article() {
    }
}
