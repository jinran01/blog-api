package com.fiee.fieeblog.mapper;

import com.fiee.fieeblog.entity.Photo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.vo.ConditionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_photo(照片)】的数据库操作Mapper
* @createDate 2023-05-09 15:16:30
* @Entity com.fiee.fieeblog.entity.Photo
*/
@Mapper
public interface PhotoMapper extends BaseMapper<Photo> {
    List<Photo> getPhotoList(@Param("vo") ConditionVO vo,Long current,Long size);
}




