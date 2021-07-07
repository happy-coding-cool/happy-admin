package com.happy.admin.auth.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/07/07 8:39 上午
 */
public class HappyAuthenticatedFilter extends AbstractAuthenticatedFilter {

    public HappyAuthenticatedFilter(List<String> skipUrls) {
        super(skipUrls);
    }

    @Override
    protected void doAuthenticate(HttpServletRequest request, HttpServletResponse response) {

    }

}
