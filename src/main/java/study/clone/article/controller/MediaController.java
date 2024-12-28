package study.clone.article.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.clone.article.controller.request.MediaCreateDtoList;
import study.clone.article.controller.response.MediaCreateResponseDtoList;
import study.clone.article.controller.response.MediaReadDtoList;

/**
 * 이미지/동영상 기능 rest controller
 * @since 24.12.14 19:14
 */
@RestController
@RequestMapping("/api/media")
public class MediaController implements MediaControllerDocs {

    @Override
    @PostMapping
    public ResponseEntity<MediaCreateResponseDtoList> createMediaList(MediaCreateDtoList createDtoList) {
        return ResponseEntity.ok(null);
    }

    @Override
    @GetMapping
    public ResponseEntity<MediaReadDtoList> readMediaList(@RequestParam("article-id") Integer articleId) {
        return ResponseEntity.ok(null);
    }
}
