package hello.hellospring;

import hello.hellospring.member.Grade;
import hello.hellospring.member.Member;
import hello.hellospring.member.MemberService;
import hello.hellospring.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

//        <OPC, DIP 를 위반했을 때>
//        MemberService memberService = new MemberServiceImpl();
//
//        Member member = new Member(1L, "memberA", Grade.VIP);
//
//        memberService.join(member);
//
//        Member findMember = memberService.findMember(1L);
//
//        System.out.println("member = " + findMember);

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //memberService 인터페이스를 받는다.(이 안에는 MemberServiceImpl 이 들어가 있다)
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + findMember);



    }

}
