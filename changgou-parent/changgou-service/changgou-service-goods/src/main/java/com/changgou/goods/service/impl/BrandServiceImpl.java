package com.changgou.goods.service.impl;

import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author huzhpm
 * @Date 2021/1/16 19:58
 * @Version 1.0
 * @Content
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll(){
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        /**
         *
         * 方法中但凡带有Selective，会忽略空值
         */
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    public Example createExample(Brand brand){
        // 自定义条件搜索对象 Example
        Example example = null;
        if(brand != null){
            example = new Example(Brand.class);
            Example.Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name", "%" + brand.getName() + "%");
            }
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter", brand.getLetter());
            }
        }
        return example;
    }

    @Override
    public List<Brand> findList(Brand brand) {
        Example example = createExample(brand);
        if(example != null){
            return brandMapper.selectByExample(example);
        }
        return null;
    }

    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);

        // 查询集合
        List<Brand> brands = brandMapper.selectAll();
        // 封装PageInfo
        return new PageInfo<>(brands);
    }

    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        Example example = createExample(brand);
        if(example != null){
            List<Brand> brands = brandMapper.selectByExample(example);
            return new PageInfo<Brand>(brands);
        }
        return null;
    }
}
