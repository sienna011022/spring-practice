package com.example.demo;


import com.example.demo.aop.TimeTeaceAop;
import com.example.demo.repository.*;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.sql.DataSource;
//자바 코드로 등록하기
@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    //주입받기
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


}

/*@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;

    @Autowired
    public SpringConfig(DataSource dataSource,EntityManager em){
        this.dataSource = dataSource;
        this.em = em;
    }

    //memberService를 bean에 등록해줄건데 memberService에 memberReposiotry도 넣어야하니깐, 그것도 등록
    //bean을 이용하면 구현 클래스 변경시 여기만 변경하면 되어 완전 편리하다
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }




    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
       //return new JdbcTemplateMemberRepository(dataSource);
       //return new JpaMemberRepository(em);
        return
    }
}*/
