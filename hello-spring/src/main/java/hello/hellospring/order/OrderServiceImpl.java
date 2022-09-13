package hello.hellospring.order;

import hello.hellospring.discount.DiscountPolicy;
import hello.hellospring.member.Member;
import hello.hellospring.member.MemberRepository;
import hello.hellospring.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //<이렇게 진행하려면 OrderServiceImpl 의 코드를 고쳐야한다.> == OCP 위반

    //Fix 와 Rate 의 따로 잘 사용할 수 있도록 역할과 구현을 충실하게 분리하고 다형성과 인터페이스의 구현 객체를 질 분리한 것 처럼 보인다.\
    //그래서 OCP 와 DIP 같은 객체지향 설계 원칙을 충실히 준수해보이지만 그렇지 않다.
    //추상(인터페이스) -> DiscountPolicy 뿐만 아니라 구현 클래스 -> Fix, RateDiscountPolicy 에도 의존하고 있다. == DIP 위반(구현이 아니라 인터페이스에 의존하라는 것)
    //Fix 에서 Rate 로 OrderServiceImpl 의 코드를 고쳐야한다 == OCP 위반. like 기름차에서 전기차로 바꾸면 운전면허증을 다시 따야하는 것.

    //<DIP 를 지키기 위해 DiscountPolicy 에만 의존하도록 변경하자>
    //private DiscountPolicy discountPolicy;

    //이렇게만 하고 Test Run 을 하면 구현체가 없기 때문에 NPE 가 터진다.
    //이 문제를 해결하려면 누군가가 OrderServiceImpl 에 DiscountPolicy 의 구현 객체를 대신 생성하고 주입해주어야 한다.

//  <DIP 와 OCP 를 지키면서 NPE 가 터지지 않도록 하자>

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //현재 생성자를 통해서 memberRepository 가 넘어가고 discountPolicy 가 넘어가서 값이 할당된다.
    //철저하게 DIP 를 지키고 있다.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //memberRepository에 저장.
        int discountPrice = discountPolicy.discount(member, itemPrice); //OrderService 입장에서는 할인은 discountPolicy가 알아서 해주고 결론만 던져줘. = 단일 책임의 원칙이 잘 적용됨.

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
