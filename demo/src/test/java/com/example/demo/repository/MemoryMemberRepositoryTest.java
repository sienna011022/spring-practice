package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //result 값과 member값이 같은지 안같은지 비교
        assertThat(member).isEqualTo(result);
///clear해줘야하는걸 만들어야함

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring3");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("spring4");
        repository.save(member2);
        //get으로 꺼내주기
        Member result = repository.findByName("spring3").get();

        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll(){
        Member member = new Member();
        member.setName("spring1");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("spring2");
        repository.save(member1);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);



    }
}
