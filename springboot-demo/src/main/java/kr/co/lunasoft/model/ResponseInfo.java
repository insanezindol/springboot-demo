package kr.co.lunasoft.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="ResponseInfo", description="Default Response Object")
@Getter
@Setter
public class ResponseInfo {
	
	@ApiModelProperty(value = "응답 코드")
    private String code;
	
	@ApiModelProperty(value = "응답 데이터")
    private String data;
	
	@ApiModelProperty(value = "응답 메시지")
    private String msg;

    public ResponseInfo(String code, String data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
    
}
