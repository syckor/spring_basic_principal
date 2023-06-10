package com.example.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; //추상화에만 의존하고 구체 클래스는 몰라도 된다. dip 원칙 지킴

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
}
