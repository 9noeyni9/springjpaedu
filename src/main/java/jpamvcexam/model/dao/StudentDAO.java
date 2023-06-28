package jpamvcexam.model.dao;

import jpamvcexam.model.vo.Student;

import javax.persistence.*;
import java.util.List;

public class StudentDAO {

    private EntityManagerFactory factory;

    public StudentDAO() {
        super();
        factory = Persistence.createEntityManagerFactory("emptest");
    }/*entity메모리 객체 생성 연동하는 db서버는 같음*/

    public boolean insertStudent(Student entity) {
        boolean result = true;

        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            result = false;
        }
        em.close();
        return result;
    }

    public List<Student> getAllStudent() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> list = q.getResultList();
        em.close();
        return list;
    }

    public Student getScore(String name) {
        EntityManager em = factory.createEntityManager();
//        TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s", Student.class); // find를 사용하면 query자체가 필요 없음
        Student entity = em.find(Student.class, name);
        em.close();
        return entity;
    }

    public boolean updateStudent(Student entity){
        boolean result = true;
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            Student oldEntity = em.find(Student.class, entity.getName());
            oldEntity.setScore(entity.getScore());
            em.getTransaction().commit();
        }catch (Exception e){
            result = false;
            System.out.println(e);
        }
        em.close();
        return result;
    }

    public boolean deleteStudent(String name){
        boolean result = true;
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            Student entity = em.find(Student.class, name);
            em.remove(entity);
            em.getTransaction().commit();
        }catch (Exception e){
            result = false;
        }
        em.close();
        return result;
    }

    public  void close(){
        factory.close();
    }
}