package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;


import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    //memberrepository를 외부에서 넣어주게끔 바꾼다
    //스프링이 멤버서비스에등록해줌
    //

    //repository랑 연결
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //회원가입

    public Long join(Member member){
        //optional로 감싸면 optional을 통한 많은 함수 사용가능.이미 optional로 감싸짐
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m-> {
                        throw new IllegalArgumentException("이미 존재하는 회원입니다");
                        });


    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member>findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
