package com.example.shiro.config;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@Slf4j
public class RedisSessionDao extends AbstractSessionDAO {

    public static final String SESSION_PREFIX = "shiro-sessionId:";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private String getKey(String key){
        return (SESSION_PREFIX + key);
    }

    private void saveSession(Session session){
        if (session != null && session.getId() != null){
            redisTemplate.opsForValue().set(SESSION_PREFIX + session.getId().toString(), session);
            redisTemplate.expire(SESSION_PREFIX + session.getId().toString(), 600, TimeUnit.SECONDS);
        }
    }

    @Override
    protected Serializable doCreate(Session session) {
        log.info("Create Session");
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        log.info("Read Session:" + sessionId.toString());
        if (sessionId == null){
            return null;
        }
        String key = getKey(sessionId.toString());
        return (Session) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if (session != null && session.getId() != null){
            String key = getKey(session.getId().toString());
            redisTemplate.delete(key);
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<String> keys = redisTemplate.keys(SESSION_PREFIX + "*");
        Set<Session> sessions = Sets.newHashSet();
        if (CollectionUtils.isEmpty(keys)){
            return sessions;
        }

        for (String key : keys){
            sessions.add((Session) redisTemplate.opsForValue().get(key));
        }
        return sessions;
    }
}
