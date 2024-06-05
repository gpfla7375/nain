package io.paioneer.nain.community.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.paioneer.nain.community.jpa.entity.QCommunityEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommunityRepository {
    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManger;
    private  QCommunityEntity communityEntity = QCommunityEntity.communityEntity;
}
