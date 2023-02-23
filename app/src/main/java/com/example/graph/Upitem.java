package com.example.graph;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by taewoo on 2019-11-16.
 */

public class Upitem {

    @SerializedName("ymd")
    @Expose
    public
    String ymd;

    @SerializedName("price")
    @Expose
    public
    String price;


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Upitem(String price, String ymd) {
        this.price = price;
        this.ymd = ymd;
    }

    public String getYmd() {
        return ymd;
    }

    public void setYmd(String ymd) {
        this.ymd = ymd;
    }


}