package io.paioneer.nain.notice.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.paioneer.nain.notice.jpa.entity.QNoticeEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NoticeQueryRepository {

    private final JPAQueryFactory queryFactory;

    private final EntityManager entityManager;

    private QNoticeEntity notice = QNoticeEntity.noticeEntity;





}
