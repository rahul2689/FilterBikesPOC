package com.example.meritnation.filterbikespoc.modules.constants;

/**
 * This constant class is related to RequestTags for sending request through volley lib. the advantage of request Tag is
 * you can cancel any rest api request any time before its completion and by using request tag you can also distinguish api
 * response based on request Tag.
 */
public class RequestTagConstant {
    public static final String FETCH_BIKES_DATA_TAG = "FetchBikeListData";
    public static final String FETCH_FILTER_DATA_TAG = "FetchFilterData";
}
