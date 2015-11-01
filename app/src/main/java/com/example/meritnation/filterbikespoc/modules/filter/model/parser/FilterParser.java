package com.example.meritnation.filterbikespoc.modules.filter.model.parser;

import com.example.meritnation.filterbikespoc.application.model.data.AppData;
import com.example.meritnation.filterbikespoc.application.model.parser.ApiParser;
import com.example.meritnation.filterbikespoc.modules.constants.RequestTagConstant;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.DataToApplyFilters;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.FilteredBikeResponse;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class FilterParser implements ApiParser {
    /**
     * Parse all responses.
     * @param apiResponse
     * @param requestTag
     * @return
     * @throws JSONException
     */
    @Override
    public AppData parseApiResponse(String apiResponse, String requestTag) throws JSONException {
        if(requestTag.equals(RequestTagConstant.FETCH_BIKES_DATA_TAG)) {
            return parseBikeListResponse(apiResponse);
        }else if(requestTag.equals(RequestTagConstant.FETCH_FILTER_DATA_TAG)){
            return parseFilterDataResponse(apiResponse);
        }else {
            return new AppData();
        }
    }

    private DataToApplyFilters parseFilterDataResponse(String apiResponse) throws JSONException {
        DataToApplyFilters dataToApplyFilters = new DataToApplyFilters();
        if(apiResponse !=null){
            JSONObject jsonObject = new JSONObject(apiResponse);
            Gson gson = new Gson();
            if(jsonObject != null){
                dataToApplyFilters = gson.fromJson(jsonObject.toString(), DataToApplyFilters.class);
            }
        }
        return dataToApplyFilters;
    }

    private FilteredBikeResponse parseBikeListResponse(String apiResponse)  throws JSONException {
        FilteredBikeResponse bikeResponse = new FilteredBikeResponse();
        if(apiResponse !=null){
            JSONObject jsonObject = new JSONObject(apiResponse);
            Gson gson = new Gson();
            if(jsonObject != null){
                        bikeResponse = gson.fromJson(jsonObject.toString(), FilteredBikeResponse.class);
                    }
            }
        return bikeResponse;
    }
}
