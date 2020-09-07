package kr.co.lunasoft.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "HumanInfo", description = "MongoDB Human Collection Object")
@Data
public class HumanInfo {

    @ApiModelProperty(value = "아이디")
    private String id;

    @ApiModelProperty(value = "이름")
    private String name;

    @ApiModelProperty(value = "성별 - 0 : 남자 , 1 : 여자")
    private String gender;

    @ApiModelProperty(value = "부양가족")
    private ChildInfo childInfo;

    @ApiModelProperty(value = "등록시간")
    private Date regDate;

    @ApiModelProperty(value = "수정시간")
    private Date updDate;

}
