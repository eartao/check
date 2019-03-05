package com.example.demo.generator.pojo;

import java.util.Objects;

public class Result {
    private String market;
    private String pageSalePrice;
    private String sqlSalePrice;
    private String pageListPrice;
    private String sqlListPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(market, result.market) &&
                Objects.equals(pageSalePrice, result.pageSalePrice) &&
                Objects.equals(sqlSalePrice, result.sqlSalePrice) &&
                Objects.equals(pageListPrice, result.pageListPrice) &&
                Objects.equals(sqlListPrice, result.sqlListPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(market, pageSalePrice, sqlSalePrice, pageListPrice, sqlListPrice);
    }

    @Override
    public String toString() {
        return "Result{" +
                "market='" + market + '\'' +
                ", pageSalePrice='" + pageSalePrice + '\'' +
                ", sqlSalePrice='" + sqlSalePrice + '\'' +
                ", pageListPrice='" + pageListPrice + '\'' +
                ", sqlListPrice='" + sqlListPrice + '\'' +
                '}';
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getPageSalePrice() {
        return pageSalePrice;
    }

    public void setPageSalePrice(String pageSalePrice) {
        this.pageSalePrice = pageSalePrice;
    }

    public String getSqlSalePrice() {
        return sqlSalePrice;
    }

    public void setSqlSalePrice(String sqlSalePrice) {
        this.sqlSalePrice = sqlSalePrice;
    }

    public String getPageListPrice() {
        return pageListPrice;
    }

    public void setPageListPrice(String pageListPrice) {
        this.pageListPrice = pageListPrice;
    }

    public String getSqlListPrice() {
        return sqlListPrice;
    }

    public void setSqlListPrice(String sqlListPrice) {
        this.sqlListPrice = sqlListPrice;
    }

    public Result() {

    }
}
