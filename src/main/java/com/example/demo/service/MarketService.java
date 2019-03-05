package com.example.demo.service;

import com.example.demo.domain.RestResponse;

import java.util.List;

public interface MarketService {
    RestResponse getProductInfo(String name);

    RestResponse getResult(String url,String markets,String  pfId,String listXpath,String saleXpath);

    RestResponse saveInput(String url, String pfId, String listXpath, String saleXpath, String productName);

    RestResponse getLable();

    RestResponse getEdit(Integer id);
}
