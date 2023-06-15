package com.example.core;


import com.example.core.member.MemberRepository;
import com.example.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "com.example.core.member",
        /*basePackages가 없으면 현재 페이지의 경로의 하위(com.example.core)를 찾는다
          관례적으로 설정 정보 클래스의 위치를 프로젝트 최상단에 둔다.
        * */
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
/*
    @Bean(name = "memoryMemberRepository") //수동 빈이 우선권을 가진다. 최근 버전은 중복 빈이 발생하면 에러를 내뱉는다
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
*/
}