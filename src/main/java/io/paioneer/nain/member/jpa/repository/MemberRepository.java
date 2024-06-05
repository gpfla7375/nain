package io.paioneer.nain.member.jpa.repository;

import io.paioneer.nain.member.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository
        extends JpaRepository<Member, String>, MemberRepositoryCustom {
    //상속을 이용한 QueryDSL Repository 사용

}
