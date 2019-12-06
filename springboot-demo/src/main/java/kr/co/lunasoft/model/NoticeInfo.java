package kr.co.lunasoft.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="NoticeInfo", description="MySQL DB Notice Table Object")
@Data
public class NoticeInfo {
	
	@ApiModelProperty(value = "번호 (PK)")
	private String id;
	
	@ApiModelProperty(value = "제목")
	private String title;
	
	@ApiModelProperty(value = "내용")
	private String contents;
	
	@ApiModelProperty(value = "상태값")
	private String status;
	
	@ApiModelProperty(value = "등록인")
	private String regUser;
	
	@ApiModelProperty(value = "등록시간")
	private String regDate;
	
}
