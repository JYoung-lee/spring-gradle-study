package study.springstudy.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import study.springstudy.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    /*
    * 현재 테스트 : 사용해야하는 클래스를 구현하고 테스트를 한경우
    * TDD : 테스트를 통하여 구현내용을 구현하고 사용클래스를 만든다. 선 테스트 후 개발
    * */

    MemoryMamberRepository repository = new MemoryMamberRepository();

    @AfterEach //테스트 1개 메서드 실행 이후 작동
    public void afterEach(){
        repository.clearStore(); // 저장데이터 clear
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findbyId(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findbyName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
