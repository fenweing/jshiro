package com.tuanbaol.jshiro.shiro;

import com.tuanbaol.jshiro.bean.User;
import com.tuanbaol.jshiro.service.RoleService;
import com.tuanbaol.jshiro.service.UserRoleService;
import com.tuanbaol.jshiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class ShiroRealm extends AuthorizingRealm {
    private final static String REALM_NAME = "shiroRealm";
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String name = (String) principals.getPrimaryPrincipal();
        simpleAuthorizationInfo.setRoles(new HashSet<>(roleService.getNamesByUserName(name)));
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo();
        String name = (String) token.getPrincipal();
        User userDB = userService.getUserByName(name);
        SimplePrincipalCollection simplePrincipalCollection = new SimplePrincipalCollection(name, REALM_NAME);
        authInfo.setPrincipals(simplePrincipalCollection);
        authInfo.setCredentials(userDB.getPassword());
        return authInfo;
    }
}
