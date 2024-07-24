package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //Member find(Member)ByEmail // 엔티티명 = 지네릭스에 명시 -> 생략 가능
    //Optional<Member> findByEmail(String email); //필요한 경우 Optional
    Member findByEmail(String email);

    List<Member> findByEmailContainingAndUserNameContainingOrderByCreatedAtDesc(String key1, String key2);
}
