package io.paioneer.nain.companylist.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.paioneer.nain.companylist.jpa.entity.CompanylistEntity;
import io.paioneer.nain.member.jpa.entity.QMemberEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CompanylistRepositoryCustomImpl implements CompanylistRepositoryCustom {
    //private final JPAQueryFactory queryFactory;
    //private final EntityManager entityManager;
    //private final QMemberEntity companylist = QMemberEntity;

    public List<CompanylistEntity> selectCompanyList(String sorting) {
        return null;
    }
    public List<CompanylistEntity> selectCompanySearchList(String keyword) {
        return null;
    }
    public List<CompanylistEntity> selectPostSearchList(String keyword){
        return null;
    }

}
