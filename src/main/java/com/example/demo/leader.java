package com.example.demo;

public class leader {
    public String code;
    public String name;
    public String cod_department;
    public String hiring_date;

    public leader(String code, String name, String cod_department, String hiring_date) {
        this.code = code;
        this.name = name;
        this.cod_department = cod_department;
        this.hiring_date = hiring_date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod_department() {
        return cod_department;
    }

    public void setCod_department(String cod_department) {
        this.cod_department = cod_department;
    }

    public String getHiring_date() {
        return hiring_date;
    }

    public void setHiring_date(String hiring_date) {
        this.hiring_date = hiring_date;
    }

}
