package com.changgou.goods.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author huzhpm
 * @Date 2021/1/16 19:59
 * @Version 1.0
 * @Content
 */
@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查询所有品牌
     * @return
     */
    @GetMapping
    public Result<Brand> findAll(){
        // 查询所有品牌
        List<Brand> list = brandService.findAll();
        return new Result<Brand>(true, StatusCode.OK, "查询所有品牌成功", list);
    }

    /**
     * 根据Id查询品牌
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable(value = "id") Integer id){
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK, "根据Id查询品牌成功", brand);
    }

    /**
     * 增加品牌
     * @param brand
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "新增品牌成功");
    }

    /**
     * 修改品牌
     * @param brand
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@RequestBody Brand brand, @PathVariable Integer id){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "修改品牌成功");
    }

    /**
     * 根据Id删除品牌
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        brandService.delete(id);
        return new Result(true, StatusCode.OK, "根据Id删除品牌成功");
    }

    /**
     * 条件查询
     * @param brand
     * @return
     */
    @PostMapping("/search")
    public Result<Brand> findList(@RequestBody Brand brand){
        List<Brand> list = brandService.findList(brand);
        return new Result<Brand>(true, StatusCode.OK, "条件查询成功", list);
    }

    /**
     * 分页查询
     * @return
     */
    @GetMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable Integer page, @PathVariable Integer size){
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<>(true, StatusCode.OK,"分页查询成功", pageInfo);
    }

    /**
     * 分页查询
     * @return
     */
    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand, @PathVariable Integer page, @PathVariable Integer size){
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        int i = 1/0;
        return new Result<>(true, StatusCode.OK,"条件分页查询成功", pageInfo);
    }
}
