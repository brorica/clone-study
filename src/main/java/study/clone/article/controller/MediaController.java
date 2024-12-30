package study.clone.article.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.clone.article.controller.request.MediaCreateDto;
import study.clone.article.controller.response.MediaCreateResponseDto;
import study.clone.article.controller.response.MediaReadDtoList;
import study.clone.article.sevice.MediaService;

import java.util.List;

/**
 * 이미지/동영상 기능 rest controller
 * @since 24.12.14 19:14
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/medias")
public class MediaController implements MediaControllerDocs {

    private final MediaService mediaService;

    @Override
    @PostMapping
    public ResponseEntity<MediaCreateResponseDto> createMediaList(MediaCreateDto createDto) {
        MediaCreateResponseDto responseDto = mediaService.saveMedia(createDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    @GetMapping
    public ResponseEntity<MediaReadDtoList> readMediaList(@RequestParam("article-id") Integer articleId) {
        return ResponseEntity.ok(null);
    }
}
