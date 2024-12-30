package study.clone.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.clone.article.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
