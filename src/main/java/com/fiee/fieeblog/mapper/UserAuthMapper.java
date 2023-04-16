package com.fiee.fieeblog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.dto.UserBackDTO;
import com.fiee.fieeblog.entity.UserAuth;
import com.fiee.fieeblog.vo.ConditionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_user_auth】的数据库操作Mapper
* @createDate 2023-02-24 13:34:45
* @Entity .com.fiee.spring_security_auth.entity.UserAuth
*/
@Mapper
public interface UserAuthMapper extends BaseMapper<UserAuth> {
    /**
     * 查询后台用户列表
     *
     * @param current   页码
     * @param size      大小
     * @param condition 条件
     * @return {@link List < UserBackDTO >} 用户列表
     */
    List<UserBackDTO> listUsers(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO condition);

    /**
     * 查询后台用户数量
     *
     * @param condition 条件
     * @return 用户数量
     */
    Integer countUser(@Param("condition") ConditionVO condition);
}




