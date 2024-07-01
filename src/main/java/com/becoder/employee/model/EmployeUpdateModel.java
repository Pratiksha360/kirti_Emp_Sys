package com.becoder.employee.model;

public class EmployeUpdateModel {

    private String address;
    private String gender;
    private int id;



    public EmployeUpdateModel(){

    }

    public EmployeUpdateModel(String address, String gender,int id) {
        this.address = address;
        this.gender = gender;
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
