package com.lisl.pay.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Administrator on 2017/3/13.
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
