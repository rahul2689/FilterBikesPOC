package com.example.meritnation.filterbikespoc.modules.filter.model.data;

import com.example.meritnation.filterbikespoc.application.model.data.AppData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 1/11/15.
 */
public class DataToApplyFilters extends AppData implements Serializable {

    @SerializedName("status")
    private String mStatus;

    @SerializedName("data")
    private FilterTypesData mFilterTypesData;

    public DataToApplyFilters(){
        mFilterTypesData = new FilterTypesData();
    }

    public FilterTypesData getFilterTypesData() {
        return mFilterTypesData;
    }

    public void setFilterTypesData(FilterTypesData mFilterTypesData) {
        this.mFilterTypesData = mFilterTypesData;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

}
