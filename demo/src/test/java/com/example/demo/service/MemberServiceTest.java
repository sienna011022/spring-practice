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
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}