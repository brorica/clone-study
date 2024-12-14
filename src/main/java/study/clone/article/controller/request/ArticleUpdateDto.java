package study.clone.article.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 게시글 수정 DTO
 * 인스타그램은 사진이나 동영상 바꿀거면 게시글을 지우고 다시 써야 한다.
 * @since 24.12.14 19:14
 */
@Getter
@AllArgsConstructor
public class ArticleUpdateDto {

    private final String title;
}
