package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.Member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //조회 할때마다 객채를 생성
        MemberService m1 = appConfig.memberService();
        MemberService m2 = appConfig.memberService();
        //서로 다른 객채임
        System.out.println("memberService1 = "+m1);
        System.out.println("memberService2 = "+m2);

        assertThat(m1).isNotSameAs(m2);
    }
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        assertThat(singletonService1).isSameAs(singletonService2);
        assertThat(singletonService2).isEqualTo(singletonService1);
    }
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //AppConfig appConfig = new AppConfig();
        //조회 할때마다 객채를 생성
        MemberService m1 = ac.getBean("memberService",MemberService.class);
        MemberService m2 = ac.getBean("memberService",MemberService.class);
        //서로 다른 객채임
        System.out.println("memberService1 = "+m1);
        System.out.println("memberService2 = "+m2);

        assertThat(m1).isSameAs(m2);
    }
}
