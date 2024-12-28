package study.clone.article.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * 이미지/동영상 업로드 결과 DTO List
 * @since 24.12.14 19:14
 */
@Getter
@AllArgsConstructor
public class MediaCreateResponseDtoList {

    private final List<MediaCreateResponseDto> mediaList;
}
