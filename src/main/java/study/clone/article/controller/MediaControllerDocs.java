package study.clone.article.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import study.clone.article.controller.request.MediaCreateDtoList;
import study.clone.article.controller.response.MediaCreateResponseDtoList;
import study.clone.article.controller.response.MediaReadDtoList;

/**
 * 이미지/동영상 기능 api doc
 * @since 24.12.14 21:30
 */
@Tag(name = "02.Media", description = "이미지/동영상 기능")
public interface MediaControllerDocs {

    @Operation(summary = "이미지/동영상 업로드", description = "게시글 생성 전 이미지/동영상 업로드")
    @ApiResponse(
            responseCode = "200",
            description = "이미지/동영상 업로드 성공"
    )
    @PostMapping
    ResponseEntity<MediaCreateResponseDtoList> createMediaList(@RequestBody MediaCreateDtoList createDtoList);

    @Operation(summary = "이미지/동영상 불러오기", description = "게시글 조회시, 이미지/동영상 uri 조회")
    @ApiResponse(
            responseCode = "200",
            description = "이미지/동영상 조회 성공"
    )
    @GetMapping
    ResponseEntity<MediaReadDtoList> readMediaList(@RequestParam("article-id") Integer articleId);

}
