package com.fiee.fieeblog.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.Photo;
import com.fiee.fieeblog.service.PhotoService;
import com.fiee.fieeblog.mapper.PhotoMapper;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;
import com.github.houbb.heaven.util.lang.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_photo(照片)】的数据库操作Service实现
* @createDate 2023-05-09 15:16:30
*/
@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo>
    implements PhotoService{

    @Override
    public PageResult<Photo> getPhotoList(ConditionVO vo) {
        LambdaQueryWrapper<Photo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(!StrUtil.hasBlank(vo.getIsDelete().toString()),Photo::getIsDelete,vo.getIsDelete());
        wrapper.eq(vo.getAlbumId()!=null,Photo::getAlbumId,vo.getAlbumId());
        Integer count = Math.toIntExact(this.count(wrapper));
        List<Photo> list = baseMapper.getPhotoList(vo, (vo.getCurrent() - 1) * vo.getSize(), vo.getSize());
        return new PageResult<>(list,count);
    }
}



