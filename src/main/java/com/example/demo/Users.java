package com.example.demo;

public class Users {
    public String code;
    public String name;
    public String code_leader;
    public String responsibility;

    public Users(String code, String name, String code_leader, String responsibility) {
        this.code = code;
        this.name = name;
        this.code_leader = code_leader;
        this.responsibility = responsibility;
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

    public String getCode_leader() {
        return code_leader;
    }

    public void setCode_leader(String code_leader) {
        this.code_leader = code_leader;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

}
