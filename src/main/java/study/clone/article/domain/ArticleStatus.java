package study.clone.article.domain;

/**
 * 게시글 상태
 */
public enum ArticleStatus {
    PUBLISHED,  // 게시됨
    UNPUBLISHED, // 비공개
    DELETED,    // 삭제됨
    PENDING     // 검토 중
}
