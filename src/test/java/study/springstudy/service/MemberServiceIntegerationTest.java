package study.springstudy.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.springstudy.domain.Member;
import study.springstudy.repository.MemberRepository;
import study.springstudy.repository.MemoryMamberRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegerationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given 무엇
        Member member = new Member();
        member.setName("spring");
        //when 검증
        Long saveId = memberService.join(member);

        //then 결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);


        //then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
    @Test
    void findMembers() {
        //given
        Member member = new Member();
        member.setName("spring1");
        memberService.join(member);

        Member member2 = new Member();
        member2.setName("spring2");
        memberService.join(member2);

        Member member3 = new Member();
        member3.setName("spring3");
        memberService.join(member3);

        //when
        List<Member> members = memberService.findMembers();

        //then
        assertThat(members.size()).isEqualTo(3);
    }

    @Test
    void findOne() {
        //given
        Member member = new Member();
        member.setName("spring");
        memberService.join(member);

        //when
        Optional<Member> result = memberService.findOne(member.getId());

        //then
        assertThat(result.get().getName()).isEqualTo("spring");

    }
}