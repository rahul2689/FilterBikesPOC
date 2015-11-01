package com.example.meritnation.filterbikespoc.modules.filter.model.data;

import com.example.meritnation.filterbikespoc.application.model.data.AppData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 1/11/15.
 */
public class Name extends AppData implements Serializable{

    @SerializedName("name")
    private String mName;

    public Name(){
        mName = "";
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }
}
