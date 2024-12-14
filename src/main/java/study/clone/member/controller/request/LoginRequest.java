package study.clone.member.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 로그인 요청 DTO
 * @since 24.12.14 19:14
 */
@Getter
@AllArgsConstructor
public class LoginRequest {

    private final String email;

    private final String password;
}
