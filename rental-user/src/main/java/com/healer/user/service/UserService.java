package com.healer.user.service;

import com.healer.common.utils.IdWorker;
import com.healer.user.dao.UserDao;
import com.healer.user.domain.User;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private IdWorker idWorker;

    public User findByName(String name) {
        return userDao.findByUsername(name);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User addUser(User user){

        String password = user.getPassword();
        String username = user.getUsername();
        //使用md5对密码进行加密
        user.setPassword(new Md5Hash(password, username, 3).toString());

        //设置用户id(id使用雪花算法生成)
        String id = idWorker.nextId()+"";
        user.setId(id);
        user.setIsRealName(0);
        //校验手机号的唯一性
        if (userDao.findByPhone(user.getPhone()) == null){
            //保存user
            User savedUser = userDao.save(user);
            return savedUser;
        }
        return null;



    }

    /**
     * 手机号登录
     * @param phone
     * @return
     */
    public User findByPhone(String phone){
        return userDao.findByPhone(phone);
    }
}
