package io.paioneer.nain.community.jpa.repository.comment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.paioneer.nain.community.jpa.entity.CommentEntity;
import io.paioneer.nain.community.jpa.entity.QCommentEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManger;
    private QCommentEntity commentEntity = QCommentEntity.commentEntity;

    @Override
    public List<CommentEntity> selectCommentList(Long communityNo) {
        return queryFactory
                .selectFrom(commentEntity)
                .where(commentEntity.communityNo.eq(communityNo))
                .fetch();
    }
}
