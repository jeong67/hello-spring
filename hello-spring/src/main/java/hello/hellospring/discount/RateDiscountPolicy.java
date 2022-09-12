package hello.hellospring.discount;

import hello.hellospring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(Member member, int price) {
        return 0;
    }
}
