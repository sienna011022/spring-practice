package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


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

    @GetMapping(value = "/members/new")
    public String createform(){
        return "members/createMemberForm";
    }
    //post는 전달할때-data를  등록할때
    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        System.out.println("member="+member.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        //addAttribute
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
