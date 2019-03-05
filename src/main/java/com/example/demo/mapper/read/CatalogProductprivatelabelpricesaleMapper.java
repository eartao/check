package com.example.demo.mapper.read;

import com.example.demo.generator.pojo.CatalogProductprivatelabelpricesale;
import com.example.demo.generator.pojo.ProductPrice;

import java.util.Map;

public interface CatalogProductprivatelabelpricesaleMapper {
    int insert(CatalogProductprivatelabelpricesale record);

    int insertSelective(CatalogProductprivatelabelpricesale record);

    ProductPrice getPriceFromSql(Map<String,String> map);
}