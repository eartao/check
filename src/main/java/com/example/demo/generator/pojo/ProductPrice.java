package com.example.demo.generator.pojo;

import java.util.Objects;

public class ProductPrice {
    private String market;
    private String listPrice;
    private String salePrice;

    public ProductPrice(String market, String listPrice, String salePrice) {
        this.market = market;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
    }

    public ProductPrice() {
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "market='" + market + '\'' +
                ", listPrice='" + listPrice + '\'' +
                ", salePrice='" + salePrice + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(market.toLowerCase(), that.market.toLowerCase()) &&
                Objects.equals(listPrice, that.listPrice) &&
                Objects.equals(salePrice, that.salePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(market, listPrice, salePrice);
    }
}
