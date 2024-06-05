package io.paioneer.nain.notice.model.service;

import io.paioneer.nain.notice.jpa.repository.NoticeQueryRepository;
import io.paioneer.nain.notice.jpa.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private final NoticeQueryRepository noticeQueryRepository;



}
