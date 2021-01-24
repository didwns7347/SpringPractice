package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("빈 이름 조회하기")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회하기")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 조회하기 X")
    void findBeanByNameX(){
        //없는 이름으로 조회
       // MemberService xxxx=ac.getBean("xxxxx",MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxxx",MemberService.class));
    }


}
