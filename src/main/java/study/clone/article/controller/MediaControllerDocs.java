package study.clone.article.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import study.clone.article.controller.request.MediaCreateDto;
import study.clone.article.controller.response.MediaCreateResponseDto;
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
    ResponseEntity<MediaCreateResponseDto> createMediaList(@RequestBody MediaCreateDto createDto);

    @Operation(summary = "이미지/동영상 불러오기", description = "게시글 조회시, 이미지/동영상 uri 조회")
    @ApiResponse(
            responseCode = "200",
            description = "이미지/동영상 조회 성공"
    )
    @GetMapping
    ResponseEntity<MediaReadDtoList> readMediaList(@RequestParam("article-id") Integer articleId);

    @Operation(summary = "이미지/동영상 데이터 조회", description = "미디어의 실제 바이너리 조회")
    @ApiResponse(
        responseCode = "200",
        description = "이미지/동영상 데이터 조회 성공"
    )
    @GetMapping("/{media-identifier}")
    ResponseEntity<?> readMediaBinary(@PathVariable("media-identifier") String mediaIdentifier);

}
