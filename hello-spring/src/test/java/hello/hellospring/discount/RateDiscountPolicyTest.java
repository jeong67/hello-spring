package hello.hellospring.discount;

import hello.hellospring.member.Grade;
import hello.hellospring.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vio_o() {
        Member member =new Member(1L, "memberVIP", Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000); //static import를 통해서 Assertions.assertThat이 아니라 assertThat으로 바로 사용할 수 있다. == 테스트의 의도를 한눈에 파악할 수 있다.
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vio_X() {
        Member member =new Member(2L, "memberBASIC", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }

}