package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//JPA는 JPArepository받아야함 key,id = 식별자
//findByName-이거 하나만이라도 select m from Member m where name :name;이렇게 찾아주는거임

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long> ,MemberRepository{
    @Override
    Optional<Member> findByName(String name);
}
