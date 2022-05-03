package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
//4가지 기능 -함수 같은 느낌
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member>findByName(String name);
    List<Member> findAll();




}
