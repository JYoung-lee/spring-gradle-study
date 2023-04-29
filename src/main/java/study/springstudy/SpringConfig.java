package study.springstudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springstudy.repository.MemberRepository;
import study.springstudy.repository.MemoryMamberRepository;
import study.springstudy.service.MemberService;

@Configuration
public class SpringConfig {


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMamberRepository();
    }

}
