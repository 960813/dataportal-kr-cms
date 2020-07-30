package kr.dataportal.cms.service;

import kr.dataportal.cms.domain.Member;
import kr.dataportal.cms.domain.MemberRole;
import kr.dataportal.cms.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> memberEntityWrapper = memberRepository.findByUsername(username);
        Member memberEntity = memberEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("local:admin").equals(memberEntity.getAuthId())) {
            authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
        }
        authorities.add(new SimpleGrantedAuthority(MemberRole.MEMBER.getValue()));

        return new User(memberEntity.getUsername(), memberEntity.getPassword(), authorities);
    }

    /**
     * 회원 가입
     *
     * @param member
     * @return member's id
     */
    public Long join(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member).getId();
    }

    // TODO: 2020-07-30 오후 9:38 Id를 기반으로 중복 여부 판단 -Jinssssun
    private void validateDuplicateMember(Member member) {
        memberRepository.findByUsername(member.getUsername())
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

    /**
     * username을 기반으로 회원 조회
     *
     * @param username
     * @return Optional Member
     */
    // TODO: 2020-07-30 오후 3:29 -Jinssssun
    public Optional<Member> findOne(String username) {
        return memberRepository.findByUsername(username);
    }
}
