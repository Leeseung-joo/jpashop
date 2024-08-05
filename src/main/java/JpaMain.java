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
            Team team = new Team(); //저장
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            em.persist(member);

            team.addMember(member); //연관관계 메서드는 둘 중 하나만 만들기

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId()); //1차 캐시
            List<Member> members = findTeam.getMembers();
            System.out.println(" ===========");
            for (Member m: members){

                System.out.println("m = " + m.getName());
            }
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

}

