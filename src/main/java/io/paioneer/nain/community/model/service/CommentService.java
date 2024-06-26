package io.paioneer.nain.community.model.service;

import io.paioneer.nain.community.jpa.repository.comment.CommentRepositoryImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepositoryImpl commentRepository;
}
