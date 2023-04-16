package com.fiee.fieeblog.utils;

import com.fiee.fieeblog.dto.UserDetailDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * 用户工具类
 */
@Component
public class UserUtils {

    /**
     * 获取当前登录用户
     *
     * @return 用户登录信息
     */
    public static UserDetailDTO getLoginUser() {
        return (UserDetailDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
