package com.sky.controller;

import com.sky.dto.BlogTypesDTO;
import com.sky.dto.BlogTypesPageQueryDTO;
import com.sky.po.BlogTypes;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.BlogTypesService;
import com.sky.vo.BlogTypesVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/blog/types")
@Slf4j
@Api(tags = "博客分类相关接口")
public class BlogTypesController {
    @Autowired
    private BlogTypesService blogTypesService;

     /**
     * 博客分类分页查询
     * @param blogTypesPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("博客分类分页查询")
    public Result<PageResult> page(BlogTypesPageQueryDTO blogTypesPageQueryDTO) {
        log.info("博客分类分页查询");
        PageResult pageResult = blogTypesService.pageQuery(blogTypesPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 新增博客分类
     * @param blogTypesDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增博客分类")
    public Result save(@RequestBody BlogTypesDTO blogTypesDTO) {
        log.info("新增博客");
        blogTypesService.save(blogTypesDTO);
        return Result.success();
    }

    /**
     * 批量删除博客分类
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("批量删除博客分类")
    public Result delete(@RequestParam List<Long> ids) {
        log.info("博客分类批量删除");
        blogTypesService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 更改博客分类信息
     * @param blogTypesDTO
     * @return
     */
    @PutMapping
    @ApiOperation("编辑博客分类信息")
    public Result update(@RequestBody BlogTypesDTO blogTypesDTO) {
        blogTypesService.update(blogTypesDTO);
        return Result.success();
    }
    /**
     * 根据id查询分类信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据ID查询博客分类信息")
    public Result<BlogTypesVO> get(@PathVariable Long id) {
        BlogTypesVO blogTypesVO = blogTypesService.getById(id);
        return Result.success(blogTypesVO);
    }
}
