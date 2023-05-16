package jpamvcexam.model.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity/*entity객체로 db연동을 하는 거기 때문에 entity객체에 매핑되는 테이블이 있어야 함*/
@Table(name="emp")
public class EmpVO {
	@Id
	private int empno;
	private String ename;
	private String job;
	private String mgr;
	private java.sql.Date  hiredate;
	private int sal;
	private Integer comm; //null이 될 수도 있는 컬럼은 기본형이면 에러가 남 객체형을 써줘야 함
	private Integer deptno;
	
	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public java.sql.Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(java.sql.Date  hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "EmpVO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}	
}
