package io.paioneer.nain.community.jpa.repository.comment;

import io.paioneer.nain.community.jpa.entity.CommentEntity;

import java.util.List;

public interface CommentRepositoryCustom {
    List<CommentEntity> selectCommentList(Long communityNo);
}
