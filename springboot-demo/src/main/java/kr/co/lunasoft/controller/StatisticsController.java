package kr.co.lunasoft.controller;

import io.swagger.annotations.*;
import kr.co.lunasoft.model.ResponseInfo;
import kr.co.lunasoft.model.StatisticsInfo;
import kr.co.lunasoft.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stat")
@Slf4j
@Api(tags = {"99. stat"})
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @ApiOperation("업체별/호스팅별 사용현황 그래프를 조회한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "시작일시", required = true, dataType = "string", paramType = "path", defaultValue = "20200702"),
            @ApiImplicitParam(name = "endDate", value = "종료일시", required = true, dataType = "string", paramType = "path", defaultValue = "20200702"),
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResponseInfo.class)})
    @GetMapping(value = "/getStat1")
    public Map<String, Object> getStat1(@RequestParam String startDate, @RequestParam String endDate) {
        Map<String, String> param = new Hashtable<>();
        param.put("startDate", startDate);
        param.put("endDate", endDate);

        List<StatisticsInfo> list = statisticsService.getStat1(param);

        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", "100200");
        obj.put("msg", "success");
        obj.put("data", list);
        return obj;
    }

    @ApiOperation("업체별/호스팅별 사용현황 그래프를 조회한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "statDate", value = "기준일자", required = true, dataType = "string", paramType = "path", defaultValue = "20200702"),
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResponseInfo.class)})
    @GetMapping(value = "/getStat2")
    public Map<String, Object> getStat2(@RequestParam String statDate) {
        Map<String, String> param = new Hashtable<>();
        param.put("statDate", statDate);

        List<StatisticsInfo> list = statisticsService.getStat2(param);

        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", "100200");
        obj.put("msg", "success");
        obj.put("data", list);
        return obj;
    }

}
