package com.example.demo.generator.pojo;

public class CatalogCountrysite {
    private String catalogCountrysite;

    private String catalogPricegroupid;

    private String countrysitedescription;

    private String isactive;

    private String internalonly;

    private String defaultmarketid;

    private String defaultcurrencytype;

    private String createdate;

    private String modifydate;

    private String displaytaxesandfees;

    private String taxcountry;

    public String getCatalogCountrysite() {
        return catalogCountrysite;
    }

    public void setCatalogCountrysite(String catalogCountrysite) {
        this.catalogCountrysite = catalogCountrysite == null ? null : catalogCountrysite.trim();
    }

    public String getCatalogPricegroupid() {
        return catalogPricegroupid;
    }

    public void setCatalogPricegroupid(String catalogPricegroupid) {
        this.catalogPricegroupid = catalogPricegroupid == null ? null : catalogPricegroupid.trim();
    }

    public String getCountrysitedescription() {
        return countrysitedescription;
    }

    public void setCountrysitedescription(String countrysitedescription) {
        this.countrysitedescription = countrysitedescription == null ? null : countrysitedescription.trim();
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive == null ? null : isactive.trim();
    }

    public String getInternalonly() {
        return internalonly;
    }

    public void setInternalonly(String internalonly) {
        this.internalonly = internalonly == null ? null : internalonly.trim();
    }

    public String getDefaultmarketid() {
        return defaultmarketid;
    }

    public void setDefaultmarketid(String defaultmarketid) {
        this.defaultmarketid = defaultmarketid == null ? null : defaultmarketid.trim();
    }

    public String getDefaultcurrencytype() {
        return defaultcurrencytype;
    }

    public void setDefaultcurrencytype(String defaultcurrencytype) {
        this.defaultcurrencytype = defaultcurrencytype == null ? null : defaultcurrencytype.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getModifydate() {
        return modifydate;
    }

    public void setModifydate(String modifydate) {
        this.modifydate = modifydate == null ? null : modifydate.trim();
    }

    public String getDisplaytaxesandfees() {
        return displaytaxesandfees;
    }

    public void setDisplaytaxesandfees(String displaytaxesandfees) {
        this.displaytaxesandfees = displaytaxesandfees == null ? null : displaytaxesandfees.trim();
    }

    public String getTaxcountry() {
        return taxcountry;
    }

    public void setTaxcountry(String taxcountry) {
        this.taxcountry = taxcountry == null ? null : taxcountry.trim();
    }
}