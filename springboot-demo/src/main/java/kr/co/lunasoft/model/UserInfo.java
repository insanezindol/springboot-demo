package kr.co.lunasoft.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="UserInfo", description="MongoDB User Collection Object")
@Data
public class UserInfo {
	
	@ApiModelProperty(value = "번호 (PK)")
    private String id;
    
	@ApiModelProperty(value = "이름")
	private String name;
    
	@ApiModelProperty(value = "주소")
	private String address;
}
