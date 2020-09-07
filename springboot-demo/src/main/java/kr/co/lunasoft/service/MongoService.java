package kr.co.lunasoft.service;

import kr.co.lunasoft.model.HumanInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class MongoService {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<HumanInfo> getList() {
        return mongoTemplate.findAll(HumanInfo.class, "human");
    }

    public HumanInfo getOne(String name) {
        return mongoTemplate.findOne(new Query(Criteria.where("name").is(name)), HumanInfo.class, "human");
    }

    public void add(HumanInfo param) {
        Date nowDate = new Date();
        param.setRegDate(nowDate);
        param.setUpdDate(nowDate);
        mongoTemplate.save(param, "human");
    }

    public void modify(HumanInfo param) {
        mongoTemplate.findAndModify(
                new Query(
                        Criteria.where("_id").is(param.getId())),
                new Update()
                        .set("name", param.getName())
                        .set("gender", param.getGender())
                        .set("updDate", new Date())
                , HumanInfo.class, "human");
    }

    public void delete(String id) {
        mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), HumanInfo.class, "human");
    }

}
