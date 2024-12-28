package study.clone.member.domain;

/**
 * 사용자 상태
 * @since 24.12.28 18:23
 */
public enum MemberStatus {
    ACTIVE,     // 활성화
    SUSPENDED,  // 휴면
    DELETED,    // 탈퇴
    INACTIVE,   // 비활성화
    PENDING,    // 검토
    BANNED,     // 제재
}
