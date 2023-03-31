package edu.global.ex.vo;

import java.sql.Timestamp;

//이름       널?       유형           
//-------- -------- ------------ 
//EMPNO    NOT NULL NUMBER(4)    
//ENAME             VARCHAR2(10) 
//JOB               VARCHAR2(9)  
//MGR               NUMBER(4)    
//HIREDATE          DATE         
//SAL               NUMBER(7,2)  
//COMM              NUMBER(7,2)  
//DEPTNO            NUMBER(2)    

public class EmpVO {
   private int empno;
   private String ename;
   private String job;
   private int mgr;
   private Timestamp hiredate;
   private int sal;
   private int comm;
   private int deptno;
   
   public EmpVO() {}
   
   public EmpVO(int empno, String ename, String job, int mgr, Timestamp hiredate, int sal, int comm, int deptno) {
      this.empno = empno;
      this.ename = ename;
      this.job = job;
      this.mgr = mgr;
      this.hiredate = hiredate;
      this.sal = sal;
      this.comm = comm;
      this.deptno = deptno;
   }
   public int getImgNum() {
	      return (int)(Math.random() * 6) +1;
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
   public int getMgr() {
	   return mgr;
   }
   public void setMgr(int mgr) {
	   this.mgr = mgr;
   }
   public Timestamp getHiredate() {
	   return hiredate;
   }
   public void setHiredate(Timestamp hiredate) {
	   this.hiredate = hiredate;
   }

   public int getSal() {
	   return sal;
   }
   public void setSal(int sal) {
	   this.sal = sal;
   }

   public int getComm() {
	   return sal;
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
   
   
}