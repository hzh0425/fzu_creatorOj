package com.moxi.auth.config.security;


import com.moxi.auth.config.bean.CustomAccessDecisionManager;
import com.moxi.auth.config.bean.MyFilterInvocationSecurityMetadataSource;
import com.moxi.auth.server.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.PostConstruct;

/**
 * 〈security配置〉
 * 配置Spring Security
 * ResourceServerConfig 是比SecurityConfig 的优先级低的
 * @author wangmx
 * @since 1.0.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailService userDetailService;

    //密码模式才需要配置,认证管理器
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                antMatcher("/oauth/**")
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .and()
                .authorizeRequests()
                //.antMatchers("/api/**").hasAuthority("helloqweojikaosdf")
                .and().csrf().disable();
    }
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
//                .inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("zisuu").password("$2a$10$uCe9XdXVcDZo5/7XAWgop.0lqhWFxVoZesD2zbya5gKw70HvuCtz.").roles("ADMIN");
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
