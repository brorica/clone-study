package study.clone.article.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 이미지/동영상 업로드 결과 DTO
 * @since 24.12.14 19:14
 */
@Getter
@Builder
public class MediaCreateResponseDto {

    private final Integer mediaId;
    // 이미지/동영상이 저장된 경로
    private final String mediaUri;

    private final LocalDateTime createdAt;
}
