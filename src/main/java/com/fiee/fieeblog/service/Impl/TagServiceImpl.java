package com.fiee.fieeblog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.Tag;
import com.fiee.fieeblog.service.TagService;
import com.fiee.fieeblog.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author Fiee
* @description 针对表【tb_tag】的数据库操作Service实现
* @createDate 2023-04-09 21:11:19
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




