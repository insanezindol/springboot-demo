package kr.co.lunasoft.mapper;

import kr.co.lunasoft.model.ProductInfo;
import kr.co.lunasoft.model.StatisticsInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StatisticsMapper {

    List<StatisticsInfo> getStat1(Map<String, String> param);

    List<StatisticsInfo> getStat2(Map<String, String> param);

    List<ProductInfo> getProductInfoList();

    List<ProductInfo> getProductInfoNewList(Map<String, Object> param);
}
