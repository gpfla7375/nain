package io.paioneer.nain.community.jpa.repository.comment;

import io.paioneer.nain.community.jpa.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long>, CommentRepositoryCustom{
}
