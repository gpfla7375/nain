package io.paioneer.nain.member.controller;


import io.paioneer.nain.member.model.dto.MemberDto;
import io.paioneer.nain.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
@CrossOrigin
public class MemberController {
    private final MemberService memberService;
    private final MemberDto memberDto;

    @PostMapping("/register")
    public ResponseEntity<Void> insertMemberRegister(@RequestBody MemberDto memberDto) {
        log.info((""));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }





}
