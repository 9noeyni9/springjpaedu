package jpamvcexam.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Emp {
    @Id
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private int sal;
    private int comm;

    private int deptno;
    @ManyToOne
    @JoinColumn(name = "DEPTNO")
    private Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", deptno=" + deptno +
                ", dept=" + dept +
                '}';
    }
}
