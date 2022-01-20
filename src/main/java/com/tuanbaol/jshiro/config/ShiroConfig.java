package com.tuanbaol.jshiro.config;

import com.tuanbaol.jshiro.shiro.CredentialMatcher;
import com.tuanbaol.jshiro.shiro.ShiroRealm;
import com.tuanbaol.jshiro.shiro.filter.CustomRolesAuthorizationFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public CredentialMatcher getCredentialMatcher() {
        return new CredentialMatcher();
    }

    @Bean
    public ShiroRealm getShiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(getCredentialMatcher());
        return shiroRealm;
    }

    @Bean
    public SessionManager getSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        sessionManager.setSessionDAO(sessionDAO);
        return sessionManager;
    }

    @Bean
    public SecurityManager getSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getShiroRealm());
        securityManager.setSessionManager(getSessionManager());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getSecurityManager());
        shiroFilterFactoryBean.setFilterChainDefinitionMap(getFilterChainDefinitionMap());
        shiroFilterFactoryBean.setFilters(getFilters());
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        return shiroFilterFactoryBean;
    }

    public Map<String, String> getFilterChainDefinitionMap() {
        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        filterChainDefinitionMap.put("/user/**", "authcBasic,anyRole[super,admin,app]");
        filterChainDefinitionMap.put("/role/**", "authcBasic,anyRole[super,admin]");
        filterChainDefinitionMap.put("/auth/login", "anon");
        filterChainDefinitionMap.put("/**", "authcBasic");
        return filterChainDefinitionMap;
    }

    public Map<String, Filter> getFilters() {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("anyRole", new CustomRolesAuthorizationFilter());
        return filterMap;
    }
}
