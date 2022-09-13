package hello.hellospring;

import hello.hellospring.discount.FixDiscountPolicy;
import hello.hellospring.member.MemberService;
import hello.hellospring.member.MemberServiceImpl;
import hello.hellospring.member.MemoryMemberRepository;
import hello.hellospring.order.OrderService;
import hello.hellospring.order.OrderServiceImpl;

public class AppConfig {
    //실제 동작에 필요한 구현 객체를 생성한다.
    //객체를 생성하고 연결하는 역할과 실행하는 역할이 명확히 분리되었다 == 관심사를 확실하게 분리했다.



    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    //어딘가에서 AppConfig 를 통해서 memberService 를 사용 할 때 MemoryRepository 를 사용하게 됐다.


    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

    }

}
