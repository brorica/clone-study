package study.clone.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import study.clone.article.domain.Article;
import study.clone.common.dto.BaseTimeEntity;
import study.clone.article.domain.Media;

import java.util.List;

@Getter
@Entity
@Table(schema = "public", name = "member")
public class Member  extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    @SequenceGenerator(name = "member_seq", sequenceName = "member_seq", allocationSize = 1)
    private Integer id;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Article> articles;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Media> medias;

    @Column(nullable = false, unique = true, length = 32)
    private String username;

    // 사용자 상태
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Builder
    public Member(String username) {
        this.username = username;
        this.status = MemberStatus.ACTIVE;
    }

    protected Member() {
    }
}
