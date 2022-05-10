package com.example.demo.service;
//통합테스트-컨테이너까지 다같이 올려서 test ,단위테스트 - 순수 자바코드
import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
//test실행하고 DB를 rollback를 해줌 - transactional
class MemberServiceIntegrationTest {

    //컨테이너에 등록된 빈을 달라

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        //static import는 alt+enter
        Member findMember = memberService.findOne(saveId).get(); //바로 결과를 get으로 받고
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    @Test
    public void duplicate_member(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        //중복 예외 잡기
        memberService.join(member1);
        IllegalArgumentException e =  assertThrows(IllegalArgumentException.class,()->memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        try{
//            memberService.join(member2);
//            fail("예외가 발생해야합니다");
//        }catch(IllegalArgumentException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");



       //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}