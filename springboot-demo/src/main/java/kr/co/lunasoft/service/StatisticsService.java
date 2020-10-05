package kr.co.lunasoft.service;

import kr.co.lunasoft.mapper.StatisticsMapper;
import kr.co.lunasoft.model.StatisticsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticsService {

    @Autowired
    StatisticsMapper statisticsMapper;

    public List<StatisticsInfo> getStat1(Map<String, String> param) {
        return statisticsMapper.getStat1(param);
    }

    public List<StatisticsInfo> getStat2(Map<String, String> param) {
        return statisticsMapper.getStat2(param);
    }
}
