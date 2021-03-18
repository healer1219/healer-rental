package com.healer.user.realm;

import com.healer.user.domain.Permission;
import com.healer.user.domain.Role;
import com.healer.user.domain.User;
import com.healer.user.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李泽炜
 * @package cn.itcast.shiro.realm
 * @time 2021/2/28 13:48
 * @Description 自定义的realm域
 */
public class CustomRealm extends AuthorizingRealm {

    @Override
    public void setName(String name){
        super.setName("customRealm");
    }


    @Autowired
    private UserService userService;

    /**
     * 授权
     *  操作的时候判断用户是否具有相应的权限
     *      先认证  ----  安全数据
     *      再授权  ----  根据安全数据获取用户具有的所有权限
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1.获取已认证的用户数据
        User user = (User) principals.getPrimaryPrincipal();    //得到唯一的安全数据
        //2.根据用户数据获取用户的权限信息(所有角色，所有权限)
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //存储所有角色
        Set<String> roles = new HashSet<>();
        //存储所有权限
        Set<String> perms = new HashSet<>();
        for (Role role : user.getRoles()) {
            roles.add(role.getName());
            for (Permission perm : role.getPermissions()) {
                perms.add(perm.getCode());
            }
        }
        //返回当前用户所有权限
        info.setStringPermissions(perms);
        //返回当前用户所有角色
        info.setRoles(roles);
        return info;
    }

    /**
     * 认证
     * @param token 传递的用户名和密码
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.获取登录的用户名和密码
        UsernamePasswordToken uptoken = (UsernamePasswordToken) token;
        String phone = uptoken.getUsername();
        String password = new String(uptoken.getPassword());
        //2.根据用户名和密码查询数据库
        User user = userService.findByPhone(phone);
        //3.判断用户是否存在或者密码是否一致
        if (user != null && user.getPassword().equals(password)){
            //4.如果一致返回数据
            /**
             * SimpleAuthenticationInfo()构造方法三个参数
             *      1.安全数据
             *      2.密码
             *      3.realm域名
             */
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
            return info;
        }
        //5.不一致，返回null
        return null;
    }
}
