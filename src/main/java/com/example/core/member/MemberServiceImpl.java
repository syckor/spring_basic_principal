package com.example.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; //추상화에만 의존하고 구체 클래스는 몰라도 된다. dip 원칙 지킴

    @Autowired //memberRepository에 맞는 구현체를 자동으로 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //test용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
