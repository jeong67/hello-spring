package hello.hellospring;

import hello.hellospring.discount.FixDiscountPolicy;
import hello.hellospring.member.MemberService;
import hello.hellospring.member.MemberServiceImpl;
import hello.hellospring.member.MemoryMemberRepository;
import hello.hellospring.order.OrderService;
import hello.hellospring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    //어딘가에서 AppConfig 를 통해서 memberService 를 사용 할 때 MemoryRepository 를 사용하게 됨.


    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

    }

}
