<<<<<<< HEAD
package io.paioneer.nain.notice.controller;

import io.paioneer.nain.notice.model.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
@CrossOrigin
public class NoticeController {
    private final NoticeService noticeService;



}

=======
package io.paioneer.nain.notice.controller;

import io.paioneer.nain.notice.model.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
@CrossOrigin
public class NoticeController {
    private final NoticeService noticeService;



}

>>>>>>> ef6239d6e78f36c17ac5809f35a9b1aa69dc937d
