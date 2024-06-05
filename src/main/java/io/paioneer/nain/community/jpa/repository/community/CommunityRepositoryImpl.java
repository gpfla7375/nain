package io.paioneer.nain.community.jpa.repository.community;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.paioneer.nain.community.jpa.entity.CommunityEntity;
import io.paioneer.nain.community.jpa.entity.QCommunityEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommunityRepositoryImpl implements CommunityRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;
    private  QCommunityEntity communityEntity = QCommunityEntity.communityEntity;

    @Override
    public CommunityEntity selectCommunityOne(Long communityNo) {
        return queryFactory
                .selectFrom(communityEntity)
                .where(communityEntity.communityNo.eq(communityNo))
                .fetch().get(0);
    }

    @Override
    public List<CommunityEntity> selectCommunityList(Pageable pageable) {
        return queryFactory
                .selectFrom(communityEntity)
                .limit(pageable.getPageSize())
                .fetch();
    }
}
