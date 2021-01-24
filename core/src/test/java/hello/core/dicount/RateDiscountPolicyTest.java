package hello.core.dicount;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip 10% discount ")
    void vip_o(){
        Member member = new Member(1L,"memberVIP", Grade.VIP);

        int discount= discountPolicy.discount(member,10000);

        org.assertj.core.api.Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP아니면 할인 적용 x")
    void vip_x(){
        Member member = new Member(2L,"memberB", Grade.BASIC);

        int discount= discountPolicy.discount(member,10000);

        org.assertj.core.api.Assertions.assertThat(discount).isEqualTo(0);

    }



}