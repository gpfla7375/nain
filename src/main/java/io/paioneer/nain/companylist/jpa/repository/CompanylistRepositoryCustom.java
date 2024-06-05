package io.paioneer.nain.companylist.jpa.repository;

import io.paioneer.nain.companylist.jpa.entity.CompanylistEntity;

import java.util.List;

public interface CompanylistRepositoryCustom {
    List<CompanylistEntity> selectCompanyList(String sorting);
    List<CompanylistEntity> selectCompanySearchList(String keyword);
    List<CompanylistEntity> selectPostSearchList(String keyword);
}
