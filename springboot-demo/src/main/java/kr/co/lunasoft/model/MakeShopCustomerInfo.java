package kr.co.lunasoft.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "MakeShopCustomerInfo", description = "Customer Object From MakeShop")
@Getter
@Setter
public class MakeShopCustomerInfo {

    @ApiModelProperty(value = "회원 아이디")
    private String id;

    @ApiModelProperty(value = "회원명")
    private String hname;

    @ApiModelProperty(value = "회원타입")
    private String mem_type;

    @ApiModelProperty(value = "간편회원")
    private String simple_type;

    @ApiModelProperty(value = "회원등급")
    private String grade;

    @ApiModelProperty(value = "이메일")
    private String email;

    @ApiModelProperty(value = "휴대폰")
    private String mobile;

    @ApiModelProperty(value = "연락처")
    private String phone;

    @ApiModelProperty(value = "적립금")
    private String reserve;

    @ApiModelProperty(value = "이메일 수신여부")
    private String email_receive;

    @ApiModelProperty(value = "SMS 수신여부")
    private String sms_receive;

    @ApiModelProperty(value = "로그인 일시")
    private String login_date;

    @ApiModelProperty(value = "가입 일시")
    private String reg_date;

    @ApiModelProperty(value = "평생 회원 여부")
    private String lifetime;

    @ApiModelProperty(value = "평생 회원 전환일")
    private String lifetime_date;

    @ApiModelProperty(value = "그룹 아이디")
    private String group_id;

    @ApiModelProperty(value = "그룹명")
    private String group_name;

    @ApiModelProperty(value = "성별")
    private String sex;

    @ApiModelProperty(value = "생년월일")
    private String birth_day;

    @ApiModelProperty(value = "우편번호")
    private String post;

    @ApiModelProperty(value = "주소")
    private String address;

    @ApiModelProperty(value = "상세주소")
    private String address_detail;

    @ApiModelProperty(value = "회사 우편번호")
    private String office_post;

    @ApiModelProperty(value = "회사 주소")
    private String office_address;

    @ApiModelProperty(value = "회사 전화")
    private String office_phone;

    @ApiModelProperty(value = "포인트")
    private String point;

    @ApiModelProperty(value = "예치금")
    private String emoney;

    @ApiModelProperty(value = "푸시 수신 여부")
    private String push_receive;

    @ApiModelProperty(value = "파워앱 설치 여부")
    private String is_app_use;

    @ApiModelProperty(value = "개인정보 유효기간")
    private String extension_period;

    @ApiModelProperty(value = "추천인")
    private String recommand_id;

    @ApiModelProperty(value = "회원 별 총 주문 수")
    private String order_count;

}
