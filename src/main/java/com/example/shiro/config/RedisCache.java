package com.example.shiro.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Create by fraser on 2018/9/12 9:18 AM
 */
@Slf4j
@Component
public class RedisCache<K, V> implements Cache<K, V> {

    public static final String SHIRO_PREFIX = "shiro-cache:";

    @Resource
    private RedisTemplate<String, Object> stringObjectRedisTemplate;

    private String getKey(K key){
        if (key instanceof String){
            return (SHIRO_PREFIX + key);
        }
        return key.toString();
    }

    @Override
    public V get(K k) throws CacheException {
        log.info("read from redis...");
        V v = (V) stringObjectRedisTemplate.opsForValue().get(getKey(k));
        if (v != null){
            return v;
        }
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        stringObjectRedisTemplate.opsForValue().set(getKey(k), v);
        stringObjectRedisTemplate.expire(getKey(k), 100, TimeUnit.SECONDS);
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {
        V v = (V) stringObjectRedisTemplate.opsForValue().get(getKey(k));
        stringObjectRedisTemplate.delete((String) get(k));
        if (v != null){
            return v;
        }
        return null;
    }

    @Override
    public void clear() throws CacheException {
        //不要重写，如果只保存shiro数据无所谓
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
