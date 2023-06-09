package com.example.core.order;

import com.example.core.annotation.MainDiscountPolicy;
import com.example.core.discount.DiscountPolicy;
import com.example.core.discount.FixDiscountPolicy;
import com.example.core.discount.RateDiscountPolicy;
import com.example.core.member.Member;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
//@RequiredArgsConstructor//final이 붙은 애들 갖고 자동으로 constructor 생성
public class OrderServiceImpl implements OrderService {

//    @Autowired private MemberRepository memberRepository;필드 주입(권장하지 않음)
//    @Autowired private DiscountPolicy discountPolicy;     -> 외부에서 테스트하기 힘듬, 결국 setter를 만들어야함..

    private final MemberRepository memberRepository;//final은 값이 항상 있어야 함
    private final DiscountPolicy discountPolicy;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //DIP원칙 위배
    //private  DiscountPolicy discountPolicy = new RateDiscountPolicy(); //OCP원칙 위배

    //수정자 주입
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    //생성자가 하나 있으면 Autowired를 안붙여도 된다. 그리고 생성자 주입을 쓰자!
    public OrderServiceImpl(MemberRepository memberRepository
            , /*@Qualifier("mainDiscountPolicy")*/ @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
        //같은 구현체가 있을 때는 필드명으로 빈 이름 매칭 가능
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }



    //test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
