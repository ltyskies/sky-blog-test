package com.sky.service;

import com.sky.dto.BlogTypesDTO;
import com.sky.dto.BlogTypesPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.BlogTypesVO;

import java.util.List;

public interface BlogTypesService {
    /**
     * 博客分类分页查询
     * @param blogTypesPageQueryDTO
     * @return
     */    
    PageResult pageQuery(BlogTypesPageQueryDTO blogTypesPageQueryDTO);
    /**
     * 新增博客分类
     * @param blogTypesDTO
     * @return
     */
    void save(BlogTypesDTO blogTypesDTO);

    /**
     * 批量删除博客分类
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据博客信息
     * @param blogTypesDTO
     */
    void update(BlogTypesDTO blogTypesDTO);

    /**
     * 根据ID查询博客信息
     * @param id
     * @return
     */
    BlogTypesVO getById(Long id);
}
