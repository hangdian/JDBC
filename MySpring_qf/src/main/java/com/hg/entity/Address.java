package com.hg.entity;

public class Address {
    private Integer id;
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("设置ID");
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address() {
        System.out.println("构造对象");
    }
    public void init_hg(){
        System.out.println("Address 初始化");
    }
    public void destroy_hg(){
        System.out.println("销毁");
    }
}
