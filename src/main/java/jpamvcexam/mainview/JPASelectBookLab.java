package jpamvcexam.mainview;

import jpamvcexam.model.vo.Book;
import jpamvcexam.model.vo.EmpVO;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;

import javax.persistence.*;
import java.util.*;

public class JPASelectBookLab {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");

        EntityManager em = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("1. 모두 출력하기");
            System.out.println("2. 가격이 높은 순으로 출력하기");
            System.out.println("3. 20000원 이상의 도서들만 출력하기");
            System.out.println("4. id가 3번인 도서 출력하기");
            System.out.println("5. 도서명에 '자바'또는 '스프링'을 포함하는 도서들만 출력하기");
            System.out.println("6. 분류별 도서 가격의 합을 출력하기");
            System.out.println("7. 종료");
            System.out.print("원하는 메뉴의 번호를 선택:");
            int num = scanner.nextInt();

            switch (num) {
                case 1:
                    TypedQuery<Book> selectTFromBookT = em.createQuery("select t from Book t", Book.class);
                    List<Book> resultList = selectTFromBookT.getResultList();
                    resultList.stream().forEach(System.out::println);
                    break;
                case 2:
                    TypedQuery<Book> bookTypedQuery = em.createQuery("select t from Book t ORDER BY t.price desc", Book.class);
                    List<Book> resultList1 = bookTypedQuery.getResultList();
                    resultList1.stream().forEach(System.out::println);
                    break;
                case 3:
                    TypedQuery<Book> bookTypedQuery1 = em.createQuery("select t from Book t WHERE t.price >= 20000", Book.class);
                    List<Book> resultList2 = bookTypedQuery1.getResultList();
                    resultList2.stream().forEach(System.out::println);
                    break;
                case 4:
                    Book book = em.find(Book.class, 3);
                    if (book != null) {
                        System.out.println(book.toString());
                    } else {
                        System.out.println("id가 3인 도서는 없습니다!");
                    }
                    break;
                case 5:
                    boolean b = new Random().nextBoolean();
                    TypedQuery<Book> bookTypedQuery2 = em.createQuery("select t from Book t WHERE t.title like :bookName", Book.class);
                    bookTypedQuery2.setParameter("bookName", "%" + (new Random().nextBoolean() ? "자바" : "스프링") + "%");
                    List<Book> resultList3 = bookTypedQuery2.getResultList();
                    resultList3.stream().forEach(System.out::println);
                    break;
                case 6:
                    Query query = em.createQuery("SELECT t.kind, sum(t.price) FROM Book t GROUP BY t.kind");
                    List<Object[]> objects = query.getResultList();
                    for (Object[] obj : objects) {
                        System.out.println("분류코드 " + obj[0] + " : " + obj[1]);
                    }
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    em.close();
                    factory.close();
                    break;
            }
        }
    }
}