package study.clone.media.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 이미지/동영상 조회 결과 DTO
 * @since 24.12.14 19:14
 */
@Getter
@AllArgsConstructor
public class MediaReadDto {

    private final Integer mediaId;

    private final String mediaUri;

}
