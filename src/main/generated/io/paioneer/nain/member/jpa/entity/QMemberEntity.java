package io.paioneer.nain.member.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = 1389880172L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final StringPath admin = createString("admin");

    public final DateTimePath<java.util.Date> expireDate = createDateTime("expireDate", java.util.Date.class);

    public final StringPath memberEmail = createString("memberEmail");

    public final StringPath memberName = createString("memberName");

    public final StringPath memberNickName = createString("memberNickName");

    public final StringPath memberNo = createString("memberNo");

    public final StringPath memberPwd = createString("memberPwd");

    public final DateTimePath<java.util.Date> memberUpdate = createDateTime("memberUpdate", java.util.Date.class);

    public final DateTimePath<java.util.Date> paymentDate = createDateTime("paymentDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> signUpDate = createDateTime("signUpDate", java.util.Date.class);

    public final StringPath subscribeYN = createString("subscribeYN");

    public final DateTimePath<java.util.Date> withDrawalDate = createDateTime("withDrawalDate", java.util.Date.class);

    public QMemberEntity(String variable) {
        super(MemberEntity.class, forVariable(variable));
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEntity(PathMetadata metadata) {
        super(MemberEntity.class, metadata);
    }

}

