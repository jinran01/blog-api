package com.fiee.fieeblog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.UserAuth;
import com.fiee.fieeblog.entity.UserInfo;
import com.fiee.fieeblog.mapper.UserInfoMapper;
import com.fiee.fieeblog.service.UserAuthService;
import com.fiee.fieeblog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author Fiee
* @description 针对表【tb_user_info】的数据库操作Service实现
* @createDate 2023-02-24 15:21:40
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

    @Override
    public String updateUserAvatar(UserInfo userInfo) {
        UserInfo user = this.getById(userInfo.getId());
        String avatar = userInfo.getAvatar();
        String new_avatar = "https://spring-boot-blog-api.oss-cn-hangzhou.aliyuncs.com/" + avatar ;
        System.out.println(new_avatar);
        user.setAvatar(new_avatar);
        this.updateById(user);
        return new_avatar;
    }

}




