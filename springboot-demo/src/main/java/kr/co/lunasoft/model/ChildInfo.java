package kr.co.lunasoft.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="ChildInfo", description="MongoDB Child Collection Object")
@Data
public class ChildInfo {
	
	@ApiModelProperty(value = "이름")
	private String name;
    
	@ApiModelProperty(value = "관계")
	private String relation;
	
}
