package com.fiee.fieeblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.dto.ArticleBackDTO;
import com.fiee.fieeblog.dto.ArticleHomeDTO;
import com.fiee.fieeblog.entity.Article;
import com.fiee.fieeblog.entity.ArticleTag;
import com.fiee.fieeblog.entity.Category;
import com.fiee.fieeblog.entity.Tag;
import com.fiee.fieeblog.service.ArticleService;
import com.fiee.fieeblog.mapper.ArticleMapper;
import com.fiee.fieeblog.service.ArticleTagService;
import com.fiee.fieeblog.service.CategoryService;
import com.fiee.fieeblog.service.TagService;
import com.fiee.fieeblog.utils.BeanCopyUtils;
import com.fiee.fieeblog.utils.UserUtils;
import com.fiee.fieeblog.vo.ArticleVO;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.fiee.fieeblog.enums.ArticleStatusEnum.DRAFT;

/**
 * @author Fiee
 * @description 针对表【tb_article】的数据库操作Service实现
 * @createDate 2023-04-11 16:48:23
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
        implements ArticleService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleTagService articleTagService;

    @Autowired
    private TagService tagService;

    /**
     * 首页文章
     * @return
     */
    @Override
    public List<ArticleHomeDTO> getHomeArticles() {
        return baseMapper.homeArticleList();
    }

    /**
     * 新增或者更新文章
     *
     * @param vo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateArticle(ArticleVO vo) {
        //保存分类
        Category category = saveArticleCategory(vo);
        System.out.println(category);
        //保存或者修改文章
        Article article = BeanCopyUtils.copyObject(vo, Article.class);
        //设置分类id
        if (Objects.nonNull(category)) {
            article.setCategoryId(category.getId());
        }
        //设置发表文章用户id
        article.setUserId(UserUtils.getLoginUser().getUserInfoId());
        this.saveOrUpdate(article);
        //保存标签
        saveArticleTag(vo, article.getId());
        return true;
    }

    /**
     * 保存标签
     *
     * @param vo
     * @param articleId
     */
    private void saveArticleTag(ArticleVO vo, Integer articleId) {
        //如果是编辑文章 则删除所有该文章绑定的标签
        if (Objects.nonNull(vo.getId())) {
            LambdaQueryWrapper<ArticleTag> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ArticleTag::getArticleId, vo.getId());
            articleTagService.remove(wrapper);
        }
        List<String> tagNameList = vo.getTagNameList();
        if (CollectionUtils.isNotEmpty(tagNameList)) {
            LambdaQueryWrapper<Tag> wrapper = new LambdaQueryWrapper<>();
            wrapper.in(Tag::getTagName, vo.getTagNameList());

            //已存在的标签
            List<Tag> existTagList = tagService.list(wrapper);
            List<String> existTagNameList = existTagList.stream().map(Tag::getTagName).collect(Collectors.toList());
            List<Integer> existTagIdList = existTagList.stream().map(Tag::getId).collect(Collectors.toList());

            //对比新增不存在的标签
            tagNameList.removeAll(existTagNameList);

            if (CollectionUtils.isNotEmpty(tagNameList)) {
                List<Tag> tagList = tagNameList.stream().map(
                        item -> Tag.builder().tagName(item).build()
                ).collect(Collectors.toList());
                //新增的标签
                tagService.saveBatch(tagList);
                //收集tagId
                List<Integer> tagIdList = tagList.stream().map(Tag::getId).collect(Collectors.toList());
                existTagIdList.addAll(tagIdList);
            }

            //绑定标签
            List<ArticleTag> articleTagList = existTagIdList.stream()
                    .map(item -> ArticleTag.builder().tagId(item).articleId(articleId).build())
                    .collect(Collectors.toList());
            articleTagService.saveBatch(articleTagList);
        }
    }

    /**
     * 保存分类
     *
     * @param vo
     * @return
     */
    private Category saveArticleCategory(ArticleVO vo) {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getCategoryName, vo.getCategoryName());
        Category category = categoryService.getOne(wrapper);
        //判断该分类是否存在 存在返回不存在则新增
        if (Objects.isNull(category) && !vo.getStatus().equals(DRAFT.getStatus())) {
            category = Category.builder().categoryName(vo.getCategoryName()).build();
            categoryService.save(category);
        }
        return category;
    }

    /**
     * 根据id查看后台文章
     *
     * @param id
     * @return
     */
    @Override
    public ArticleVO getArticleById(Integer id) {
        return null;
    }

    /**
     * 查询后台文章
     * @param vo
     * @return
     */
    @Override
    public PageResult<ArticleBackDTO> getBackArticle(ConditionVO vo) {
        //查询总条数
        //TODO 按条件查询

        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();

        Integer count = Math.toIntExact(this.count(null));

        List<ArticleBackDTO> articleList =
                baseMapper.backArticleList(vo, (vo.getCurrent() - 1) * vo.getSize(), vo.getSize());

        return new PageResult<>(articleList,count);
    }
}




