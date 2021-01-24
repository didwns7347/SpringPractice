package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService s1 = ac.getBean(StatefulService.class);
        StatefulService s2 = ac.getBean(StatefulService.class);
        //Thread A: A사용자 만원 주문
        s1.order("userA",10000);
        //Thread B: B사용자 2만원 주문
        s2.order("userB",20000);

        //ThreadA: 사용자A 주문 금액 조회
        int price = s1.getPrice();
        System.out.println("price = "+ price);
        Assertions.assertThat(price).isEqualTo(20000);


    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
