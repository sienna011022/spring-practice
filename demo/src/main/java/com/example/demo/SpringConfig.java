package com.example.demo;

import com.example.demo.repository.JdbcTemplateMemberRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
//자바 코드로 등록하기

@Configuration
public class SpringConfig {
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //memberService를 bean에 등록해줄건데 memberService에 memberReposiotry도 넣어야하니깐, 그것도 등록
    //bean을 이용하면 구현 클래스 변경시 여기만 변경하면 되어 완전 편리하다
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }



    private final DataSource dataSource;

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
       return new JdbcTemplateMemberRepository(dataSource);
    }
}
