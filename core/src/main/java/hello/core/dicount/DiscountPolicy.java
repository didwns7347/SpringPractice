package hello.core.dicount;

import hello.core.Member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);

}
