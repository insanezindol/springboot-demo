package kr.co.lunasoft.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@ApiModel(value="TopicInfo", description="MySQL Topic Table Object")
@Getter
@Setter
@Entity
@Table(name="topic")
public class TopicInfo {
	
	@ApiModelProperty(value = "번호 (PK)")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(value = "제목")
	@Column(name = "title")
	private String title;
	
	@ApiModelProperty(value = "내용")
	@Column(name = "description")
	private String description;
	
	@ApiModelProperty(value = "생성일")
	@Column(name = "created")
	@CreationTimestamp
	private Date created;

}
