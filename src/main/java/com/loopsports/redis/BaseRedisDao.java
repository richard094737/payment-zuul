package com.loopsports.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class BaseRedisDao {

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public ValueOperations<String, String> getValueOpsStr() {
        return valueOpsStr;
    }

    public void setValueOpsStr(ValueOperations<String, String> valueOpsStr) {
        this.valueOpsStr = valueOpsStr;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public ValueOperations<String, Object> getValOps() {
        return valOps;
    }

    public void setValOps(ValueOperations<String, Object> valOps) {
        this.valOps = valOps;
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valueOpsStr;

    @Autowired
    RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<String, Object> valOps;



}
