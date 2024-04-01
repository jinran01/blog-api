package com.fiee.fieeblog.service;

import com.fiee.fieeblog.entity.Photo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;



/**
* @author Fiee
* @description 针对表【tb_photo(照片)】的数据库操作Service
* @createDate 2023-05-09 15:16:30
*/
public interface PhotoService extends IService<Photo> {

    PageResult<Photo> getPhotoList(ConditionVO vo);
}
