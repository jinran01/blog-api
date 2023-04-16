package com.fiee.fieeblog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.entity.UserInfo;

import java.util.Map;

/**
* @author Fiee
* @description 针对表【tb_user_info】的数据库操作Service
* @createDate 2023-02-24 15:21:40
*/
public interface UserInfoService extends IService<UserInfo> {

    String updateUserAvatar(UserInfo userInfo);


}
