package study.clone.article.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import study.clone.article.domain.MediaType;

import java.util.Base64;

/**
 * 이미지/동영상 업로드 DTO
 * @since 24.12.14 19:14
 */
@Getter
@AllArgsConstructor
public class MediaCreateDto {
    // IMAGE / VIDEO
    private final MediaType mediaType;
    // 인코딩된 이미지/동영상 바이너리
    private final String encodedBinary;

    public byte[] binaryStringToByteArray() {
        return encodedBinary.getBytes();
    }
}
