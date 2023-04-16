package com.fiee.fieeblog.service;

import com.fiee.fieeblog.entity.OperationLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;
import io.swagger.models.auth.In;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_operation_log】的数据库操作Service
* @createDate 2023-03-26 16:21:24
*/
public interface OperationLogService extends IService<OperationLog> {

    PageResult<OperationLog> getOperations(ConditionVO conditionVO);

    boolean delOperations(List<Integer> ids);
}
