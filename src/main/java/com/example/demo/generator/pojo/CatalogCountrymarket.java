package com.example.demo.generator.pojo;

public class CatalogCountrymarket {
    private String countrycode;

    private String catalogMarketid;

    private String createdate;

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode == null ? null : countrycode.trim();
    }

    public String getCatalogMarketid() {
        return catalogMarketid;
    }

    public void setCatalogMarketid(String catalogMarketid) {
        this.catalogMarketid = catalogMarketid == null ? null : catalogMarketid.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }
}