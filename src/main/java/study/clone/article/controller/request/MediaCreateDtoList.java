package study.clone.article.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * 이미지/동영상 업로드 DTO List
 * 게시글 생성시, 여러 개의 이미지/동영상응 업로드할 수 있다.
 * @since 24.12.14 19:14
 */
@Getter
@AllArgsConstructor
public class MediaCreateDtoList {

    private List<MediaCreateDto> mediaBinaryList;
}
