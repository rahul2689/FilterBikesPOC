package com.example.meritnation.filterbikespoc.modules.filter.model.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 1/11/15.
 */
public class FilterDataReq implements Serializable {

    private FilterObj mFilterObj;

    public FilterDataReq(){
        mFilterObj = new FilterObj();
    }

    public FilterObj getFilterObj() {
        return mFilterObj;
    }

    public void setFilterObj(FilterObj filterObj) {
        this.mFilterObj = filterObj;
    }
}
