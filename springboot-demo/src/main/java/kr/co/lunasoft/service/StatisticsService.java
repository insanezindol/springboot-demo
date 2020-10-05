package kr.co.lunasoft.service;

import kr.co.lunasoft.elasticsearch.ProductDocument;
import kr.co.lunasoft.elasticsearch.ProductDocumentRepository;
import kr.co.lunasoft.mapper.StatisticsMapper;
import kr.co.lunasoft.model.ProductInfo;
import kr.co.lunasoft.model.StatisticsInfo;
import kr.co.lunasoft.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsService {

    @Autowired
    StatisticsMapper statisticsMapper;

    @Autowired
    ProductDocumentRepository productDocumentRepository;

    @Autowired
    ElasticService elasticService;

    public List<StatisticsInfo> getStat1(Map<String, String> param) {
        return statisticsMapper.getStat1(param);
    }

    public List<StatisticsInfo> getStat2(Map<String, String> param) {
        return statisticsMapper.getStat2(param);
    }

    public List<ProductDocument> infoToDocument (List<ProductInfo> list) {
        List<ProductDocument> documents = new ArrayList<>();
        for (ProductInfo info : list) {
            ProductDocument productDocument = new ProductDocument();
            productDocument.setId(info.getMallId() + "-" + info.getProductNo() + "-" + info.getSmartstoreProductNo());
            productDocument.setLog_date(DateUtil.getNowDatetime());
            productDocument.setMall_id(info.getMallId());
            productDocument.setProduct_no(info.getProductNo());
            productDocument.setSmartstore_product_no(info.getSmartstoreProductNo());
            productDocument.setSmartstore_product_custom_code(info.getSmartstoreProductCustomCode());
            productDocument.setProduct_name(info.getProductName());
            productDocument.setProduct_supply_name(info.getProductSupplyName());
            productDocument.setProduct_eng_name(info.getProductEngName());
            productDocument.setProduct_code(info.getProductCode());
            productDocument.setProduct_custom_code(info.getProductCustomCode());
            productDocument.setModel_name(info.getModelName());
            productDocument.setProduct_price(info.getProductPrice());
            productDocument.setProduct_retail_price(info.getProductRetailPrice());
            productDocument.setProduct_supply_price(info.getProductSupplyPrice());
            productDocument.setProduct_category_no(info.getProductCategoryNo());
            productDocument.setDisplay_yn(info.getDisplayYn());
            productDocument.setSell_yn(info.getSellYn());
            productDocument.setDel_yn(info.getDelYn());
            productDocument.setProduct_stat_code(info.getProductStatCode());
            productDocument.setProduct_use_month_count(info.getProductUseMonthCount());
            productDocument.setProduct_tag_text(info.getProductTagText());
            productDocument.setMargin_rate(info.getMarginRate());
            productDocument.setTax_code(info.getTaxCode());
            productDocument.setTax_rate(info.getTaxRate());
            productDocument.setPrice_alter_text(info.getPriceAlterText());
            productDocument.setBuy_limit_code(info.getBuyLimitCode());
            productDocument.setBuy_unit_code(info.getBuyUnitCode());
            productDocument.setBuy_unit_count(info.getBuyUnitCount());
            productDocument.setOrder_limit_code(info.getOrderLimitCode());
            productDocument.setOrder_min_count(info.getOrderMinCount());
            productDocument.setOrder_max_count(info.getOrderMaxCount());
            productDocument.setProduct_mileage_price(info.getProductMileagePrice());
            productDocument.setCustomer_grade_add_milege_except_yn(info.getCustomerGradeAddMilegeExcept());
            productDocument.setAdult_cert_yn(info.getAdultCertYn());
            productDocument.setFile_image_detail_text(info.getFileImageDetailText());
            productDocument.setFile_image_list_text(info.getFileImageListText());
            productDocument.setFile_image_tiny_text(info.getFileImageTinyText());
            productDocument.setFile_image_small_text(info.getFileImageSmallText());
            productDocument.setOption_use_yn(info.getOptionUseYn());
            productDocument.setOption_code(info.getOptionCode());
            productDocument.setMade_code(info.getMadeCode());
            productDocument.setTrend_code(info.getTrendCode());
            productDocument.setBrand_code(info.getBrandCode());
            productDocument.setSupply_code(info.getSupplyCode());
            productDocument.setMade_date(DateUtil.convertDateToString(info.getMadeDate()));
            productDocument.setRelease_date(DateUtil.convertDateToString(info.getReleaseDate()));
            productDocument.setExpire_start_date(DateUtil.convertDateToString(info.getExpireStartDate()));
            productDocument.setExpire_end_date(DateUtil.convertDateToString(info.getExpireEndDate()));
            productDocument.setOrigin_place_code(info.getOriginPlaceCode());
            productDocument.setOrigin_place_no(info.getOriginPlaceNo());
            productDocument.setOrigin_place_etc_text(info.getOriginPlaceEtcText());
            productDocument.setHs_code(info.getHsCode());
            productDocument.setProduct_weight(info.getProductWeight());
            productDocument.setProduct_material_text(info.getProductMaterialText());
            productDocument.setProduct_stock_count(info.getProductStockCount());
            productDocument.setSoldout_yn(info.getSoldoutYn());
            productDocument.setProduct_pc_discount_price(info.getProductPcDiscountPrice());
            productDocument.setProduct_mobile_discount_price(info.getProductMobileDiscountPrice());
            productDocument.setProduct_summary_explain_text(info.getProductSummaryExplainText());
            productDocument.setProduct_pc_detail_explain_text(info.getProductPcDetailExplainText());
            productDocument.setProduct_mobile_detail_explain_text(info.getProductMobileDetailExplainText());
            productDocument.setProduct_benefit_text(info.getProductBenefitText());
            productDocument.setProduct_link_yn(info.getProductLinkYn());
            productDocument.setProduct_option_link_yn(info.getProductOptionLinkYn());
            productDocument.setProduct_name_link_yn(info.getProductNameLinkYn());
            productDocument.setProduct_price_link_yn(info.getProductPriceLinkYn());
            productDocument.setProduct_sell_link_yn(info.getProductSellLinkYn());
            productDocument.setProduct_stock_link_yn(info.getProductStockLinkYn());
            productDocument.setProduct_detail_link_yn(info.getProductDetailLinkYn());
            productDocument.setProduct_del_relink_yn(info.getProductDelRelinkYn());
            productDocument.setProduct_luna_link_yn(info.getProductLunaLinkYn());
            productDocument.setProduct_register_date(DateUtil.convertDateToString(info.getProductRegisterDate()));
            productDocument.setProduct_modify_date(DateUtil.convertDateToString(info.getProductModifyDate()));
            productDocument.setApi_update_date(DateUtil.convertDateToString(info.getApiUpdateDate()));
            productDocument.setCreate_date(DateUtil.convertDateToString(info.getCreateDate()));
            productDocument.setCreate_user_code(info.getCreateUserCode());
            productDocument.setCreate_user_no(info.getCreateUserNo());
            productDocument.setUpdate_date(DateUtil.convertDateToString(info.getUpdateDate()));
            productDocument.setUpdate_user_code(info.getUpdateUserCode());
            productDocument.setUpdate_user_no(info.getUpdateUserNo());
            documents.add(productDocument);
        }
        return documents;
    }

    public void migrateMysqlToElasticsearch() {
        try {
            List<ProductInfo> list = statisticsMapper.getProductInfoList();
            if(list.size() != 0){
                List<ProductDocument> documents = this.infoToDocument(list);
                if(documents.size() != 0) {
                    productDocumentRepository.saveAll(documents);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void migrateMysqlToElasticsearchNew(Map<String, Object> param) {
        try {
            List<ProductInfo> list = statisticsMapper.getProductInfoNewList(param);
            if(list.size() != 0){
                List<ProductDocument> documents = this.infoToDocument(list);
                if(documents.size() != 0) {
                    productDocumentRepository.saveAll(documents);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void migrateMysqlToElasticsearchRest() {
        try {
            List<ProductInfo> list = statisticsMapper.getProductInfoList();
            if(list.size() != 0){
                List<ProductDocument> documents = this.infoToDocument(list);
                for (ProductDocument productDocument : documents) {
                    String url = "product-rest-log/_doc/" + productDocument.getId();
                    elasticService.callElasticApi("POST", url, productDocument);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
