package com.example.meritnation.filterbikespoc.modules.filter.model.data;

import com.example.meritnation.filterbikespoc.application.model.data.AppData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by root on 31/10/15.
 */
public class BikesData extends AppData implements Serializable {

    @SerializedName("count")
    private int mBikesCount;

    @SerializedName("newBikes")
    private ArrayList<NewBikes> mNewBikeList;

    public BikesData(){

    }

    public int getBikesCount() {
        return mBikesCount;
    }

    public void setBikesCount(int bikesCount) {
        this.mBikesCount = bikesCount;
    }

    public ArrayList<NewBikes> getNewBikeList() {
        return mNewBikeList;
    }

    public void setNewBikeList(ArrayList<NewBikes> newBikeList) {
        this.mNewBikeList = newBikeList;
    }
}
