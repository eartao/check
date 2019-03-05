package com.example.demo.domain;

public class PagePrice {
    private Integer id;
    private Double listPrice;
    private Double salePrice;
    private String market;
    private String usd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    @Override
    public String toString() {
        return "PagePrice{" +
                "id=" + id +
                ", listPrice=" + listPrice +
                ", salePrice=" + salePrice +
                ", market='" + market + '\'' +
                ", usd='" + usd + '\'' +
                '}';
    }

}
