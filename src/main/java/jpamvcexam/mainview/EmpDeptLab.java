package jpamvcexam.mainview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EmpDeptLab {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");

        EntityManager em = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        boolean result = random.nextBoolean();
        System.out.println(result);

        if (!result) {
            System.out.print("부서명을 입력하세요 :");
            String deptName = scanner.nextLine();
            scanner.close();

            String ql = "SELECT e.ename FROM Emp e join e.dept d where e.dept.dname = :dn AND e.deptno = d.deptno";

            TypedQuery<String> q = em.createQuery(ql, String.class);
            q.setParameter("dn", deptName);
            List<String> list = q.getResultList();
            if (list.size() == 0) {
                System.out.println("직원을 찾을 수가 없네요..ㅠ");
            } else {
                list.stream().forEach(System.out::println);
            }
        } else {
            System.out.println("사원명을 입력하세요");
            String eName = scanner.nextLine();
            scanner.close();

            String ql = "SELECT e.dept.dname FROM Emp e join e.dept d WHERE e.ename = :en AND d.deptno = e.dept.deptno";

            TypedQuery<String> q = em.createQuery(ql, String.class);
            q.setParameter("en", eName);
            List<String> list = q.getResultList();

            if (list.size() == 0) {
                System.out.println("부서를 찾을 수가 없습니다.");
            } else {
                System.out.printf("%s님은 %s 부서입니다.", eName, list.get(0));
            }
        }
        scanner.close();
        em.close();
        factory.close();
    }
}
