package jpamvcexam.mainview;

import jpamvcexam.model.vo.EmpVO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class HelloJpa3 {
	@SuppressWarnings("unchecked")
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("select t from EmpVO t", EmpVO.class);//t: 모든 열을 추출하겠다
        List<EmpVO> empVOList = q.getResultList();/*getResultList: 추출한 값을 list로 추출하겠다.*/
        for (Object vo : empVOList) {
            System.out.println(vo);
        }
        System.out.println("데이터 갯수 : " + empVOList.size());
        em.close();
        factory.close();
    }
}
