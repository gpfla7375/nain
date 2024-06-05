package io.paioneer.nain.trend.jpa.repository;

import io.paioneer.nain.member.jpa.repository.MemberRepositoryCustom;
import io.paioneer.nain.trend.jpa.entity.TrendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendRepository extends JpaRepository<TrendEntity, Long>{
}
