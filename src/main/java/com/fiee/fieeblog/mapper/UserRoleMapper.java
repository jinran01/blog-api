package com.fiee.fieeblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Fiee
* @description 针对表【tb_user_role】的数据库操作Mapper
* @createDate 2023-02-24 15:22:55
* @Entity .com.fiee.spring_security_auth.entity.UserRole
*/
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}




