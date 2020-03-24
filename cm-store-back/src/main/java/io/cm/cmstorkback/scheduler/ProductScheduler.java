package io.cm.cmstorkback.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProductScheduler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0 0 01 * * ?")
    public void removeProduct(){
        logger.info("remove hot product");
        String key = "HotProducts";
        redisTemplate.delete(key);

    }
}
