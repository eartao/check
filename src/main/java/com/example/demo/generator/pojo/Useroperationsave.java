package com.example.demo.generator.pojo;

public class Useroperationsave {
    private Integer id;

    private String pfid;

    private String productname;

    private String url;

    private String salexpath;

    private String listxpath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPfid() {
        return pfid;
    }

    public void setPfid(String pfid) {
        this.pfid = pfid == null ? null : pfid.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getSalexpath() {
        return salexpath;
    }

    public void setSalexpath(String salexpath) {
        this.salexpath = salexpath == null ? null : salexpath.trim();
    }

    public String getListxpath() {
        return listxpath;
    }

    public void setListxpath(String listxpath) {
        this.listxpath = listxpath == null ? null : listxpath.trim();
    }
}