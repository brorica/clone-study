package study.clone.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import study.clone.member.controller.request.LoginRequest;
import study.clone.member.controller.response.LoginSuccessDto;

/**
 * 사용자 기능 api doc
 * @since 24.12.14 21:30
 */
@Tag(name = "03.Member", description = "사용자 기능, 현재는 러프하게 진행")
public interface MemberControllerDocs {

    @Operation(summary = "로그인", description = "id/pw 모두 test. 토큰 방식으로 수정 예정")
    @ApiResponse(
            responseCode = "200",
            description = "로그인 성공. 로그인한 사용자 정보 반환"
    )
    @PostMapping("/login")
    ResponseEntity<LoginSuccessDto> login(@RequestBody LoginRequest loginDto);

    @Operation(summary = "로그아웃", description = "로그아웃")
    @ApiResponse(
        responseCode = "200",
        description = "결과와 상관없이 200 반환"
    )
    @PostMapping
    ResponseEntity<?> logout();
}
