package com.fiee.fieeblog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.OperationLog;
import com.fiee.fieeblog.service.OperationLogService;
import com.fiee.fieeblog.mapper.OperationLogMapper;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_operation_log】的数据库操作Service实现
* @createDate 2023-03-26 16:21:24
*/
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {
    /**
     * 获取操作日志列表
     * @param vo
     * @return
     */
    @Override
    public PageResult<OperationLog> getOperations(ConditionVO vo) {

        LambdaQueryWrapper<OperationLog> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isBlank(vo.getKeywords()),OperationLog::getOptDesc,vo.getKeywords());
        wrapper.like(!StringUtils.isBlank(vo.getKeywords()),OperationLog::getOptModule,vo.getKeywords());
        //日志条数
        Integer count = Math.toIntExact(this.count(wrapper));
        List operations = baseMapper.getOperations(
                (vo.getCurrent() - 1) * vo.getSize(),
                vo.getSize(), vo);
        return new PageResult<>(operations,count);
    }

    /**
     * 删除操作日志
     * @param ids
     * @return
     */
    @Override
    public boolean delOperations(List<Integer> ids) {
        return this.removeBatchByIds(ids);
    }
}




