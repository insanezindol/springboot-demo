package kr.co.lunasoft.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "emp")
public class EmpInfo {

	@Id
	@Column(name = "empno")
	private Integer empno;

	@Column(name = "ename")
	private String ename;

	@Column(name = "job")
	private String job;

	@Column(name = "mgr")
	private Integer mgr;

	@Column(name = "hiredate")
	private Date hiredate;

	@Column(name = "sal")
	private Integer sal;

	@Column(name = "comm")
	private Integer comm;

	@Column(name = "deptno")
	private Integer deptno;
	
	@ManyToOne
	@JoinColumn(name ="deptno", insertable = false, updatable = false)
	private DeptInfo deptInfo;

}
