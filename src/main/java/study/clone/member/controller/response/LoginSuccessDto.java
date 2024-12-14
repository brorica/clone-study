package study.clone.member.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 로그인 성공시 반환 DTO
 * @since 24.12.14 19:14
 */
@Getter
@AllArgsConstructor
public class LoginSuccessDto {

    private final String username;

    private final String thumbnail;
}
