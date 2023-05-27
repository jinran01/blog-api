package com.fiee.fieeblog.service;

import com.fiee.fieeblog.entity.PhotoAlbum;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_photo_album(相册)】的数据库操作Service
* @createDate 2023-05-09 15:12:10
*/
public interface PhotoAlbumService extends IService<PhotoAlbum> {

    List<PhotoAlbum> getPhotoAlbums(String keywords);
}
