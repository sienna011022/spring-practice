package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
@Transactional
//데이터를 변경할 때 사용하는것

public class JpaMemberRepository implements MemberRepository {
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    //persist - 저장

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member =  em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
       List <Member> result = em.createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name",name)
                .getResultList();
       return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //객체한테 query를 던지는 방식 이미 매핑이 다 되어있어 member만 넣어주기
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }
}
