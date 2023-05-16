package com.fiee.fieeblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.Page;
import com.fiee.fieeblog.service.PageService;
import com.fiee.fieeblog.mapper.PageMapper;
import org.springframework.stereotype.Service;

/**
* @author Fiee
* @description 针对表【tb_page(页面)】的数据库操作Service实现
* @createDate 2023-04-06 22:18:13
*/
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page>
    implements PageService{

}




