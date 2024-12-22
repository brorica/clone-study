package study.clone.article.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.clone.article.controller.request.ArticleCreateDto;
import study.clone.article.controller.request.ArticleUpdateDto;
import study.clone.article.controller.response.ArticleReadDto;
import study.clone.article.controller.response.ArticleReadDtoList;

/**
 * 게시글 기능 rest controller
 * @since 24.12.14 19:14
 */
@RestController
@RequestMapping("/api/articles")
public class ArticleController implements ArticleControllerDocs {

    /**
     * 게시글 생성
     * @return 성공시 200 OK
     * @since 24.12.14 19:14
     */
    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody ArticleCreateDto createDto) {
        return ResponseEntity.ok().build();
    }

    /**
     * 게시글 리스트 조회
     * @param lastId 가장 마지막으로 조회한 id
     * @return 다음 게시글 목록들
     * @since 24.12.14 19:14
     */
    @GetMapping
    public ResponseEntity<ArticleReadDtoList> readArticleList(@RequestParam("lastId") Integer lastId) {
        return ResponseEntity.ok(null);
    }

    /**
     * 게시글 상세조회
     * @param articleId 게시글 id
     * @return 게시글 상세정보
     * @since 24.12.22 16:11
     */
    @GetMapping("{article-id}")
    public ResponseEntity<ArticleReadDto> readArticleDetail(@PathVariable("article-id") Integer articleId) {
        return ResponseEntity.ok(null);
    }

    /**
     * 게시글의 제목을 바꾼다. 이미지/동영상 수정은 불가능
     * @param updateDto 변경할 게시글의 제목
     * @return 성공시 200 OK
     * @since 24.12.14 19:14
     */
    @PutMapping("/{article-id}")
    public ResponseEntity<?> updateArticle(@RequestBody ArticleUpdateDto updateDto) {

        return ResponseEntity.ok().build();
    }

    /**
     * 게시글 삭제. 실제로 지우진 않고 활성화 여부만 바꾼다.
     * @return 결과와 상관없이 200 OK
     * @since 24.12.14 19:14
     */
    @DeleteMapping("/{article-id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("article-id") Integer articleId) {

        return ResponseEntity.ok().build();
    }

}
