package io.paioneer.nain.trend.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.paioneer.nain.trend.jpa.entity.QTrendEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TrendRepositoryImpl implements TrendRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    private final EntityManager  entityManager;
    private QTrendEntity trend = QTrendEntity.trendEntity;
}
