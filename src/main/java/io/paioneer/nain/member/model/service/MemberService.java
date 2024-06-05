package io.paioneer.nain.member.model.service;

import io.paioneer.nain.member.jpa.entity.Member;
import io.paioneer.nain.member.jpa.repository.MemberRepository;
import io.paioneer.nain.member.model.dto.MemberDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberDto insertMemberRegister(MemberDto memberDto) {

        return memberRepository.save(memberDto.toEntity()).toDto();
    }

    public Long selectEmailCheck(String email) {
        Optional<Member> member = memberRepository.findByMemberEmail(email);
        if (member.isPresent()) {
            return member.get().getMemberEmail();
        }else{
            return 0L;
        }
    }

}








