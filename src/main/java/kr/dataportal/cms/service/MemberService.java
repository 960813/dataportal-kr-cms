package kr.dataportal.cms.service;

import kr.dataportal.cms.domain.Member;
import kr.dataportal.cms.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     *
     * @param member
     * @return member's id
     */
    public Long join(Member member) {
        validateDuplicateMember(member);
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        return memberRepository.save(member).getId();
    }

    // TODO: 2020-07-30 오후 3:26 authId를 기반으로 중복 여부 판단 -Jinssssun
    private void validateDuplicateMember(Member member) {
        memberRepository.findByAuthId(member.getAuthId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }


    /**
     * id를 기반으로 회원 조회
     *
     * @param id
     * @return Optional Member
     */
    // TODO: 2020-07-30 오후 3:29 -Jinssssun
    public Optional<Member> findOne(long id) {
        return memberRepository.findById(id);
    }
}
