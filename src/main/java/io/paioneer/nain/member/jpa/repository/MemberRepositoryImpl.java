package io.paioneer.nain.member.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.paioneer.nain.member.jpa.entity.Member;
import io.paioneer.nain.member.jpa.entity.QMemberEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    //JPQL 사용을 위해 DI(의존성) 추가함
    private final EntityManager entityManager;

    private final QMemberEntity member = QMemberEntity.memberEntity;

    @Override
    public Member findByMemberEmail(String memberEmail) {
        //queryDSL 사용
        return queryFactory
                .selectFrom(member)
                .where(member.memberEmail.eq(memberEmail))
                .fetchOne(); //조회한 회원 한 건 조회
    }
}
