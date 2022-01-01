package com.echo.listener;

import com.echo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Slf4j
public class ScheduleTask {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private UserMapper userMapper;

    //每月1号凌晨1点执行一次
    @Scheduled(cron = "0 0 1 1 * ?")
    public void resetScoreAndRank(){
        //重置
        userMapper.resetUserScore();
        //获取redis中的所有键
        Set<String> keys = redisTemplate.keys("*");
        if (keys != null && keys.size() > 0){
            //删除所有这些键对应的值
            redisTemplate.delete(keys);
        }
        log.info("完成每月重置");
    }
}
