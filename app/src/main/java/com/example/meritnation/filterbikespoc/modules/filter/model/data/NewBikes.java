package com.example.meritnation.filterbikespoc.modules.filter.model.data;

import com.example.meritnation.filterbikespoc.application.model.data.AppData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 31/10/15.
 */
public class NewBikes extends AppData implements Serializable{

    @SerializedName("fuelType")
    private String mFuelType;

    @SerializedName("engineCapacity")
    private String mEngineCapacity;

    @SerializedName("mileage")
    private String mMileage;

    @SerializedName("rating")
    private int mRating;

    @SerializedName("brand_name")
    private String mBrandName;

    @SerializedName("display_name")
    private String mBikeName;

    @SerializedName("variant_name")
    private String mVariantName;

    @SerializedName("image")
    private String mImageUrl;

    @SerializedName("price")
    private int mPrice;

    public NewBikes(){

    }

    public String getFuelType() {
        return mFuelType;
    }

    public String getEngineCapacity() {
        return mEngineCapacity;
    }

    public String getMileage() {
        return mMileage;
    }

    public int getRating() {
        return mRating;
    }

    public String getBrandName() {
        return mBrandName;
    }

    public String getBikeName() {
        return mBikeName;
    }

    public String getVariantName() {
        return mVariantName;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setFuelType(String fuelType) {
        this.mFuelType = fuelType;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.mEngineCapacity = engineCapacity;
    }

    public void setMileage(String mileage) {
        this.mMileage = mileage;
    }

    public void setmRating(int rating) {
        this.mRating = rating;
    }

    public void setBikeName(String bikeName) {
        this.mBikeName = bikeName;
    }

    public void setmBrandName(String brandName) {
        this.mBrandName = brandName;
    }

    public void setmVariantName(String mVariantName) {
        this.mVariantName = mVariantName;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }
}

