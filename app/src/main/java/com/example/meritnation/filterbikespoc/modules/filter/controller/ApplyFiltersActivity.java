package com.example.meritnation.filterbikespoc.modules.filter.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.meritnation.filterbikespoc.R;
import com.example.meritnation.filterbikespoc.application.controller.BaseActivity;
import com.example.meritnation.filterbikespoc.application.model.data.AppData;
import com.example.meritnation.filterbikespoc.application.model.listener.OnAPIResponseListener;
import com.example.meritnation.filterbikespoc.modules.constants.RequestTagConstant;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.DataToApplyFilters;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.FilterTypesData;
import com.example.meritnation.filterbikespoc.modules.filter.model.manager.FilterManager;
import com.example.meritnation.filterbikespoc.modules.filter.model.parser.FilterParser;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 1/11/15.
 */
public class ApplyFiltersActivity extends BaseActivity implements OnAPIResponseListener{

    private static final int BRAND = 0;
    private static final int PRICE_RANGE = 1;
    private static final int CAPACITY = 2;
    private static final int STYLE = 3;
    private static final int START_OPTION = 4;
    private static final int SORT_TAG = 5;
    private ListView mTypesOfFilterLv;
    private List<String> mFilterTypes;
    private ArrayAdapter<String> mFilterTypesAdapter;
    private FilterTypeDetailAdapter mFilterTypeDetailsAdapter;
    private ListView mFilterDetailLv;
    private Dialog mDialog;
    private FilterTypesData mFilterTypesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_screen);
        mTypesOfFilterLv = (ListView) findViewById(R.id.lv_filter_screen_filter_types);
        mFilterDetailLv = (ListView) findViewById(R.id.lv_filter_screen_filter_type_items);
        initializeFilterTypes();
        mFilterTypesAdapter = new ArrayAdapter<>(ApplyFiltersActivity.this, android.R.layout.simple_list_item_1, mFilterTypes);
        mTypesOfFilterLv.setAdapter(mFilterTypesAdapter);
        mTypesOfFilterLv.setOnItemClickListener(filterTypesItemListener);
        mFilterTypeDetailsAdapter = new FilterTypeDetailAdapter(this);
        mFilterDetailLv.setAdapter(mFilterTypeDetailsAdapter);
        fetchDataFromNetwork();
    }

    private void fetchDataFromNetwork() {
        showProgressBar();
        FilterManager filterManager = new FilterManager(new FilterParser(), this);
        filterManager.fetchFilterDataFromNetwork(RequestTagConstant.FETCH_FILTER_DATA_TAG);
    }

    private void showProgressBar() {
        mDialog = new Dialog(ApplyFiltersActivity.this, R.style.CustomDialogTheme);
        mDialog.setContentView(R.layout.dialog_loader);
        mDialog.setCancelable(false);
        if (null != ApplyFiltersActivity.this && !ApplyFiltersActivity.this.isFinishing()) {
            mDialog.show();
        }
    }

    private void hideProgressBar() {
        try {
            if (mDialog != null && mDialog.isShowing()) {
                mDialog.dismiss();
                mDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private AdapterView.OnItemClickListener filterTypesItemListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case BRAND:
                    mFilterTypeDetailsAdapter.setFilterDataList(mFilterTypesData.getBrand());
                    break;
                case PRICE_RANGE:
                    mFilterTypeDetailsAdapter.setFilterDataList(mFilterTypesData.getPriceRange());
                    break;
                case CAPACITY:
                    mFilterTypeDetailsAdapter.setFilterDataList(mFilterTypesData.getCapacity());
                    break;
                case STYLE:
                    mFilterTypeDetailsAdapter.setFilterDataList(mFilterTypesData.getBikeStyle());
                    break;
                case START_OPTION:
                    mFilterTypeDetailsAdapter.setFilterDataList(mFilterTypesData.getStartOption());
                    break;
                case SORT_TAG:
                    mFilterTypeDetailsAdapter.setFilterDataList(mFilterTypesData.getSortTag());
                    break;
                default:
                    break;
            }
        }
    };

    private void initializeFilterTypes() {
        mFilterTypes = new ArrayList<>();
        mFilterTypes.add("Brand");
        mFilterTypes.add("Price Range");
        mFilterTypes.add("Capacity");
        mFilterTypes.add("Style");
        mFilterTypes.add("Start Option");
        mFilterTypes.add("Sort Tag");
    }

    @Override
    public void onAPIResponse(AppData appData, String requestTag) {
        hideProgressBar();
        if(appData != null){
            DataToApplyFilters dataToApplyFilters = (DataToApplyFilters) appData;
            mFilterTypesData = dataToApplyFilters.getFilterTypesData();
            mTypesOfFilterLv.setSelection(0);
            onItemSelectedListener.onItemSelected(mTypesOfFilterLv, mTypesOfFilterLv.getChildAt(0), mTypesOfFilterLv.getSelectedItemPosition(), mTypesOfFilterLv.getSelectedItemId());
        }
    }

    private AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mFilterTypeDetailsAdapter.setFilterDataList(mFilterTypesData.getBrand());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    public void onInternalServerError(String message, String requestTag) {

    }

    @Override
    public void onAPIParsingException(JSONException e, String requestTag) {

    }
}
