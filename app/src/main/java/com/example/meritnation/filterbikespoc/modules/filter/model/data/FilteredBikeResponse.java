package com.example.meritnation.filterbikespoc.modules.filter.model.data;

import com.example.meritnation.filterbikespoc.application.model.data.AppData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 31/10/15.
 */
public class FilteredBikeResponse extends AppData implements Serializable{

    @SerializedName("status")
    private boolean mStatus;

    @SerializedName("data")
    private BikesData mBikesData;

    public boolean isStatus() {
        return mStatus;
    }

    public void setStatus(boolean status) {
        this.mStatus = status;
    }

    public BikesData getBikesData() {
        return mBikesData;
    }

    public void setBikesData(BikesData bikesData) {
        this.mBikesData = bikesData;
    }
}
