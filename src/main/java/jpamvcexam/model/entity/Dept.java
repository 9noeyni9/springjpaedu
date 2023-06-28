package jpamvcexam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Dept {
    @Id
    private int deptno;
    private String dname;
    private String loc_code;

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                '}';
    }
}
