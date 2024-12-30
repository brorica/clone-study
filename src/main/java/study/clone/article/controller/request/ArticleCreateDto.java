package study.clone.article.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * 게시글 생성에 필요한 DTO
 */
@Getter
@AllArgsConstructor
public class ArticleCreateDto {

    private final String title;

    private final List<Integer> mediaIdList;
}
