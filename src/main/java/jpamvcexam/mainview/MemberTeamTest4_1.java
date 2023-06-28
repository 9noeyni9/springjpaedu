package jpamvcexam.mainview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class MemberTeamTest4_1 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        Scanner scan = new Scanner(System.in);
        System.out.print("멤버명을 입력하세요 : ");
        String inputName = scan.nextLine();
        scan.close();
             
        String jpql = "select t.teamName from Member m join m.team t where m.username = :un";//먼저 등장하는 테이블이 기준이 되어야 함
        //멤버가 속해있는 팀 이름 추출
        
        TypedQuery<String> q = em.createQuery(jpql, String.class);
        q.setParameter("un", inputName);
        List<String> list = q.getResultList();

        //추출된 데이터가 없을 때 예외 발생이 아니라 "팀을 찾을 수가 없네요"로 변경해본다.
        if (list.size() == 0) {
        	System.out.print("팀을 찾을 수 없네요..ㅜㅜ ");
        } else {
        	System.out.printf("%s님의 팀명은 %s입니다...\n", inputName, list.get(0));
        }
        em.close();
        factory.close();
	}
}
