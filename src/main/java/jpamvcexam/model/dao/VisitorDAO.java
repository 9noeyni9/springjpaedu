package jpamvcexam.model.dao;

import jpamvcexam.model.vo.Visitor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class VisitorDAO {
	
	private EntityManagerFactory factory;
	
	public VisitorDAO() {
		super();
		factory = Persistence.createEntityManagerFactory("emptest");
	}

	public List<Visitor> listAll() {		
		EntityManager em = factory.createEntityManager();
		TypedQuery<Visitor> q = em.createQuery("select t from Visitor t", Visitor.class);
		List<Visitor> list = q.getResultList();
		em.close();
		return list;
	}

	public Visitor one(int id) {
		EntityManager em = factory.createEntityManager();
		Visitor vo = em.find(Visitor.class, id);
		em.close();
		return vo;
	}

	public List<Visitor> search(String keyword) {
		EntityManager em = factory.createEntityManager();
		TypedQuery<Visitor> q = em.createQuery("select t from Visitor t WHERE t.memo like :keyword", Visitor.class);
		q.setParameter("keyword", "%" + keyword + "%");
		List<Visitor> list = q.getResultList();
		em.close();
		return list;
	}

	public boolean insert(Visitor vo) {
		boolean result = true;
		EntityManager em = factory.createEntityManager();
		try {			
			em.getTransaction().begin();
			em.persist(vo);
			em.getTransaction().commit();
		} catch (Exception e) {
			result = false;
		}
		em.close();
		return result;
	}
	
	public boolean delete(int id) {
		boolean result = true;
		EntityManager em = factory.createEntityManager();
		try {		
			em.getTransaction().begin();
			Visitor vo = em.find(Visitor.class, id);
			em.remove(vo);
			em.getTransaction().commit();
		} catch (Exception e) {
			result = false;
		}
		em.close();
		return result;
	}
	
	public boolean update(Visitor vo) {
		boolean result = true;
		EntityManager em = factory.createEntityManager();
		try {			
			em.getTransaction().begin();
			Visitor oldVo = em.find(Visitor.class, vo.getId());/*수정할 글 id의 entity객체 받아옴*/
			System.out.println(oldVo.getName());
			oldVo.setName(vo.getName());/*setting해서 바꿔주면 됨*/
			oldVo.setMemo(vo.getMemo());/*setting해서 바꿔주면 됨*/
			em.getTransaction().commit();/*commit: commit했을 때 update쿼리 날려줌*/
		} catch (Exception e) {
			result = false;
		}
		em.close();
		return result;
	}
	public void close() {
		if (factory != null)
			factory.close();
	}
}