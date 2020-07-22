package kr.co.lunasoft.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/makeshop")
@Slf4j
@Api(tags = {"11. MakeShopController"})
public class MakeShopController {

    @GetMapping(value = "/getCustomerGroup")
    public Map<String, Object> getCustomerGroup() {
        Map<String, Object> data = new HashMap<String, Object>();

        JSONParser parser = new JSONParser();

        try {
            String fileName = "/Users/dean/dev/스마트플러스/20200717_xexymix_customer_group.json";
            Object obj = parser.parse(new FileReader(fileName));

            JSONObject jsonObject = (JSONObject) obj;
            String returnCode = (String) jsonObject.get("return_code");
            log.info("returnCode : {}", returnCode);
            JSONArray list = (JSONArray) jsonObject.get("list");

            Iterator<JSONObject> iterator = list.iterator();
            while (iterator.hasNext()) {
                JSONObject jSONObject = iterator.next();
                log.info("{}", jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        data.put("code", "100200");
        data.put("msg", "Success");
        data.put("data", "");
        return data;
    }

    @GetMapping(value = "/getCustomer")
    public Map<String, Object> getCustomer() {
        Map<String, Object> data = new HashMap<String, Object>();

        JSONParser parser = new JSONParser();

        try {
            String fileName = "/Users/dean/dev/스마트플러스/20200717_xexymix_customer.json";
            Object obj = parser.parse(new FileReader(fileName));

            JSONObject jsonObject = (JSONObject) obj;
            String returnCode = (String) jsonObject.get("return_code");
            log.info("returnCode : {}", returnCode);
            JSONArray list = (JSONArray) jsonObject.get("list");

            Iterator<JSONObject> iterator = list.iterator();
            while (iterator.hasNext()) {
                JSONObject jSONObject = iterator.next();
                log.info("{}", jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        data.put("code", "100200");
        data.put("msg", "Success");
        data.put("data", "");
        return data;
    }

}
