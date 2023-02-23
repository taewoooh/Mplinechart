package com.example.graph;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by taewoo on 2019-11-16.
 */

public class Upitem {


    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    @SerializedName("up")
    @Expose
    public
    int up;





///////////////////////////////////////


    public Upitem( int up) {

        this.up = up;


    }





}