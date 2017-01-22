package com.example.ximeiliu.contactlist.model;

/**
 * Created by ximeiliu on 22/01/17.
 */

public class ItemInfo {
    private String item;
    private String itemValue;

    public ItemInfo(String item, String itemValue) {
        this.item = item;
        this.itemValue = itemValue;
    }

    public String getItem() {
        return item;
    }

    public String getItemValue() {
        return itemValue;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "item='" + item + '\'' +
                ", itemValue='" + itemValue + '\'' +
                '}';
    }
}
