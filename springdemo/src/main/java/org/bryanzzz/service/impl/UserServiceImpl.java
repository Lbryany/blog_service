package org.bryanzzz.service.impl;

import org.apache.commons.lang.StringUtils;
import org.bryanzzz.common.JsonWebToken;
import org.bryanzzz.dao.UserDao;
import org.bryanzzz.dto.UserExecution;
import org.bryanzzz.entity.User;
import org.bryanzzz.enums.UserStateEnums;
import org.bryanzzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserExecution userLogin(User user) {
        String username = user.getUsername();
        User userRes = userDao.queryByUsername(username);
        String md5Pwd = md5(user.getPassword());
        if(userRes == null){
            return new UserExecution(UserStateEnums.FAIL);
        }
        if(userRes.getPassword().equals(md5Pwd)){
            long uid = userRes.getUserId();
            // 暂时屏蔽jwt，使用session实现保持登录态
//            String token = JsonWebToken.createJWT(uid, "LbryanyBlog", 60*60*1000);
            return new UserExecution(uid, UserStateEnums.SUCCESS);
        }else{
            return new UserExecution(UserStateEnums.FAIL);
        }

    }

    private static String md5(String plainText){
        String result = null;
        //首先判断是否为空
        if(StringUtils.isBlank(plainText)){
            return null;
        }
        try{
            //首先进行实例化和初始化
            MessageDigest md = MessageDigest.getInstance("MD5");
            //得到一个操作系统默认的字节编码格式的字节数组
            byte[] btInput = plainText.getBytes();
            //对得到的字节数组进行处理
            md.update(btInput);
            //进行哈希计算并返回结果
            byte[] btResult = md.digest();
            //进行哈希计算后得到的数据的长度
            StringBuffer sb = new StringBuffer();
            for(byte b : btResult){
                int bt = b&0xff;
                if(bt<16){
                    sb.append(0);
                }
                sb.append(Integer.toHexString(bt));
            }
            result = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return result;
    }
}
