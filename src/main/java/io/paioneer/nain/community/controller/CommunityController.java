package io.paioneer.nain.community.controller;

import io.paioneer.nain.community.model.dto.CommentDto;
import io.paioneer.nain.community.model.dto.CommunityDto;
import io.paioneer.nain.community.model.service.CommentService;
import io.paioneer.nain.community.model.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/community")
@CrossOrigin
public class CommunityController {
    private final CommunityService communityService;
    private final CommentService commentService;

    private final CommunityDto communityDto;
    private final CommentDto commentDto;

    @GetMapping("/list")
    public ResponseEntity<ArrayList<CommunityDto>> selectCommunitylList(@RequestParam(name="page") int page, @RequestParam(name="limit") int limit){
        log.info("/community/list{}, {}", page, limit);
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "communityNo"));
        return new ResponseEntity<>(communityService.selectList(pageable), HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<CommunityDto> selectCommunityDetail(@RequestParam(name="communityNo") Long communityNo){
        log.info("/community/detail{}, {}", communityNo);
        return new ResponseEntity<>(communityService.selectOne(communityNo), HttpStatus.OK);
    }

//    @GetMapping("")

}
