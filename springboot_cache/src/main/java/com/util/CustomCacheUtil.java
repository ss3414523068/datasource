package com.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//@Order(1)
//@Component
public class CustomCacheUtil implements ApplicationRunner {

    private static Log logger = LogFactory.getLog(CustomCacheUtil.class);

    private static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static ConcurrentHashMap<String, Object> getCache() {
        lock.readLock().lock();
        try {
            return map;
        } finally {
            lock.readLock().unlock();
        }
    }

    /* 启动初始化缓存 */
    @Override
    public void run(ApplicationArguments args) {
        map.put("key1", "value1");
    }

    /* 定时更新缓存 */
    @Scheduled(cron = "*/30 * * * * *")
    public void cron() {
        /*
         * ①不加读写锁，写时可能读取到脏数据
         * ②加读写锁，写时会等待写操作完毕
         * */
        try {
            lock.writeLock().lock();
            logger.info("CustomCacheUtil update");
            TimeUnit.SECONDS.sleep(5);
            map.clear();
            map.put("key2", "value2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

}
