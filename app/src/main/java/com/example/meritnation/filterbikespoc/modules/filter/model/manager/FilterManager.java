package com.example.meritnation.filterbikespoc.modules.filter.model.manager;


import com.example.meritnation.filterbikespoc.application.model.listener.OnAPIResponseListener;
import com.example.meritnation.filterbikespoc.application.model.manager.Manager;
import com.example.meritnation.filterbikespoc.application.model.parser.ApiParser;
import com.example.meritnation.filterbikespoc.modules.constants.URLConstant;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.FilterDataReq;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.FilterObj;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FilterManager extends Manager {

    public FilterManager(ApiParser apiParser, OnAPIResponseListener onApiResponseListener) {
        super(apiParser, onApiResponseListener);
    }

    public void fetchBikeListFromNetwork(String requestTag, FilterObj filterObj) throws JSONException {
        Map<String,String> requestHeaderMap = new HashMap<>();
        requestHeaderMap.put("X-Public", "testing");
        requestHeaderMap.put("X-Hash", "testing");
        requestHeaderMap.put("Content-Type", "application/json");

        Map<String,String> postParamsMap = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject.put("price", filterObj.getPriceRange());
        jsonObject.put("cc", filterObj.getCapacity());
        jsonObject.put("fuelType", filterObj.getmFuelType());
        jsonObject.put("city", filterObj.getmCity());
        jsonObject.put("style", filterObj.getBikeStyle());
        jsonObject.put("start_option", filterObj.getStartOption());
        jsonObject1.put("filter", jsonObject);
        jsonObject1.put("start", "1");
        jsonObject1.put("end", "20");
        postParamsMap.put("Post Params", jsonObject1.toString());

        postData(URLConstant.FETCH_BIKES_DATA_URL, requestHeaderMap, postParamsMap, requestTag);
    }

    public void fetchFilterDataFromNetwork(String requestTag) {
        Map<String,String> requestHeaderMap = new HashMap<>();
        requestHeaderMap.put("X-Public", "testing");
        requestHeaderMap.put("X-Hash", "testing");
        getData(URLConstant.FETCH_FILTER_DATA_URL, requestHeaderMap, requestTag);
    }
}
