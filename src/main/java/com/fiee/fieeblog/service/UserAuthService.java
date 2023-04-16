package com.fiee.fieeblog.service;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.dto.UserBackDTO;
import com.fiee.fieeblog.dto.UserOnlineDTO;
import com.fiee.fieeblog.entity.UserAuth;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;

import java.util.Map;


/**
* @author Fiee
* @description 针对表【tb_user_auth】的数据库操作Service
* @createDate 2023-02-24 13:34:45
*/
public interface UserAuthService extends IService<UserAuth> {
    /**
     * 获取用户列表
     * @param condition
     * @return
     */
    PageResult<UserBackDTO> getUserList(ConditionVO condition);

    /**
     * 更新用户禁用状态
     * @param userAuth
     * @return
     */
    boolean updateUserState(UserAuth userAuth);

    /**
     * 获取在线用户
     * @return
     */
    PageResult<UserOnlineDTO> getOnlineUsers(ConditionVO conditionVO);

    /**
     * 下线用户
     * @param userInfoId
     */
    void removeUser(Integer userInfoId);

    /**
     * 修改用户角色
     * @param map
     * @return
     */
    boolean updateUserRole(Map map);

    /**
     * 修改密码
     * @param map
     * @return
     */
    boolean updateUserInfo(Map map);

    /**
     * 发送邮箱验证码
     * @param username
     */
    void sendCode(String username);
}
