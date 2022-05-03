package com.example.demo.service;

import com.example.demo.domain.Member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class MemberServiceTest {
    MemberService memberService = new MemberService();
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        //static import는 alt+enter
        Member findMember = memberService.findOne(saveId).get(); //바로 결과를 get으로 받고
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    @Test
    public void dupicate_member(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        //중복 예외 잡기
        memberService.join(member1);
        try{
            memberService.join(member2);
            fail("예외가 발생해야합니다");
        }catch(IllegalArgumentException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

        }

       //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}