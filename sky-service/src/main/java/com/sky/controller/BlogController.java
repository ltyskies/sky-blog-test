package com.sky.controller;

import com.sky.dto.BlogDTO;
import com.sky.dto.BlogPageQueryDTO;
import com.sky.dto.BlogTypesDTO;
import com.sky.dto.BlogTypesPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.BlogService;
import com.sky.vo.BlogTypesVO;
import com.sky.vo.BlogVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/blog")
@Slf4j
@Api(tags = "博客相关接口")
public class BlogController {
    @Autowired
    private BlogService blogService;


     /**
     * 博客分页查询
     * @param blogPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("博客分页查询")
    public Result<PageResult> page(BlogPageQueryDTO blogPageQueryDTO) {
        log.info("博客分页查询");
        PageResult pageResult = blogService.pageQuery(blogPageQueryDTO);
        return Result.success(pageResult);
    }
    /**
     * 新增博客
     * @param blogDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增博客")
    public Result save(@RequestBody BlogDTO blogDTO) {
        log.info("新增博客");
        blogService.save(blogDTO);
        return Result.success();
    }


    /**
     * 批量删除博客
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("批量删除博客")
    public Result delete(@RequestParam List<Long> ids) {
        log.info("博客分类批量删除");
        blogService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 更改博客
     * @param blogDTO
     * @return
     */
    @PutMapping
    @ApiOperation("编辑博客")
    public Result update(@RequestBody BlogDTO blogDTO) {
        blogService.update(blogDTO);
        return Result.success();
    }
    /**
     * 根据id查询博客
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据ID查询博客")
    public Result<BlogVO> get(@PathVariable Long id) {
        BlogVO blogVO = blogService.getById(id);
        return Result.success(blogVO);
    }
}
