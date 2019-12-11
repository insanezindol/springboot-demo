package kr.co.lunasoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(value="TopicInfo", description="MySQL Topic Table Object")
@Data
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
	
	@Builder
    public TopicInfo(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
