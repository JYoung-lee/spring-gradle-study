package study.springstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import study.springstudy.service.MemberService;

@Controller
public class MemberController {


    private final MemberService memberService;

    /*
    setter 주입 방법
        public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
        }

    필드 주입 방법
        @Autowired private MemberService memberService;
    */

    //생성자 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
