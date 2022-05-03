package com.example.demo.service;

import com.example.demo.domain.Member;

import com.example.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberServiceTest {
    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    @AfterEach
    public void AfterEach(){
        memberRepository.clearStore();
    }
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