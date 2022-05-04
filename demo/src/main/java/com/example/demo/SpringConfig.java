package com.example.demo;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;
//자바 코드로 등록하기

@Configuration
public class SpringConfig {
    //memberService를 bean에 등록해줄건데 memberService에 memberReposiotry도 넣어야하니깐, 그것도 등록
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
