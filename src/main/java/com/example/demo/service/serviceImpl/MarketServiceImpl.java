package com.example.demo.service.serviceImpl;

import com.example.demo.domain.Constants;
import com.example.demo.domain.RestResponse;
import com.example.demo.generator.pojo.CatalogProduct;
import com.example.demo.generator.pojo.ProductPrice;
import com.example.demo.generator.pojo.Useroperationsave;
import com.example.demo.mapper.read.CatalogProductMapper;
import com.example.demo.mapper.read.CatalogProductprivatelabelpricesaleMapper;
import com.example.demo.mapper.read.CatalogProductresellertypepriceMapper;
import com.example.demo.mapper.write.UseroperationsaveMapper;
import com.example.demo.service.MarketService;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MarketServiceImpl implements MarketService {
    private Logger log = LoggerFactory.getLogger(MarketServiceImpl.class);
    @Autowired
    private CatalogProductMapper productMapper;
    @Autowired
    private CatalogProductprivatelabelpricesaleMapper saleMapper;

    @Autowired
    private CatalogProductresellertypepriceMapper listMapper;
    @Autowired
    private UseroperationsaveMapper saveMapper;

    @Override
    public RestResponse getProductInfo(String name) {
        try {
            name = name.trim();
            if (Strings.isNullOrEmpty(name)) {
                return RestResponse.fail(Constants.INPUT_NAME);
            }
            StringBuilder whereSql = new StringBuilder();
            String[] keywords = name.split("\\s+", -1);
            for (int i = 0; i < keywords.length; i++) {
                keywords[i] = keywords[i].trim();
                if (Strings.isNullOrEmpty(keywords[i])) {
                    continue;
                }
                whereSql.append(" AND name like '%" + keywords[i] + "%' ");
            }
            List<CatalogProduct> markets = productMapper.selectByNameWithMultipleKeyword(whereSql.toString());
            return RestResponse.success(markets);
        } catch (Exception e) {
            e.printStackTrace();
            return RestResponse.fail(Constants.DATA_BASE_ERROR);
        }
    }

    public static void main(String[] args) {
        String url = "https://godaddy.com/tlds/club-domain";
        System.out.println(getUrl(url, "fr-BE"));
    }

    private static String getUrl(String url, String market) {
        market = market.replace("_", "-");
        String[] text = market.split("-");
        if (url.contains("www")) {
            if (market.equalsIgnoreCase("en-gb")) {
                url = url.replace("www", "hk");
            } else if (market.equalsIgnoreCase("es-us")) {
                url = url.replace("com/", "com/" + text[0].toLowerCase() + "/");
            } else if (market.equalsIgnoreCase("en-us")) {

            } else {
                url = url.replace("www", text[1]);
            }
        } else {
            if (market.equalsIgnoreCase("en-us")) {
                url = url.substring(0, 8) + "www." + url.substring(8);
            } else if (market.equalsIgnoreCase("en-gb")) {
                url = url.substring(0, 8) + "uk." + url.substring(8);
            } else if (market.equalsIgnoreCase("es-us")) {
                url = url.substring(0, 8) + "www." + url.substring(8);
                url = url.replace(".com/", ".com/" + text[0] + "/");
            } else if (market.equalsIgnoreCase("en-IL") || market.equalsIgnoreCase("it-CH")
                    || market.equalsIgnoreCase("fr-CH") || market.equalsIgnoreCase("fr-BE")
                    || market.equalsIgnoreCase("fr-CA") || market.equalsIgnoreCase("mr-IN")
                    || market.equalsIgnoreCase("ta-IN") || market.equalsIgnoreCase("hi-IN")
                    || market.equalsIgnoreCase("en-HK") || market.equalsIgnoreCase("zh-SG")) {
                url = url.substring(0, 8) + text[1].toLowerCase() + "." + url.substring(8);
                url = url.replace(".com/", ".com/" + text[0].toLowerCase() + "/");
            } else if (market.equalsIgnoreCase("zh-CN")) {
                url = url.substring(0, 8) + "sg." + url.substring(8);
                url = url.replace(".com/", ".com/" + text[0] + "/");
            } else {
                url = url.substring(0, 8) + market.substring(3).toLowerCase() + "." + url.substring(8);
            }
        }
        return url;
    }

    public String getMoney(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        char[] chars = str.toCharArray();
        String money = "";
        for (int i = 0; i < chars.length; i++) {
            if (("0123456789.,").indexOf(chars[i] + "") != -1) {
                money += chars[i];
            }
            if (("/").indexOf(chars[i] + "") != -1) {
                return money;
            }
        }
        return money;
    }

    @Override
    public RestResponse getResult(String url, String markets, String pfId, String listXpath, String saleXpath) {
        List<String> tableHead = new ArrayList<>();
        List<List<String>> returnList = new ArrayList<>();
        String[] urls = url.split(",");
        markets = StringUtils.isBlank(markets) ? "en-us" : markets;
        String[] market = markets.split(",");
        listXpath = StringUtils.isBlank(listXpath) ? Constants.LISTXPATH : listXpath;
        saleXpath = StringUtils.isBlank(saleXpath) ? Constants.SALEXPATH : saleXpath;
        String[] listXpaths = listXpath.split(",");
        String[] saleXpaths = saleXpath.split(",");
        listXpaths = null == listXpaths || listXpaths.length == 0 ? new String[]{Constants.LISTXPATH} : listXpaths;
        saleXpaths = null == saleXpaths || saleXpaths.length == 0 ? new String[]{Constants.SALEXPATH} : saleXpaths;
        String uselistXpath = "";
        String usesaleXpath = "";
        String useUrl = "";
        Map<String, String> mybatisMap = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        tableHead.add(Constants.HEADMARKET);
        tableHead.add(Constants.HEADSQLSALE);
        tableHead.add(Constants.HEADSQLLIST);
        for (int i = 0; i < urls.length; i++) {
            tableHead.add(Constants.HEADPAGESALE + i);
            tableHead.add(Constants.HEADPAGELIST + i);
        }
        data.put("head", tableHead);
        try {
            for (int i = 0; i < market.length; i++) {
                List<String> list = new ArrayList<>();
                mybatisMap.put("pfId", pfId);
                mybatisMap.put("market", market[i]);
                ProductPrice priceFromSql = saleMapper.getPriceFromSql(mybatisMap);
                list.add(market[i]);
                list.add(null == priceFromSql ? Constants.NOPRICE : priceFromSql.getSalePrice());
                list.add(null == priceFromSql ? Constants.NOPRICE : priceFromSql.getListPrice());
                for (int j = 0; j < urls.length; j++) {
                    if (null != saleXpaths) {
                        try {
                            usesaleXpath = saleXpaths[j];
                        } catch (Exception e) {
                            usesaleXpath = "";
                        }
                    }
                    if (null != listXpaths) {
                        try {
                            uselistXpath = listXpaths[j];
                        } catch (Exception e) {
                            uselistXpath = "";
                        }
                    }
                    useUrl = getUrl(urls[j], market[i]);
                    ProductPrice pagePrice = getPagePrice(market[i], useUrl, uselistXpath, usesaleXpath);
                    list.add(pagePrice.getSalePrice());
                    list.add(pagePrice.getListPrice());
                }
                returnList.add(list);
            }
            data.put("data", returnList);
            return RestResponse.success(data);
        } catch (Exception e) {
            e.printStackTrace();
            return RestResponse.fail(Constants.STSTEM_ERROR);
        }
    }


    public ProductPrice getPagePrice(String market, String url, String listXpath, String saleXpath) {
        ProductPrice price = new ProductPrice();
        System.setProperty(Constants.DRIVER, Constants.DRIVERPATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        String salePrice = null;
        String listPrice = null;
        try {
            driver.get(url);
            salePrice = driver.findElement(By.xpath(saleXpath)).getText();
            listPrice = driver.findElement(By.xpath(listXpath)).getText();
        } catch (Exception e) {
            listPrice = StringUtils.isBlank(listPrice) ? driver.findElement(By.tagName(listXpath)).getText() : listXpath;
            log.error("获取不到" + market + "的PagePrice");
        } finally {
            price.setListPrice(StringUtils.isBlank(listPrice) ? Constants.NOPRICE : listPrice);
            price.setSalePrice(StringUtils.isBlank(salePrice) ? Constants.NOPRICE : salePrice);
            price.setMarket(market);
            log.info(price.toString());
            driver.quit();
            return price;
        }
    }

    @Override
    public RestResponse saveInput(String url, String pfId, String listXpath, String saleXpath, String productName) {
        try {
            Useroperationsave useroperationsave = saveMapper.selectByName(productName);
            if (null != useroperationsave) {
                saveMapper.deleteByPrimaryKey(useroperationsave.getId());
            }
            Useroperationsave save = new Useroperationsave();
            save.setUrl(url);
            save.setPfid(pfId);
            save.setListxpath(listXpath);
            save.setSalexpath(saleXpath);
            save.setProductname(productName);
            saveMapper.insert(save);
            return RestResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            return RestResponse.fail(Constants.DATA_BASE_ERROR);
        }
    }

    @Override
    public RestResponse getLable() {
        try {
            List<Useroperationsave> list = saveMapper.selectLable();
            return RestResponse.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return RestResponse.fail(Constants.DATA_BASE_ERROR);
        }
    }

    @Override
    public RestResponse getEdit(Integer id) {
        try {
            Useroperationsave save = saveMapper.selectByPrimaryKey(id);
            return RestResponse.success(save);
        } catch (Exception e) {
            e.printStackTrace();
            return RestResponse.fail(Constants.DATA_BASE_ERROR);
        }
    }
}
