package com.loopsports.dao;

import com.loopsports.domain.WhiteList;
import com.loopsports.mapper.WhiteListMapper;
import com.loopsports.redis.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class WhiteListDaoImpl implements WhiteListDao {


    @Autowired
    BaseRedisDao baseRedisDao;

    @Autowired
    WhiteListMapper whiteListMapper;


    public List<WhiteList> getDaifuWhiteList(String merNo, Integer gateway) {
        return whiteListMapper.checkeDaifuWhiteList(merNo, gateway);
    }

    public Long  checkeDaifuOnOff(String merNo, Integer gateway){
        return whiteListMapper.checkeDaifuOnOff(merNo, gateway);
    }
}
