package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    // jpa 사용시 꼭 사용해야하는 클래스
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member =  em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) { // jpql
        List<Member> result =  em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name" ,name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() { // jpql
        // Member Entity 자체를 조회 해줌 ^.^
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
