package com.hualuo.master.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author Joseph
 * @create 2017/12/6 1:05
 */
@Configuration
@Profile("redis")
@EnableRedisHttpSession
public class RedisConfig {

    //用标记  -Dspring.profiles.active=redis 来启动应用
    //java -Dserver.port=$port -Dspring.profiles.active=redis -jar app.jar
}
