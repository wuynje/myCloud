package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.MongdbTestEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wuynje
 * @Date: 2021/9/1 11:19
 * @Description:
 */
@Service
public class MongodbService {

    @Resource
    private MongoTemplate mongoTemplate;

    public void add(MongdbTestEntity m){
        mongoTemplate.save(m);
    }

    public void delete(MongdbTestEntity m){
        MongdbTestEntity demoEntity = new MongdbTestEntity();
        demoEntity.setId(m.getId());
        mongoTemplate.remove(demoEntity);
    }

    public void update(MongdbTestEntity m){
        Query query = new Query(Criteria.where("id").is(m.getId()));

        Update update = new Update();
        update.set("title", m.getTitle());
        update.set("description", m.getDescription());
        update.set("by", m.getBy());
        update.set("url", m.getUrl());

        mongoTemplate.updateFirst(query, update, MongdbTestEntity.class);
    }

    public MongdbTestEntity findDemoById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        MongdbTestEntity demoEntity = mongoTemplate.findOne(query, MongdbTestEntity.class);
        return demoEntity;
    }

}
