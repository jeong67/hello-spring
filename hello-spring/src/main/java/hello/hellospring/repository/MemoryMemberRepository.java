package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence); //Id 저장하기
        store.put(member.getId(), member);//sequence에 저장된 Id 꺼내기
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(store.get(id)); //null타입으로 반환될 때 Optional로 감싸서 반환, getId함수가 아니라 hashmap sotre에 대한 .get임
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member-> member.getName().equals(name))
                .findAny(); //조건에 일치하는 요소 하나 리턴 병렬로 처리할 때 마다 달라짐


    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

