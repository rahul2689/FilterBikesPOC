package com.example.meritnation.filterbikespoc.modules.filter.model.data;

import com.example.meritnation.filterbikespoc.application.model.data.AppData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 1/11/15.
 */
public class FilterData extends AppData implements Serializable{

    @SerializedName("data")
    private FilterObj mFilterObj;

    public FilterData(){
        mFilterObj = new FilterObj();
    }

    public FilterObj getFilterObj() {
        return mFilterObj;
    }

    public void setFilterObj(FilterObj filterObj) {
        this.mFilterObj = filterObj;
    }
}
