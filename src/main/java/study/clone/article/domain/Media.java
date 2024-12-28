package study.clone.article.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import study.clone.common.dto.BaseTimeEntity;

@Getter
@Entity
@Table(schema = "public", name = "media")
public class Media  extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "media_seq")
    @SequenceGenerator(name = "media_seq", sequenceName = "media_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @Builder
    public Media(String url, MediaType mediaType, Article article) {
        this.url = url;
        this.mediaType = mediaType;
        this.article = article;
    }

    protected Media() {
    }
}