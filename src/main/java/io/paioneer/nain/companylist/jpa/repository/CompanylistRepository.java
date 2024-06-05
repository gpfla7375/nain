package io.paioneer.nain.companylist.jpa.repository;

import io.paioneer.nain.companylist.jpa.entity.CompanylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanylistRepository extends JpaRepository<CompanylistEntity,Long>, CompanylistRepositoryCustom {

}
