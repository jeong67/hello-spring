package hello.hellospring;

import hello.hellospring.member.Grade;
import hello.hellospring.member.Member;
import hello.hellospring.member.MemberService;
import hello.hellospring.member.MemberServiceImpl;
import hello.hellospring.order.Order;
import hello.hellospring.order.OrderService;
import hello.hellospring.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        // 새로운 Member를 만드는 과정

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("orderCalculatePrice = " + order.calculatePrice());

    }
}
