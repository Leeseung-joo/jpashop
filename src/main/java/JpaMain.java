import org.example.domain.Member;
import org.example.domain.Team;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");


        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();  //em을 마치 자바 컬렉션처럼 객체를 대신 저장해주는 놈이라 생각하기
        try {

            Member member = new Member();
            member.setName("member1");
            em.persist(member);

            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username = :username", Member.class);
                    query.setParameter("username", "member1");
                    Member singleResult = query.getSingleResult();
                    System.out.println("singleResult = " + singleResult.getUserName());


        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

}

