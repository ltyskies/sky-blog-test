package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.BlogPageQueryDTO;
import com.sky.enumeration.OperationType;
import com.sky.po.Blog;
import com.sky.po.BlogTypes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogMapper {
    /**
     * 根据归属分类查询博客
     * @param
     * @return
     */
    @Select("select * from sky_own_blog.blogs where of_Types= #{ofTypes}")
    List<Blog> getByTypeId(Long ofTypes);
     /**
     * 博客分页查询
     * @param blogPageQueryDTO
     * @return
     */
    Page<BlogTypes> pageQuery(BlogPageQueryDTO blogPageQueryDTO);
    /**
     * 写博客
     * @param blog
     */
    @AutoFill(value = OperationType.RELEASE)
    void insert(Blog blog);
    /**
     * 根据ID查询博客
     * @param id
     */
    @Select("select * from sky_own_blog.blogs where id = #{id}")
    Blog getById(Long id);

    /**
     * 根据ID删除博客
     * @param id
     */
    @Delete("delete from sky_own_blog.blogs where id = #{id}")
    void deleteById(Long id);

    /**
     * 更新博客
     * @param blog
     */
    @AutoFill(value = OperationType.RELEASE)
    void update(Blog blog);
}
