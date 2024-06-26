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


    //회원가입
    @PostMapping("/register")
    public ResponseEntity<Void> insertMemberRegister(@RequestBody MemberDto memberDto) {
        log.info(("insertMemberRegister : " + memberDto));
        memberService.insertMemberRegister(memberDto);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //이메일 중복확인
    @GetMapping("/check-email")
    public ResponseEntity<Long> selectEmailCheck(@RequestParam String email) {
        Long memberEmail = memberService.selectEmailCheck(email);
        return new ResponseEntity<>(memberEmail, HttpStatus.OK);
    }



}
