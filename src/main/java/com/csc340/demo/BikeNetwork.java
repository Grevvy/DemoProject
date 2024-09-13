package com.csc340.demo;

public class BikeNetwork {
    public String company;
    public String name;
    public String id;

    public BikeNetwork(String company, String name, String id) {
        this.company = company;
        this.name = name;
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
