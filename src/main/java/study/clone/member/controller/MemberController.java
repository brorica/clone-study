package study.clone.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.clone.member.controller.request.LoginRequest;
import study.clone.member.controller.response.LoginSuccessDto;

/**
 * 사용자 기능 rest controller
 * 인증/인가 및 사용자 관리 우선 순위가 낮아 러프하게 구성
 * @since 24.12.14 19:14
 */
@RestController
@RequestMapping("/api/members")
public class MemberController implements MemberControllerDocs {

    /**
     * 로그인 처리
     * @param loginDto email = test / password = test 입력
     * @return 로그인한 사용자 정보
     */
    @PostMapping
    public ResponseEntity<LoginSuccessDto> login(@RequestBody LoginRequest loginDto) {
        if (loginDto.getEmail().equals("test") && loginDto.getPassword().equals("test")) {
            LoginSuccessDto loginSuccessDto = new LoginSuccessDto("사용자 이름", "아무튼 링크");
            return ResponseEntity.ok(loginSuccessDto);
        }
        return ResponseEntity.ok(null);
    }

    /**
     * 로그아웃 처리
     * @return 결과와 상관없이 200 반환
     */
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok().build();
    }

}
