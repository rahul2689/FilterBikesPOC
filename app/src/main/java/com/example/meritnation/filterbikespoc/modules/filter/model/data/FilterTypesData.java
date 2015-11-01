package com.example.meritnation.filterbikespoc.modules.filter.model.data;

import com.example.meritnation.filterbikespoc.application.model.data.AppData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by root on 1/11/15.
 */
public class FilterTypesData extends AppData implements Serializable {

    @SerializedName("brand")
    private ArrayList<Name> mBrand;

    @SerializedName("price_range")
    private ArrayList<Name> mPriceRange;

    @SerializedName("cc")
    private ArrayList<Name> mCapacity;

    @SerializedName("style")
    private ArrayList<Name> mBikeStyle;

    @SerializedName("start_option")
    private ArrayList<Name> mStartOption;

    @SerializedName("sort_tag")
    private ArrayList<Name> mSortTag;

    public FilterTypesData() {
        mBrand = new ArrayList<>();
        mPriceRange = new ArrayList<>();
        mCapacity = new ArrayList<>();
        mBikeStyle = new ArrayList<>();
        mStartOption = new ArrayList<>();
        mSortTag = new ArrayList<>();
    }

    public ArrayList<Name> getBrand() {
        return mBrand;
    }

    public void getBrand(ArrayList<Name> mBrand) {
        this.mBrand = mBrand;
    }

    public ArrayList<Name> getPriceRange() {
        return mPriceRange;
    }

    public void getPriceRange(ArrayList<Name> mPriceRange) {
        this.mPriceRange = mPriceRange;
    }

    public ArrayList<Name> getCapacity() {
        return mCapacity;
    }

    public void getCapacity(ArrayList<Name> mCapacity) {
        this.mCapacity = mCapacity;
    }

    public ArrayList<Name> getBikeStyle() {
        return mBikeStyle;
    }

    public void getBikeStyle(ArrayList<Name> mBikeStyle) {
        this.mBikeStyle = mBikeStyle;
    }

    public ArrayList<Name> getStartOption() {
        return mStartOption;
    }

    public void getStartOption(ArrayList<Name> mStartOption) {
        this.mStartOption = mStartOption;
    }

    public ArrayList<Name> getSortTag() {
        return mSortTag;
    }

    public void getSortTag(ArrayList<Name> mSortTag) {
        this.mSortTag = mSortTag;
    }
}
