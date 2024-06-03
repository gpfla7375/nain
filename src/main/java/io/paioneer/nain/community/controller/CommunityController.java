package io.paioneer.nain.community.controller;

import io.paioneer.nain.community.model.service.CommentService;
import io.paioneer.nain.community.model.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/community")
@CrossOrigin
public class CommunityController {
    private final CommunityService communityService;
    private final CommentService commentService;

}
