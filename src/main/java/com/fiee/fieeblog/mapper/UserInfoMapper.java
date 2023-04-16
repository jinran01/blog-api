package com.fiee.fieeblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Fiee
* @description 针对表【tb_user_info】的数据库操作Mapper
* @createDate 2023-02-24 15:21:40
* @Entity com.fiee.spring_security_auth.entity.UserInfo
*/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}




