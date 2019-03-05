package com.example.demo.mapper.read;

import com.example.demo.generator.pojo.CatalogProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatalogProductMapper {
    int insert(CatalogProduct record);

    int insertSelective(CatalogProduct record);

    List<CatalogProduct> selectByName(String name);

    List<CatalogProduct> selectByNameWithMultipleKeyword(@Param(value = "whereSql") String whereSql);
}