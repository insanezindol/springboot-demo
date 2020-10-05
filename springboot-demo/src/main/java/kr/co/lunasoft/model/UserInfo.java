package kr.co.lunasoft.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="UserInfo", description="MongoDB User Collection Object")
@Getter
@Setter
public class UserInfo {
	
	@ApiModelProperty(value = "번호 (PK)")
    private String id;
    
	@ApiModelProperty(value = "이름")
	private String name;
    
	@ApiModelProperty(value = "주소")
	private String address;
	
	@ApiModelProperty(value = "생성일")
	private String requestTime;
	
}
