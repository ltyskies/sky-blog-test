package com.sky.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.context.BaseContext;
import com.sky.dto.BlogDTO;
import com.sky.dto.BlogPageQueryDTO;
import com.sky.dto.BlogTypesDTO;
import com.sky.dto.BlogTypesPageQueryDTO;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.BlogMapper;
import com.sky.mapper.BlogTypesMapper;
import com.sky.mapper.UserMapper;
import com.sky.po.Blog;
import com.sky.po.BlogOfTypes;
import com.sky.po.BlogTypes;
import com.sky.po.UserInfo;
import com.sky.result.PageResult;
import com.sky.service.BlogService;
import com.sky.vo.BlogTypesVO;
import com.sky.vo.BlogVO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private BlogTypesMapper blogTypesMapper;

    @Autowired
    private UserMapper userMapper;
     /**
     * 博客分页查询
     * @param blogPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(BlogPageQueryDTO blogPageQueryDTO) {
        PageHelper.startPage(blogPageQueryDTO.getPage(),blogPageQueryDTO.getPageSize());

        Page<BlogTypes> page = blogMapper.pageQuery(blogPageQueryDTO);
        System.out.println(page);
        long total = page.getTotal();
        List<BlogTypes> list = page.getResult();
        System.out.println(list);
        return  new PageResult(total,list);
    }

   /**
     * 新增博客
     * @param blogDTO
     * @return
     */
    @Transactional
    @Override
    public void save(BlogDTO blogDTO) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDTO,blog);

        blogMapper.insert(blog);

        Long ofTypesID = blog.getOfTypes();

        BlogTypes blogTypes =  blogTypesMapper.getById(ofTypesID);

        int number = blogTypes.getNumber();

        blogTypes.setNumber(number + 1);

        blogTypesMapper.update(blogTypes);

        Long id = BaseContext.getCurrentId();

        System.out.println("当前用户id为："+id);

        UserInfo user = userMapper.getInfo(id);

        int blogNumber = user.getBlogNumber();

        System.out.println("当前博客数量为"+blogNumber);
        user.setBlogNumber(blogNumber + 1);

        userMapper.update(user);

    }

    /**
     * 批量删除博客
     * @param ids
     */
    @Transactional
    @Override
    public void deleteBatch(List<Long> ids) {
        for (Long id : ids) {
            Blog blog = blogMapper.getById(id);

            blogMapper.deleteById(id);

            Long ofTypesID = blog.getOfTypes();

            BlogTypes blogTypes = blogTypesMapper.getById(ofTypesID);

            int number = blogTypes.getNumber();

            blogTypes.setNumber(number - 1);

            blogTypesMapper.update(blogTypes);

            Long userId = BaseContext.getCurrentId();

            System.out.println("当前用户id为："+userId);

            UserInfo user = userMapper.getInfo(userId);

            int blogNumber = user.getBlogNumber();

            System.out.println("当前博客数量为"+blogNumber);

            user.setBlogNumber(blogNumber - 1);

            userMapper.update(user);
        }

    /**
     * 更改博客
     * @param blogDTO
     * @return
     */
    }
    @Transactional
    @Override
    public void update(BlogDTO blogDTO) {
        Long id = blogDTO.getId();
        System.out.println("当前分类"+blogDTO.getOfTypes());
        Blog blog = blogMapper.getById(id);
        Long originOfTypes = blog.getOfTypes();
        Long nowOfTypes = blogDTO.getOfTypes();

        if(originOfTypes != nowOfTypes){
            BlogTypes originBlogTypes = blogTypesMapper.getById(originOfTypes);
            int originblogNumber = originBlogTypes.getNumber();
            originBlogTypes.setNumber(originblogNumber - 1);
            blogTypesMapper.update(originBlogTypes);

            BlogTypes nowBlogTypes = blogTypesMapper.getById(nowOfTypes);
            int nowblogNumber = nowBlogTypes.getNumber();
            nowBlogTypes.setNumber(nowblogNumber + 1);
            blogTypesMapper.update(nowBlogTypes);
        }
        BeanUtils.copyProperties(blogDTO,blog);
        blogMapper.update(blog);
    }

    /**
     * 根据ID查询博客
     * @param id
     * @return
     */
    @Override
    public BlogVO getById(Long id) {
        Blog blog = blogMapper.getById(id);
        BlogVO blogVO = new BlogVO();
        BeanUtils.copyProperties(blog,blogVO);
        return blogVO;
    }


}
