package com.happy.admin.auth.config;

import com.google.common.collect.Lists;
import com.happy.admin.auth.password.Md5PasswordEncoder;
import com.happy.admin.auth.password.NonePasswordEncoder;
import com.happy.admin.auth.password.PasswordEncoder;
import com.happy.admin.auth.service.UserAccountService;
import com.happy.admin.auth.token.TokenGranter;
import com.happy.admin.auth.token.TokenService;
import com.happy.admin.auth.token.TokenStore;
import com.happy.admin.auth.token.granter.CompositeTokenGranter;
import com.happy.admin.auth.token.granter.PasswordTokenGranter;
import com.happy.admin.auth.token.granter.RefreshTokenGranter;
import com.happy.admin.auth.token.service.DefaultTokenService;
import com.happy.admin.auth.token.store.InMemoryTokenStore;
import com.happy.admin.auth.user.AuthUserService;
import cool.happycoding.code.base.user.UserContextService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 5:41 下午
 */
@Configuration
@RequiredArgsConstructor
public class HappyAuthConfiguration {

    private final UserAccountService userAccountService;

    @Bean
    @ConditionalOnMissingBean
    public TokenService tokenService(TokenStore tokenStore){
        return new DefaultTokenService(tokenStore);
    }

    @Bean
    @ConditionalOnMissingBean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

    @Bean
    @ConditionalOnMissingBean
    public PasswordEncoder passwordEncoder(){
        return new NonePasswordEncoder();
    }

    @Bean
    public TokenGranter tokenGranter(){
        return new CompositeTokenGranter(getDefaultTokenGranters());
    }

    private List<TokenGranter> getDefaultTokenGranters(){
        List<TokenGranter> granters =  Lists.newArrayList();
        granters.add(new PasswordTokenGranter(tokenService(tokenStore()), userAccountService, passwordEncoder()));
        granters.add(new RefreshTokenGranter(tokenService(tokenStore()), tokenStore()));
        return granters;
    }
}
