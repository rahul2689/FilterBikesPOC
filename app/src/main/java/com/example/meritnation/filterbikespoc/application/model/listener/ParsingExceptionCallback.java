package com.example.meritnation.filterbikespoc.application.model.listener;

import org.json.JSONException;

public interface ParsingExceptionCallback {
        void onApiParsingException(JSONException e);
    }