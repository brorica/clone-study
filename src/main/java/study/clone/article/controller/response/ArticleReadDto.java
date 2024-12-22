package study.clone.article.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import study.clone.media.controller.response.MediaReadDto;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleReadDto {

    private final Integer articleId;

    private final String title;

    private final List<MediaReadDto> mediaList;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;
}
