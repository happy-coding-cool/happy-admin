package com.happy.admin.auth.filter;

import cn.hutool.core.collection.CollUtil;
import com.happy.admin.auth.handler.AuthenticatedHandler;
import cool.happycoding.code.user.wrapper.HttpServletRequestHeaderWrapper;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/07/07 8:41 上午
 */
public abstract class AbstractAuthenticatedFilter implements Filter {

    private final List<String> skipUrls;
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    public AbstractAuthenticatedFilter(List<String> skipUrls){
        this.skipUrls = skipUrls;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequestHeaderWrapper requestWrapper =
                new HttpServletRequestHeaderWrapper((HttpServletRequest) request);
        String uri = requestWrapper.getRequestURI();
        // 登录凭证的校验
        if (!match(uri)){
            doAuthenticate(requestWrapper, (HttpServletResponse) response);
        }
        chain.doFilter(requestWrapper, response);
    }

    protected boolean match(String originUrl){
        return (CollUtil.isNotEmpty(skipUrls) && skipUrls.stream().anyMatch(pattern->antPathMatcher.match(pattern, originUrl)))
                || AuthenticatedHandler.getDefaultSkipUrls().stream().anyMatch(pattern->antPathMatcher.match(pattern, originUrl));
    }

    /**
     * 凭证验证
     * @param request
     * @param response
     */
    protected abstract void doAuthenticate(HttpServletRequest request, HttpServletResponse response);


}
