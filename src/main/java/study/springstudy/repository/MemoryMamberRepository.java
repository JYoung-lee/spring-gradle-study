package study.springstudy.repository;

import study.springstudy.domain.Member;

import java.util.*;

public class MemoryMamberRepository implements MemberRepository {

    private Map<Long, Member> stroe = new HashMap<>();
    private static Long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        stroe.put(member.getId(), member);

        return member;

    }

    @Override
    public Optional<Member> findbyId(Long id) {
        return Optional.ofNullable(stroe.get(id)); //null인 경우에도 반환해준다.
    }

    @Override
    public Optional<Member> findbyName(String name) {
        return stroe.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(stroe.values());
    }

    public void clearStore(){
        stroe.clear();
    }

}
