package study.clone.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import study.clone.article.domain.Media;
import study.clone.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media, Integer> {

    List<Media> findAllByArticleId(final Integer articleId);

    @Modifying
    @Query("DELETE FROM Media m WHERE m.member = :member AND m.article IS NULL")
    void deleteUnRelatedMedia(final Member member);

    Optional<Media> findByIdentifier(final String identifier);
}
