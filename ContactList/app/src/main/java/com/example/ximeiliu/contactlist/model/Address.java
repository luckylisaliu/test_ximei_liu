package com.example.ximeiliu.contactlist.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ximeiliu on 23/01/17.
 */

public class Address {
        @SerializedName("street")
        private String street;
        @SerializedName("suite")
        private String suite;
        @SerializedName("city")
        private String city;
        @SerializedName("zipcode")
        private String zipcode;
        @SerializedName("geo")
        private Geo geo;



        Address(String street, String suite, String city, String zipcode, Geo geo) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.geo = geo;
        }

        String getStreet() {
            return street;
        }

        String getSuite() {
            return suite;
        }

        String getCity() {
            return city;
        }

        String getZipcode() {
            return zipcode;
        }

        public String getCompleteAddress() {
            return this.getSuite() + "," +
                    this.getStreet() + "," + "\n" +
                    this.getCity() + "," +
                    this.getZipcode();
        }
}
