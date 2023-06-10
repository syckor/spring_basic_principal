package com.example.core;

import com.example.core.discount.DiscountPolicy;
import com.example.core.discount.FixDiscountPolicy;
import com.example.core.discount.RateDiscountPolicy;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;
import com.example.core.member.MemoryMemberRepository;
import com.example.core.order.OrderService;
import com.example.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    } //생성자 주입

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        /*정액할인에서 정률할인정책으로 바뀐다면 이 부분의 return값만 바꾸면 된다.
        * */
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
