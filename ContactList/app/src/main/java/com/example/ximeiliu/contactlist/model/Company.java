package com.example.ximeiliu.contactlist.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ximeiliu on 23/01/17.
 */

public class Company {

    @SerializedName("name")
    private String name;
    @SerializedName("catchPhrase")
    private String catchPhrase;
    @SerializedName("bs")
    private String bs;

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getCatchPhrase() {
        return catchPhrase;
    }

    private String getBs() {
        return bs;
    }

    public String getCompanyName() {
        return this.getName() + "\n" +
                this.getCatchPhrase() + "\n" +
                this.getBs();
    }
}
