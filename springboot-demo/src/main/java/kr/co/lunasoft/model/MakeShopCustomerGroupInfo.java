package kr.co.lunasoft.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "MakeShopCustomerInfo", description = "Customer Object From MakeShop")
@Data
public class MakeShopCustomerGroupInfo {

    @ApiModelProperty(value = "그룹 아이디")
    private String group_id;

    @ApiModelProperty(value = "그룹명")
    private String group_name;

    @ApiModelProperty(value = "회원그룹 구분")
    private String group_type;

    @ApiModelProperty(value = "그룹 혜택 결제 조건")
    private String pay_benefit;

    @ApiModelProperty(value = "배송비 정책")
    private String delivery_type;

    @ApiModelProperty(value = "등급별 배송비 주문 금액")
    private String group_order_price;

    @ApiModelProperty(value = "등급별 배송비")
    private String group_delivery_price;

    @ApiModelProperty(value = "회원 가입시 등록 그룹")
    private String regist_group;

    @ApiModelProperty(value = "혜택 타입")
    private String benefit_type;

    @ApiModelProperty(value = "회원 1회 구매 금액")
    private String purchase_price;

    @ApiModelProperty(value = "원 단위 추가 적립")
    private String reserve_price;

    @ApiModelProperty(value = "곱(배) 단위 추가 적립")
    private String reserve_double;

    @ApiModelProperty(value = "% 단위 추가 적립")
    private String reserve_percent;

    @ApiModelProperty(value = "적립금 절사 단위")
    private String reserve_cut;

    @ApiModelProperty(value = "원 단위 추가 할인")
    private String discount_price;

    @ApiModelProperty(value = "% 단위 추가 할인")
    private String discount_percent;

    @ApiModelProperty(value = "추가 할인 절사 단위")
    private String discount_cut;

    @ApiModelProperty(value = "중복 혜택 타입")
    private String add_benefit_type;

    @ApiModelProperty(value = "중복 회원 1회 구매 금액")
    private String add_purchase_price;

    @ApiModelProperty(value = "중복 원 단위 추가 할인")
    private String add_discount_price;

    @ApiModelProperty(value = "중복 % 단위 추가 할인")
    private String add_discount_percent;

    @ApiModelProperty(value = "중복 추가 할인 절사 단위")
    private String add_discount_cut;

    @ApiModelProperty(value = "도매그룹 상품 할인 설정")
    private String wholesale_discount;

    @ApiModelProperty(value = "도매 원 단위 상품 할인")
    private String wholesale_discount_price;

    @ApiModelProperty(value = "도매 % 단위 상품 할인")
    private String wholesale_discount_percent;

    @ApiModelProperty(value = "도매 상품 할인 절사")
    private String wholesale_discount_cut;

    @ApiModelProperty(value = "도매 상품 할인 절사 옵션")
    private String wholesale_discount_cut_option;

    @ApiModelProperty(value = "도매그룹 상품 옵션 할인 설정")
    private String wholesale_discount_option;

    @ApiModelProperty(value = "도매그룹 상품 할인 분류")
    private String wholesale_discount_category;

    @ApiModelProperty(value = "도매그룹 구매 제한")
    private String buyable_type;

    @ApiModelProperty(value = "회원의 1회 구매 개수 또는 구매 금액")
    private String buyable_amount;

    @ApiModelProperty(value = "구매 이상 / 미만")
    private String buyable_range;

    @ApiModelProperty(value = "구매 가능 여부")
    private String buyable_flag;

    @ApiModelProperty(value = "도매상품 구분")
    private String sellprice_flag;

    @ApiModelProperty(value = "도매그룹 할인 제한")
    private String use_coupon;

    @ApiModelProperty(value = "할인이벤트 종류")
    private String coupon_item;

}
