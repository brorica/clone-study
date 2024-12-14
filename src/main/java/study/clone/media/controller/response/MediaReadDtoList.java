package study.clone.media.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * 이미지/동영상 조회 결과 DTO List
 * @since 24.12.14 19:14
 */
@Getter
@AllArgsConstructor
public class MediaReadDtoList {

    private final Integer postId;

    private final List<MediaReadDto> mediaList;
}
