package com.happy.admin.auth.handler;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/07/07 9:09 上午
 */
public class AuthenticatedHandler {

    private static final List<String> DEFAULT_SKIP_URLS = Lists.newArrayList();

    static {
        DEFAULT_SKIP_URLS.add("/happy/auth/**");
        DEFAULT_SKIP_URLS.add("/happy/captcha/**");

        DEFAULT_SKIP_URLS.add("/actuator/health/**");
        DEFAULT_SKIP_URLS.add("/log/**");
        DEFAULT_SKIP_URLS.add("/error/**");
        DEFAULT_SKIP_URLS.add("/assets/**");

        DEFAULT_SKIP_URLS.add("/doc.html");
        DEFAULT_SKIP_URLS.add("/webjars/**");
        DEFAULT_SKIP_URLS.add("/v2/api-docs/**");
        DEFAULT_SKIP_URLS.add("/swagger-resources");
    }

    /**
     * 默认无需鉴权的API
     */
    public static List<String> getDefaultSkipUrls() {
        return DEFAULT_SKIP_URLS;
    }
}
