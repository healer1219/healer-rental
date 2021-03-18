package com.healer.user.controller;

import com.healer.common.entity.Result;
import com.healer.common.entity.ResultCode;
import com.healer.user.domain.DriverLicense;
import com.healer.user.domain.RealName;
import com.healer.user.domain.User;
import com.healer.user.service.DriverLicenseService;
import com.healer.user.service.RealNameService;
import com.healer.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(value =  "http://localhost:8080" )
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DriverLicenseService driverLicenseService;

    @Autowired
    private RealNameService realNameService;


    /**
     * 个人主页
     * 1.过滤器：如果权限信息不匹配，跳转到setUnauthorizedUrl的地址
     * 2.注解：如果权限信息不匹配，抛出异常
     */
    //@RequiresPermissions()    -- 访问此方法必须具备的权限
    //@RequiresRoles()  --  访问此方法必须具备的角色
    //@RequiresPermissions("user-home")
    @RequestMapping(value = "/user/home",method = RequestMethod.POST)
    public User home(String phone){
        User user = userService.findByPhone(phone);
        user.setPassword("隐藏密码");
        return user;
    }

    /**添加
     *
     * @return
     */
    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public Result add(@RequestBody User user) {
        User addUser = userService.addUser(user);
        if (addUser != null){
            return new Result(ResultCode.SUCCESS, addUser);
        }
        return new Result(ResultCode.Phone_EXISTED);
    }

    /**
     * 查询
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String find() {
        return "查询用户成功";
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String update(String id) {
        return "更新用户成功";
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String delete() {
        return "删除用户成功";
    }

    /**
     * 用户登录
     *  传统登录
     *      前端发送请求 ==> 接口部分获取用户名密码 ==> 程序员在接口部分手动控制
     *  shiro登录
     *      前端发送请求 ==> 接口部分获取用户名密码 ==> 通过subject.login ==> realm域的认证方法
     *
     * @return
     */
	@PostMapping(value="/login")
    public Result login(String phone, String password) {
        System.out.println("用户登录");
		//1.构造登录令牌
        try {
            /**
             * 密码加密：
             *     shiro提供的md5加密
             *     Md5Hash:
             *      参数1：加密内容
             *              11111==>abcd
             *      参数2：盐(加密的混淆字符串)(通常使用用户登录的用户名)
             *              11111+混淆字符串
             *      参数3：加密次数
             */
            password = new Md5Hash(password, phone, 3).toString();

            System.out.println(password);

            UsernamePasswordToken upToken = new UsernamePasswordToken(phone,password);
            //2.获取subject
            Subject subject = SecurityUtils.getSubject();

            //获取session
            String sid = (String) subject.getSession().getId();
            //3.调用subject进行登录
            subject.login(upToken);
            User home = this.home(phone);
            //return "登录成功"+sid;
            return new Result(ResultCode.SUCCESS, home);
        } catch (AuthenticationException e) {
            return new Result(ResultCode.FAIL);
        }

    }

    @RequestMapping(value = "/autherror")
    public String autherror(int code){
	    return code == 1?"未登录":"未授权";
    }

    @GetMapping ("/driver")
    public DriverLicense dirverLicense(String img){
        return driverLicenseService.getDriveLicense(img);
    }
//    @GetMapping ("/isRealName")
//    public RealName idRealName(String img, String phone) throws IOException {
//        return realNameService.isRealName(img, phone);
//    }











































}
