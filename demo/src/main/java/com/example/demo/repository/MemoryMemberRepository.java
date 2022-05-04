package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//구현체, interface를 implements해본다

public class MemoryMemberRepository implements MemberRepository{

    //저장소
    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence =0L;


    @Override
    public Member save(Member member) {
        //ID는 시스템이 정해줄거기에 setID
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //store의 메서드들로 추측 키가 id
        return Optional.ofNullable(store.get(id));

    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member->member.getName().equals(name))
                .findAny();

    }
//map이지만 return은 list
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //clear하는 함수
    public void clearStore(){
        store.clear();
    }
}
