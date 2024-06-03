package io.paioneer.nain.member.jpa.repository;

import io.paioneer.nain.member.jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String>, MemberRepositoryCustom {


}
