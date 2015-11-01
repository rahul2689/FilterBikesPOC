package com.example.meritnation.filterbikespoc.application.model.parser;


import com.example.meritnation.filterbikespoc.application.model.data.AppData;

import org.json.JSONException;

public interface ApiParser {
    /**
     * This is common rule for parsing.
     * @param apiResponse
     * @param requestTag
     * @return
     * @throws JSONException
     */
    AppData parseApiResponse(String apiResponse, String requestTag) throws JSONException;
}
