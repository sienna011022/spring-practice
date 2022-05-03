package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
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
