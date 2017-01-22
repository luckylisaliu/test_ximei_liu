package com.example.ximeiliu.contactlist.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ximeiliu on 20/01/17.
 */

public class Contact implements Comparable<Contact> {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("username")
    private String userName;
    @SerializedName("email")
    private String email;
    @SerializedName("address")
    private Address address;
    @SerializedName("phone")
    private String phone;
    @SerializedName("website")
    private String website;
    @SerializedName("company")
    private Company company;

    public Contact(int id, String name, String userName, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }


    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }


    /*
     *implement ascending sort based to contact name
     */
    @Override
    public int compareTo(@NonNull Contact o) {
        return this.getName().compareTo(o.getName());
    }


}


