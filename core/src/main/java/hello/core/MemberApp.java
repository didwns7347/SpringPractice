package hello.core;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class MemberApp
{
    public static void main(String[] args){
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext=new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService",MemberService.class);
        Member member = new Member(1L, "MemberA",Grade.VIP);
        memberService.join(member);

        Member findM=memberService.findById(1l);
        System.out.println("new member ="+member.getName());
        System.out.println("find member ="+ findM.getName());



    }
}