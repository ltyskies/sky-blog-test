package com.sky.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.dto.BlogTypesDTO;
import com.sky.dto.BlogTypesPageQueryDTO;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.BlogMapper;
import com.sky.mapper.BlogTypesMapper;
import com.sky.po.Blog;
import com.sky.po.BlogOfTypes;
import com.sky.po.BlogTypes;
import com.sky.result.PageResult;
import com.sky.service.BlogTypesService;
import com.sky.vo.BlogTypesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogTypesServiceImpl implements BlogTypesService {

    @Autowired
    private BlogTypesMapper blogTypesMapper;

    @Autowired
    private BlogMapper blogMapper;
    /**
     * 博客分类分页查询
     * @param blogTypesPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(BlogTypesPageQueryDTO blogTypesPageQueryDTO) {
        PageHelper.startPage(blogTypesPageQueryDTO.getPage(),blogTypesPageQueryDTO.getPageSize());

        Page<BlogTypes> page = blogTypesMapper.pageQuery(blogTypesPageQueryDTO);
        System.out.println(page);
        long total = page.getTotal();
        List<BlogTypes> list = page.getResult();
        System.out.println(list);
        return  new PageResult(total,list);
    }
    /**
     * 新增博客分类
     * @param blogTypesDTO
     * @return
     */
    @Override
    public void save(BlogTypesDTO blogTypesDTO) {
        BlogTypes blogTypes = new BlogTypes();
        BeanUtils.copyProperties(blogTypesDTO,blogTypes);

        blogTypesMapper.insert(blogTypes);
    }

    /**
     * 批量删除博客分类
     * @param ids
     */
    @Override
    public void deleteBatch(List<Long> ids) {
        for (Long id : ids) {
            BlogTypes blogTypes = blogTypesMapper.getById(id);
            if(blogTypes.getNumber()!=0){
                throw  new DeletionNotAllowedException(MessageConstant.TYPES_OWN_BLOG);
            }
        }

        for (Long id : ids) {
            blogTypesMapper.deleteById(id);
        }
    }
    /**
     * 编辑博客分类信息
     * @param blogTypesDTO
     * @return
     */
    @Override
    public void update(BlogTypesDTO blogTypesDTO) {
        BlogTypes blogTypes = new BlogTypes();
        BeanUtils.copyProperties(blogTypesDTO,blogTypes);
        blogTypesMapper.update(blogTypes);
    }

    /**
     * 根据id查询分类信息
     * @param id
     * @return
     */
    @Override
    public BlogTypesVO getById(Long id) {
        BlogTypes blogTypes = blogTypesMapper.getById(id);
        BlogTypesVO blogTypesVO = new BlogTypesVO();
        BeanUtils.copyProperties(blogTypes,blogTypesVO);

        List<Blog> blogs= blogMapper.getByTypeId(id);
        List<BlogOfTypes> blogOfTypesList= BeanUtil.copyToList(blogs,BlogOfTypes.class);

        blogTypesVO.setBlogs(blogOfTypesList);

        return blogTypesVO;

    }

}
