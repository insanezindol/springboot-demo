package kr.co.lunasoft.controller;

import io.swagger.annotations.*;
import kr.co.lunasoft.elasticsearch.UserDocument;
import kr.co.lunasoft.elasticsearch.UserDocumentRepository;
import kr.co.lunasoft.model.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/es")
@Slf4j
@Api(tags = {"9. ElasticSearch"})
public class ElasticSearchController {

    @Resource
    UserDocumentRepository userDocumentRepository;

    @ApiOperation("elasticsearch GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string", paramType = "query", defaultValue = "dean"),
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResponseInfo.class)})
    @GetMapping(value = "/resource")
    public Map<String, Object> get(@RequestParam String searchType, @RequestParam String searchText) {
        Object result = null;

        if (searchType.equals("id")) {
            Optional<UserDocument> optional = userDocumentRepository.findById(searchText);
            if (optional.isPresent()) {
                UserDocument userDocument = optional.get();
                result = userDocument;
            }
        } else if (searchType.equals("name")) {
            List<UserDocument> list = userDocumentRepository.findByName(searchText);
            result = list;
        } else if (searchType.equals("age")) {
            List<UserDocument> list = userDocumentRepository.findByAge(Integer.parseInt(searchText));
            result = list;
        }

        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", "100200");
        obj.put("msg", "success");
        obj.put("data", result);
        return obj;
    }

    @ApiOperation("elasticsearch UPSERT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string", paramType = "query", defaultValue = "dean"),
            @ApiImplicitParam(name = "name", value = "이름", required = true, dataType = "string", paramType = "query", defaultValue = "이진형"),
            @ApiImplicitParam(name = "age", value = "나이", required = true, dataType = "int", paramType = "query", defaultValue = "30"),
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResponseInfo.class)})
    @PostMapping(value = "/resource")
    public Map<String, Object> post(@RequestParam String id, @RequestParam String name, @RequestParam int age) {
        Map<String, Object> map = new Hashtable<>();
        map.put("id", id);
        map.put("name", name);
        map.put("age", age);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        UserDocument userDocument = new UserDocument();
        userDocument.setId(id);
        userDocument.setName(name);
        userDocument.setAge(age);
        userDocument.setLogDate(sdf.format(new Date()));
        userDocument.setLogText(map.toString());

        UserDocument result = userDocumentRepository.save(userDocument);

        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", "100200");
        obj.put("msg", "success");
        obj.put("data", result);
        return obj;
    }

    @ApiOperation("elasticsearch DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string", paramType = "query", defaultValue = "dean"),
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResponseInfo.class)})
    @DeleteMapping(value = "/resource")
    public Map<String, Object> delete(@RequestParam String id) {
        UserDocument userDocument = new UserDocument();
        userDocument.setId(id);
        userDocumentRepository.delete(userDocument);

        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", "100200");
        obj.put("msg", "success");
        obj.put("data", null);
        return obj;
    }

}
