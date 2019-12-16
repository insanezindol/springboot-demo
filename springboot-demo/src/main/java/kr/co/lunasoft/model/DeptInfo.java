package kr.co.lunasoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "dept")
public class DeptInfo {

	@Id
	@Column(name = "deptno")
	private Integer deptno;

	@Column(name = "dname")
	private String dname;

	@Column(name = "loc")
	private String loc;
	
	@ApiModelProperty(value = "생성일")
	private String requestTime;

}
