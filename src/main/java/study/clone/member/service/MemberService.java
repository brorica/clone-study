package study.clone.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.clone.member.controller.request.MemberCreateDto;
import study.clone.member.domain.Member;
import study.clone.member.repository.MemberRepository;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 사용자 생성
     * @since 24.12.28 18:23
     */
    @Transactional
    public void createMember(final MemberCreateDto createDto) {
        Member member = createDto.toEntity();
        memberRepository.save(member);
    }

    /**
     * 사용자를 id로 찾음
     * @since 24.12.28 18:23
     */
    public Member findMember(final Integer memberId) {
        return memberRepository.findById(memberId)
            .orElseThrow(() -> new RuntimeException("존재하지 않는 id " + memberId));
    }

    /**
     * 사용자를 username으로 찾음
     * @since 24.12.28 18:23
     */
    public Member findMember(final String username) {
        return memberRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("존재하지 않는 username " + username));
    }

}
