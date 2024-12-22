package study.clone.article.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import study.clone.article.controller.request.ArticleCreateDto;
import study.clone.article.controller.request.ArticleUpdateDto;
import study.clone.article.controller.response.ArticleReadDto;
import study.clone.article.controller.response.ArticleReadDtoList;

/**
 * 게시글 기능 api doc
 * @since 24.12.14 21:30
 */
@Tag(name = "01.Article", description = "게시글 기능")
public interface ArticleControllerDocs {

    @Operation(summary = "게시글 생성", description = "제목과 이미지/동영상 업로드된 링크들을 받아 게시글 생성")
    @ApiResponse(
            responseCode = "200",
            description = "게시글 생성 성공. 반환 값은 없다."
    )
    @PostMapping
    ResponseEntity<?> createArticle(@RequestBody ArticleCreateDto createDto);

    @Operation(summary = "게시글 조회", description = "커서 페이징으로 게시글 정보를 가져온다.")
    @ApiResponse(
            responseCode = "200",
            description = "게시글 조회 성공"
    )
    @GetMapping
    ResponseEntity<ArticleReadDtoList> readArticleList(@RequestParam("lastId") Integer lastId);

    @Operation(summary = "게시글 상세 조회", description = "게시글의 상세 정보를 불러온다.")
    @ApiResponse(
        responseCode = "200",
        description = "게시글 상세 조회 성공"
    )
    @GetMapping
    ResponseEntity<ArticleReadDto> readArticleDetail(@PathVariable("article-id") Integer articleId);

    @Operation(summary = "게시글 수정", description = "게시글의 제목을 바꾼다. 이미지/동영상 수정은 불가능")
    @ApiResponse(
            responseCode = "200",
            description = "게시글 수정 성공. 반환 값은 없다."
    )
    @PutMapping("/{article-id}")
    ResponseEntity<?> updateArticle(@RequestBody ArticleUpdateDto updateDto);

    @Operation(summary = "게시글 삭제", description = "게시글 삭제. 실제로 지우진 않고 활성화 여부만 바꾼다.")
    @ApiResponse(
            responseCode = "200",
            description = "게시글 삭제 성공. 반환 값은 없다."
    )
    @DeleteMapping("/{article-id}")
    ResponseEntity<?> deleteArticle(@PathVariable("article-id") Integer articleId);

}
