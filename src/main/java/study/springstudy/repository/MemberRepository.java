package study.springstudy.repository;

import study.springstudy.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원 저장 : C
    Optional<Member> findbyId(Long id); //회원아이디로 찾기 : R
    Optional<Member> findbyName(String name); //회원이름으로 찾기 : R
    List<Member> findAll(); //회원 모두 찾기 : R

}
