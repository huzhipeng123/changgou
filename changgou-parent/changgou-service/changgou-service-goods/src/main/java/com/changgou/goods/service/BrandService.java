package com.changgou.goods.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author huzhpm
 * @Date 2021/1/16 19:58
 * @Version 1.0
 * @Content
 */
public interface BrandService {

    /**
     * 查询所有
     * @return
     */
    public List<Brand> findAll();

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Brand findById(Integer id);

    /**
     * 增加品牌
     */
    public void add(Brand brand);

    /**
     * 修改品牌
     * @param brand
     */
    public void update(Brand brand);

    /**
     * 根据Id删除品牌
     * @param id
     */
    public void delete(Integer id);

    /**
     * 根据品牌信息多条件搜索
     */
    public List<Brand> findList(Brand brand);

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public PageInfo<Brand> findPage(Integer page, Integer size);

    /**
     * 条件分页搜索
     * @param brand
     * @param page
     * @param size
     * @return
     */
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size);

}
