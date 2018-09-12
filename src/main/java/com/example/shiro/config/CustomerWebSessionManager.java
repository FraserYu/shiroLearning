package com.example.shiro.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.ServletRequest;
import java.io.Serializable;

/**
 * Create by fraser on 2018/9/11 4:38 PM
 */
public class CustomerWebSessionManager extends DefaultWebSessionManager {
    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        Serializable sessionId = getSessionId(sessionKey);
        ServletRequest servletRequest = null;

        if (sessionKey instanceof WebSessionKey){
            servletRequest = ((WebSessionKey)sessionKey).getServletRequest();
        }

        if (servletRequest != null && sessionId != null && servletRequest.getAttribute(sessionId.toString()) != null){
            return (Session) servletRequest.getAttribute(sessionId.toString());
        }else {

            Session session = super.retrieveSession(sessionKey);

            if (servletRequest != null && sessionId != null){
                servletRequest.setAttribute(sessionId.toString(), session);
            }

            return session;
        }

    }
}
