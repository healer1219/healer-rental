package com.healer.user.session;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @author 李泽炜
 * @package cn.itcast.shiro.session
 * @time 2021/2/28 16:26
 * @Description TODO    自定义的SessionManager
 */
public class CustomSessionManager extends DefaultWebSessionManager {

    /**
     * 头信息中具有sessionId
     *      请求头：Authorization：  sessionID
     *
     * 指定sessionId的获取方式
     */
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        //获取请求头中的数据
        String id = WebUtils.toHttp(request).getHeader("Authorization");
        if (id == null){
            //如果没有携带请求头，生成新的sessionId
            return super.getSessionId(request, response);
        }else {
            //返回即可
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,"header");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        }
    }
}
