package com.fiee.fieeblog.mapper;

import com.fiee.fieeblog.entity.OperationLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.vo.ConditionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_operation_log】的数据库操作Mapper
* @createDate 2023-03-26 16:21:24
* @Entity com.fiee.fieeblog.entity.operationLog
*/
@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLog> {
    List<OperationLog> getOperations(@Param("current") Long current, @Param("size") Long size,@Param("vo") ConditionVO conditionVo);
}




