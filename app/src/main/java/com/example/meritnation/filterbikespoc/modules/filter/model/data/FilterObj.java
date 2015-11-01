package com.example.meritnation.filterbikespoc.modules.filter.model.data;

import com.example.meritnation.filterbikespoc.application.model.data.AppData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by root on 1/11/15.
 */
public class FilterObj extends AppData implements Serializable{

    private ArrayList<String> mBrand;

    private ArrayList<String> mPriceRange;

    private ArrayList<String> mFuelType;

    private ArrayList<String> mCity;

    private ArrayList<String> mBikeStyle;

    private ArrayList<String> mStartOption;

    private ArrayList<String> mCapacity;


    public FilterObj(){
        mBrand = new ArrayList<>();
        mPriceRange = new ArrayList<>();
        mCapacity = new ArrayList<>();
        mBikeStyle = new ArrayList<>();
        mStartOption = new ArrayList<>();
        mFuelType = new ArrayList<>();
        mCity = new ArrayList<>();
    }

    public ArrayList<String> getBrand() {
        return mBrand;
    }

    public void setBrand(ArrayList<String> mBrand) {
        this.mBrand = mBrand;
    }

    public ArrayList<String> getPriceRange() {
        return mPriceRange;
    }

    public void setPriceRange(ArrayList<String> mPriceRange) {
        this.mPriceRange = mPriceRange;
    }

    public ArrayList<String> getCapacity() {
        return mCapacity;
    }

    public void setCapacity(ArrayList<String> mCapacity) {
        this.mCapacity = mCapacity;
    }

    public ArrayList<String> getStartOption() {
        return mStartOption;
    }

    public void setStartOption(ArrayList<String> mStartOption) {
        this.mStartOption = mStartOption;
    }

    public ArrayList<String> getBikeStyle() {
        return mBikeStyle;
    }

    public void setBikeStyle(ArrayList<String> mBikeStyle) {
        this.mBikeStyle = mBikeStyle;
    }

    public ArrayList<String> getmFuelType() {
        return mFuelType;
    }

    public void setmFuelType(ArrayList<String> mFuelType) {
        this.mFuelType = mFuelType;
    }

    public ArrayList<String> getmCity() {
        return mCity;
    }

    public void setmCity(ArrayList<String> mCity) {
        this.mCity = mCity;
    }
}
