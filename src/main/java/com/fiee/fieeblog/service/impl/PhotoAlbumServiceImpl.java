package com.fiee.fieeblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.PhotoAlbum;
import com.fiee.fieeblog.service.PhotoAlbumService;
import com.fiee.fieeblog.mapper.PhotoAlbumMapper;
import com.github.houbb.heaven.util.lang.StringUtil;
import org.springframework.stereotype.Service;


import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_photo_album(相册)】的数据库操作Service实现
* @createDate 2023-05-09 15:12:10
*/
@Service
public class PhotoAlbumServiceImpl extends ServiceImpl<PhotoAlbumMapper, PhotoAlbum>
    implements PhotoAlbumService{

    @Override
    public List<PhotoAlbum> getPhotoAlbums(String keywords) {
        LambdaQueryWrapper<PhotoAlbum> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtil.isEmpty(keywords),PhotoAlbum::getAlbumName,keywords);
        List<PhotoAlbum> list = this.list(wrapper);
        return list;
    }
}




