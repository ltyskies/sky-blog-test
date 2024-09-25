package com.sky.service;

import com.sky.dto.BlogDTO;
import com.sky.dto.BlogPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.BlogVO;

import java.util.List;

public interface BlogService {
     /**
     * 博客分页查询
     * @param blogPageQueryDTO
     * @return
     */
    PageResult pageQuery(BlogPageQueryDTO blogPageQueryDTO);

    /**
     * 写博客
     * @param blogDTO
     */
    void save(BlogDTO blogDTO);

    /**
     * 批量删除博客
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 更新博客
     * @param blogDTO
     */
    void update(BlogDTO blogDTO);

    /**
     * 根据ID查询博客
     * @param id
     * @return
     */
    BlogVO getById(Long id);
}
