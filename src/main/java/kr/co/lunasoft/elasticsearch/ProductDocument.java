package kr.co.lunasoft.elasticsearch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(indexName = "product-document-log", type = "_doc")
public class ProductDocument {

    /* ID */
    @Id
    private String id;

    /* 현재일시 */
    @Field(type = FieldType.Date)
    private String log_date;

    /* 쇼핑몰아이디 */
    @Field(type = FieldType.Text)
    private String mall_id;

    /* 상품 번호 */
    @Field(type = FieldType.Long)
    private BigInteger product_no;

    /* 스마트스토어 상품 번호 */
    @Field(type = FieldType.Long)
    private BigInteger smartstore_product_no;

    /* 스마트스토어 자체 상품 코드 */
    @Field(type = FieldType.Text)
    private String smartstore_product_custom_code;

    /* 상품 이름 */
    @Field(type = FieldType.Text)
    private String product_name;

    /* 상품 공급 이름 */
    @Field(type = FieldType.Text)
    private String product_supply_name;

    /* 상품 영어 이름 */
    @Field(type = FieldType.Text)
    private String product_eng_name;

    /* 상품 코드 */
    @Field(type = FieldType.Text)
    private String product_code;

    /* 상품 자체 코드 */
    @Field(type = FieldType.Text)
    private String product_custom_code;

    /* 모델명 */
    @Field(type = FieldType.Text)
    private String model_name;

    /* 상품 가격 */
    @Field(type = FieldType.Long)
    private int product_price;

    /* 상품 소비자 가격 */
    @Field(type = FieldType.Long)
    private int product_retail_price;

    /* 상품 공급 가격 */
    @Field(type = FieldType.Long)
    private int product_supply_price;

    /* 상품 카테고리 */
    @Field(type = FieldType.Text)
    private String product_category_no;

    /* 표시 유무 */
    @Field(type = FieldType.Text)
    private String display_yn;

    /* 판매 유무 */
    @Field(type = FieldType.Text)
    private String sell_yn;

    /* 스마트스토어 상품 삭제 유무 */
    @Field(type = FieldType.Text)
    private String del_yn;

    /* MC001,상품 상태 */
    @Field(type = FieldType.Text)
    private String product_stat_code;

    /* 중고사용개월 */
    @Field(type = FieldType.Long)
    private int product_use_month_count;

    /* 상품 태그 */
    @Field(type = FieldType.Text)
    private String product_tag_text;

    /* 마진율 */
    @Field(type = FieldType.Long)
    private int margin_rate;

    /* 과세 구분 */
    @Field(type = FieldType.Text)
    private String tax_code;

    /* 과세 율 */
    @Field(type = FieldType.Long)
    private int tax_rate;

    /* 대체 가격 문구 */
    @Field(type = FieldType.Text)
    private String price_alter_text;

    /* 구매 제한 */
    @Field(type = FieldType.Text)
    private String buy_limit_code;

    /* 구매 단위 타입 */
    @Field(type = FieldType.Text)
    private String buy_unit_code;

    /* 구매 할 수 있는 최소한의 단위 */
    @Field(type = FieldType.Long)
    private int buy_unit_count;

    /* 주문수량제한기준 */
    @Field(type = FieldType.Text)
    private String order_limit_code;

    /* 최소주문수량 */
    @Field(type = FieldType.Long)
    private int order_min_count;

    /* 최대주문수량 */
    @Field(type = FieldType.Long)
    private int order_max_count;

    /* 적립금 설정 정보 */
    @Field(type = FieldType.Text)
    private String product_mileage_price;

    /* 회원등급추가적립제외 */
    @Field(type = FieldType.Text)
    private String customer_grade_add_milege_except_yn;

    /* 성인인증유무 */
    @Field(type = FieldType.Text)
    private String adult_cert_yn;

    /* 상세이미지 */
    @Field(type = FieldType.Text)
    private String file_image_detail_text;

    /* 목록이미지 */
    @Field(type = FieldType.Text)
    private String file_image_list_text;

    /* 축소이미지 */
    @Field(type = FieldType.Text)
    private String file_image_tiny_text;

    /* 작은목록이미지 */
    @Field(type = FieldType.Text)
    private String file_image_small_text;

    /* 옵션사용유무 */
    @Field(type = FieldType.Text)
    private String option_use_yn;

    /* 옵션구성방식 */
    @Field(type = FieldType.Text)
    private String option_code;

    /* 제조사코드 */
    @Field(type = FieldType.Text)
    private String made_code;

    /* 트렌드코드 */
    @Field(type = FieldType.Text)
    private String trend_code;

    /* 브랜드코드 */
    @Field(type = FieldType.Text)
    private String brand_code;

    /* 공급사코드 */
    @Field(type = FieldType.Text)
    private String supply_code;

    /* 제조 날짜 */
    @Field(type = FieldType.Date)
    private String made_date;

    /* 출시 날짜 */
    @Field(type = FieldType.Date)
    private String release_date;

    /* 만료 시작 날짜 */
    @Field(type = FieldType.Date)
    private String expire_start_date;

    /* 만료 종료 날짜 */
    @Field(type = FieldType.Date)
    private String expire_end_date;

    /* 원산지 종류 */
    @Field(type = FieldType.Text)
    private String origin_place_code;

    /* 원산지 번호 */
    @Field(type = FieldType.Text)
    private BigInteger origin_place_no;

    /* 원산지 기타 정보 */
    @Field(type = FieldType.Text)
    private String origin_place_etc_text;

    /* HS코드 */
    @Field(type = FieldType.Text)
    private String hs_code;

    /* 상품의 무게 */
    @Field(type = FieldType.Double)
    private double product_weight;

    /* 상품의 소재 */
    @Field(type = FieldType.Text)
    private String product_material_text;

    /* 재고 수량 */
    @Field(type = FieldType.Text)
    private String product_stock_count;

    /* 품절 유무 */
    @Field(type = FieldType.Text)
    private String soldout_yn;

    /* 상품 PC 할인 판매가 */
    @Field(type = FieldType.Long)
    private int product_pc_discount_price;

    /* 상품 모바일 할인 판매가 */
    @Field(type = FieldType.Long)
    private int product_mobile_discount_price;

    /* 상품 요약 설명 */
    @Field(type = FieldType.Text)
    private String product_summary_explain_text;

    /* 상품 pc 상세 설명 */
    @Field(type = FieldType.Text)
    private String product_pc_detail_explain_text;

    /* 상품 mobile 상세 설명 */
    @Field(type = FieldType.Text)
    private String product_mobile_detail_explain_text;

    /* 상품 프로모션 정보 */
    @Field(type = FieldType.Text)
    private String product_benefit_text;

    /* 상품 연동 유무 */
    @Field(type = FieldType.Long)
    private int product_link_yn;

    /* 상품 옵션 연동 유무 */
    @Field(type = FieldType.Long)
    private int product_option_link_yn;

    /* 상품 이름 연동 유무 */
    @Field(type = FieldType.Long)
    private int product_name_link_yn;

    /* 상품 가격 연동 유무 */
    @Field(type = FieldType.Long)
    private int product_price_link_yn;

    /* 상품 판매 연동 유무 */
    @Field(type = FieldType.Long)
    private int product_sell_link_yn;

    /* 상품 재고 연동 유무 */
    @Field(type = FieldType.Long)
    private int product_stock_link_yn;

    /* 상품 상세 연동 유무 */
    @Field(type = FieldType.Long)
    private int product_detail_link_yn;

    /* 삭제 상품 재연동 유무 */
    @Field(type = FieldType.Long)
    private int product_del_relink_yn;

    /* 루나 연동 유무 */
    @Field(type = FieldType.Long)
    private int product_luna_link_yn;

    /* 상품 등록일 */
    @Field(type = FieldType.Date)
    private String product_register_date;

    /* 상품 수정일 */
    @Field(type = FieldType.Date)
    private String product_modify_date;

    /* API 갱신 시간 */
    @Field(type = FieldType.Date)
    private String api_update_date;

    /* 생성일 */
    @Field(type = FieldType.Date)
    private String create_date;

    /* LC009,유저코드,NULL:시스템,1:루나직원,2:회원메인,3:회원서브,4:고객,5:배치 */
    @Field(type = FieldType.Long)
    private int create_user_code;

    /* 생성자 */
    @Field(type = FieldType.Long)
    private BigInteger create_user_no;

    /* 수정일 */
    @Field(type = FieldType.Date)
    private String update_date;

    /* LC009,유저코드,NULL:시스템,1:루나직원,2:회원메인,3:회원서브,4:고객,5:배치 */
    @Field(type = FieldType.Long)
    private int update_user_code;

    /* 수정자 */
    @Field(type = FieldType.Long)
    private BigInteger update_user_no;

}
