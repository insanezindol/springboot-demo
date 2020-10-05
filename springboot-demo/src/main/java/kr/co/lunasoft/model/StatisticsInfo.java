package kr.co.lunasoft.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="StatisticsInfo", description="Product Statistics Object")
@Getter
@Setter
public class StatisticsInfo {
	
	@ApiModelProperty(value = "몰아이디")
	private String mallId;
    
	@ApiModelProperty(value = "몰이름")
	private String mallName;

	@ApiModelProperty(value = "기간정보")
	private String statDate;

	@ApiModelProperty(value = "신규상품")
	private String registerCnt;

	@ApiModelProperty(value = "수정상품")
	private String modifyCnt;

	@ApiModelProperty(value = "총상품")
	private String totalCnt;

}
