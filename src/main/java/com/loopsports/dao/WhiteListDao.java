package com.loopsports.dao;

import com.loopsports.redis.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class WhiteListDao {

    @Autowired
    BaseRedisDao baseRedisDao;

    public void saveWhiteList(){
        baseRedisDao.getValOps().set("test", "test");
    }

    
}
