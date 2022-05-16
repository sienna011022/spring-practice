package com.example.demo.domain;


import javax.persistence.*;

//jpa가 관리하는entity-jpa 가 sql쿼리도 자동 처리해줌
@Entity
public class Member {
    @Id //pk mapping
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="usernmae")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


