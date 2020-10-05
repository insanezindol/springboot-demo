package kr.co.lunasoft.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@ApiModel(value="ProductInfo", description="MySQL DB Product Table Object")
@Getter
@Setter
public class ProductInfo {

    /* 쇼핑몰아이디 */
    private String mallId;

    /* 상품 번호 */
    private BigInteger productNo;

    /* 스마트스토어 상품 번호 */
    private BigInteger smartstoreProductNo;

    /* 스마트스토어 자체 상품 코드 */
    private String smartstoreProductCustomCode;

    /* 상품 이름 */
    private String productName;

    /* 상품 공급 이름 */
    private String productSupplyName;

    /* 상품 영어 이름 */
    private String productEngName;

    /* 상품 코드 */
    private String productCode;

    /* 상품 자체 코드 */
    private String productCustomCode;

    /* 모델명 */
    private String modelName;

    /* 상품 가격 */
    private int productPrice;

    /* 상품 소비자 가격 */
    private int productRetailPrice;

    /* 상품 공급 가격 */
    private int productSupplyPrice;

    /* 상품 카테고리 */
    private String productCategoryNo;

    /* 표시 유무 */
    private String displayYn;

    /* 판매 유무 */
    private String sellYn;

    /* 스마트스토어 상품 삭제 유무 */
    private String delYn;

    /* MC001,상품 상태 */
    private String productStatCode;

    /* 중고사용개월 */
    private int productUseMonthCount;

    /* 상품 태그 */
    private String productTagText;

    /* 마진율 */
    private int marginRate;

    /* 과세 구분 */
    private String taxCode;

    /* 과세 율 */
    private int taxRate;

    /* 대체 가격 문구 */
    private String priceAlterText;

    /* 구매 제한 */
    private String buyLimitCode;

    /* 구매 단위 타입 */
    private String buyUnitCode;

    /* 구매 할 수 있는 최소한의 단위 */
    private int buyUnitCount;

    /* 주문수량제한기준 */
    private String orderLimitCode;

    /* 최소주문수량 */
    private int orderMinCount;

    /* 최대주문수량 */
    private int orderMaxCount;

    /* 적립금 설정 정보 */
    private String productMileagePrice;

    /* 회원등급추가적립제외 */
    private String customerGradeAddMilegeExcept;

    /* 성인인증유무 */
    private String adultCertYn;

    /* 상세이미지 */
    private String fileImageDetailText;

    /* 목록이미지 */
    private String fileImageListText;

    /* 축소이미지 */
    private String fileImageTinyText;

    /* 작은목록이미지 */
    private String fileImageSmallText;

    /* 옵션사용유무 */
    private String optionUseYn;

    /* 옵션구성방식 */
    private String optionCode;

    /* 제조사코드 */
    private String madeCode;

    /* 트렌드코드 */
    private String trendCode;

    /* 브랜드코드 */
    private String brandCode;

    /* 공급사코드 */
    private String supplyCode;

    /* 제조 날짜 */
    private Date madeDate;

    /* 출시 날짜 */
    private Date releaseDate;

    /* 만료 시작 날짜 */
    private Date expireStartDate;

    /* 만료 종료 날짜 */
    private Date expireEndDate;

    /* 원산지 종류 */
    private String originPlaceCode;

    /* 원산지 번호 */
    private BigInteger originPlaceNo;

    /* 원산지 기타 정보 */
    private String originPlaceEtcText;

    /* HS코드 */
    private String hsCode;

    /* 상품의 무게 */
    private double productWeight;

    /* 상품의 소재 */
    private String productMaterialText;

    /* 재고 수량 */
    private String productStockCount;

    /* 품절 유무 */
    private String soldoutYn;

    /* 상품 PC 할인 판매가 */
    private int productPcDiscountPrice;

    /* 상품 모바일 할인 판매가 */
    private int productMobileDiscountPrice;

    /* 상품 요약 설명 */
    private String productSummaryExplainText;

    /* 상품 pc 상세 설명 */
    private String productPcDetailExplainText;

    /* 상품 mobile 상세 설명 */
    private String productMobileDetailExplainText;

    /* 상품 프로모션 정보 */
    private String productBenefitText;

    /* 상품 연동 유무 */
    private int productLinkYn;

    /* 상품 옵션 연동 유무 */
    private int productOptionLinkYn;

    /* 상품 이름 연동 유무 */
    private int productNameLinkYn;

    /* 상품 가격 연동 유무 */
    private int productPriceLinkYn;

    /* 상품 판매 연동 유무 */
    private int productSellLinkYn;

    /* 상품 재고 연동 유무 */
    private int productStockLinkYn;

    /* 상품 상세 연동 유무 */
    private int productDetailLinkYn;

    /* 삭제 상품 재연동 유무 */
    private int productDelRelinkYn;

    /* 루나 연동 유무 */
    private int productLunaLinkYn;

    /* 상품 등록일 */
    private Date productRegisterDate;

    /* 상품 수정일 */
    private Date productModifyDate;

    /* API 갱신 시간 */
    private Date apiUpdateDate;

    /* 생성일 */
    private Date createDate;

    /* LC009,유저코드,NULL:시스템,1:루나직원,2:회원메인,3:회원서브,4:고객,5:배치 */
    private int createUserCode;

    /* 생성자 */
    private BigInteger createUserNo;

    /* 수정일 */
    private Date updateDate;

    /* LC009,유저코드,NULL:시스템,1:루나직원,2:회원메인,3:회원서브,4:고객,5:배치 */
    private int updateUserCode;

    /* 수정자 */
    private BigInteger updateUserNo;

}
