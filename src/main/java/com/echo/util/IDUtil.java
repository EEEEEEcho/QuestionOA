package com.echo.util;

import cn.hutool.core.lang.Snowflake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 使用雪花算法生成ID
 */
@Component
public class IDUtil {
    @Value("${snowflake.workerId}")
    private long workerId;

    @Value("${snowflake.datacenterId}")
    private long datacenterId;

    private Snowflake snowflake = new Snowflake(workerId,datacenterId);

    public long getId(){
        return snowflake.nextId();
    }

    public long getId(long workerId,long datacenterId){
        Snowflake snowflake = new Snowflake(workerId,datacenterId);
        return snowflake.nextId();
    }
}
