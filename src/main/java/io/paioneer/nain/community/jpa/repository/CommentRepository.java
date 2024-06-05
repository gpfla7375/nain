package io.paioneer.nain.community.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.paioneer.nain.community.jpa.entity.QCommentEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManger;
    private QCommentEntity commentEntity = QCommentEntity.commentEntity;

}
