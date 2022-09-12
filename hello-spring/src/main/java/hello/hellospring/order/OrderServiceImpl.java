package hello.hellospring.order;

import hello.hellospring.discount.DiscountPolicy;
import hello.hellospring.discount.FixDiscountPolicy;
import hello.hellospring.member.Member;
import hello.hellospring.member.MemberRepository;
import hello.hellospring.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //memberRepository에 저장.
        int discountPrice = discountPolicy.discount(member, itemPrice); //OrderService 입장에서는 할인은 discountPolicy가 알아서 해주고 결론만 던져줘. = 단일 책임의 원칙이 잘 적용됨.

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
