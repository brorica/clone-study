package study.clone.member.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import study.clone.member.domain.Member;

/**
 * 사용자 생성에 필요한 DTO
 * @since 24.12.14 19:14
 */
@Getter
@AllArgsConstructor
public class MemberCreateDto {

    private final String username;

    public Member toEntity() {
        return Member.builder()
            .username(username)
            .build();
    }
}
