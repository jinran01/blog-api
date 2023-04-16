package com.fiee.fieeblog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.Resource;
import com.fiee.fieeblog.exception.BizException;
import com.fiee.fieeblog.mapper.ResourceMapper;
import com.fiee.fieeblog.service.RedisService;
import com.fiee.fieeblog.service.ResourceService;
import com.fiee.fieeblog.utils.ResourceHelper;
import javassist.ClassMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fiee
 * @description 针对表【tb_resource】的数据库操作Service实现
 * @createDate 2023-02-24 15:17:39
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource>
        implements ResourceService {
    @Autowired
    private RedisService redisService;

    @Override
    public List<Resource> getResourceList(String resourceName) {
        boolean flag = !StringUtils.isBlank(resourceName);
        if (flag){
            LambdaQueryWrapper<Resource> wrapper = new LambdaQueryWrapper<>();
            wrapper.like(true,Resource::getResourceName,resourceName);
            List<Resource> list = baseMapper.selectList(wrapper);
            List<Resource> resourceList = ResourceHelper.resourceHelper(list);
            return resourceList;
        }else {
            if (redisService.get("resourceList") != null && redisService.get("resourceList") != "") {
                List list = (List) redisService.get("resourceList");
                return list;
            } else {
                List<Resource> list = baseMapper.selectList(null);
                List<Resource> resourceList = ResourceHelper.resourceHelper(list);
                redisService.set("resourceList",resourceList);
                return resourceList;
            }
        }
    }

//    /**
//     * @param resourceName 通过名字查询资源
//     * @return
//     */
//    @Override
//    public List<Resource> getResource(String resourceName) {
//
//    }

    /**
     * @param resource 修改或新增资源
     * @return
     */
    @Override
    public boolean updateResource(Resource resource) {
        this.saveOrUpdate(resource);
        redisService.set("resourceList","");
        return true;
    }

    /**
     * 删除资源
     * @param id
     * @return
     */
    @Override
    public boolean delResource(Integer id) {
        Resource resource = this.getById(id);
        if (resource.getParentId() == null){
            LambdaQueryWrapper<Resource> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Resource::getParentId,id);
            long count = this.count(wrapper);
            if (count > 0){
                throw new BizException("该资源下还有子资源");
            }else {
                this.removeById(id);
                redisService.set("resourceList","");
                return true;
            }

        }else {
            this.removeById(id);
            redisService.set("resourceList","");
            return true;
        }
    }
}




