package com.example.demo.controller;

import com.example.demo.domain.Constants;
import com.example.demo.domain.RestResponse;
import com.example.demo.service.MarketService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class MainController {
    @Autowired
    private MarketService service;
    @RequestMapping(Constants.URL_GETPRODUCTINFO)
    @ResponseBody
    public RestResponse getMarket(@RequestParam(value = "name",required = false)String name){
        if(StringUtils.isBlank(name)){
            return RestResponse.fail(Constants.INPUT_NAME);
        }
        if(name.length()<=2){
            return RestResponse.fail(Constants.LETTER);
        }
        RestResponse response = service.getProductInfo(name);
        return response;
    }

    @RequestMapping(Constants.URL_GETRESULT)
    public RestResponse getResult(String url,String markets,String  pfId,String listXpath,String saleXpath){
        if(StringUtils.isBlank(url)){
            return RestResponse.fail(Constants.URL);
        }
        if(!url.contains("http")){
            return RestResponse.fail(Constants.CORRECT_URL);
        }
        if(StringUtils.isBlank(pfId)){
            return RestResponse.fail(Constants.PFID);
        }
        RestResponse response = service.getResult(url,markets,pfId,listXpath,saleXpath);
        return response;
    }

    @RequestMapping(Constants.URL_SAVEINPUT)
    public RestResponse saveInput(String url,String  pfId,String listXpath,String saleXpath,String productName ){
        if(StringUtils.isBlank(url)){
            return RestResponse.fail(Constants.URL);
        }
        if(StringUtils.isBlank(productName)){
            return RestResponse.fail(Constants.INPUT_NAME);
        }
        RestResponse response = service.saveInput(url,pfId,listXpath,saleXpath,productName);
        return response;
    }

    @RequestMapping(Constants.URL_GETLABLE)
    public RestResponse getLable(){
        RestResponse response = service.getLable();
        return response;
    }

    @RequestMapping(Constants.URL_GETEDIT)
    public RestResponse getEdit(Integer id){
        RestResponse response = service.getEdit(id);
        return response;
    }
}
