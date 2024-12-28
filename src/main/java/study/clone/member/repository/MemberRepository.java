package study.clone.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.clone.member.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByUsername(final String username);
}
