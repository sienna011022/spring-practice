package com.example.demo.controller;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//annotaion 뜰때 관리
@Controller
public class MemberController {
    //스프링 컨테이너에 하나 등록
    private final MemberService memberService;

    //컨트롤러와 서비스 연결
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
