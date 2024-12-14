package study.clone.article.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleReadDtoList {

    private final List<ArticleReadDto> articleList;

    // 전체 데이터 개수
    private final Integer totalContents;
    // 첫 번째로 조회한 id
    private final Integer firstId;
    // -1 이면 마지막 스크롤
    private final Integer nextId;
    // 요청한 페이지 번호
    private final Integer requestPage;
    // 한번에 가져올 데이터 개수
    private final Integer requestSize;
}
