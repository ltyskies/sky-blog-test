package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.BlogTypesPageQueryDTO;
import com.sky.po.BlogTypes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BlogTypesMapper {
     /**
     * 博客分类分页查询
     * @param blogTypesPageQueryDTO
     * @return
     */
    Page<BlogTypes> pageQuery(BlogTypesPageQueryDTO blogTypesPageQueryDTO);
     /**
     * 新增博客分类
     * @param blogTypes
     * @return
     */
    @Insert("insert into sky_own_blog.blog_types (type_Name, number, description) VALUES (#{typeName},#{number},#{description})")
    void insert(BlogTypes blogTypes);

    /**
     * 根据ID查询博客
     * @param id
     * @return
     */
    @Select("select * from sky_own_blog.blog_types where id = #{id}")
    BlogTypes getById(Long id);

    /**
     * 根据ID删除博客分类
     * @param id
     */
    @Delete("delete from sky_own_blog.blog_types where id = #{id}")
    void deleteById(Long id);
    /**
     * 更改博客分类信息
     * @param blogTypes
     * @return
     */
    void update(BlogTypes blogTypes);
}
