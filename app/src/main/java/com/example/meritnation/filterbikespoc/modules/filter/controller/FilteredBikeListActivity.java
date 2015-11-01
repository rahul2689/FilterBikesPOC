package com.example.meritnation.filterbikespoc.modules.filter.controller;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.meritnation.filterbikespoc.R;
import com.example.meritnation.filterbikespoc.application.controller.BaseActivity;
import com.example.meritnation.filterbikespoc.application.model.data.AppData;
import com.example.meritnation.filterbikespoc.application.model.listener.OnAPIResponseListener;
import com.example.meritnation.filterbikespoc.modules.constants.RequestTagConstant;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.BikesData;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.FilterDataReq;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.FilterObj;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.FilteredBikeResponse;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.NewBikes;
import com.example.meritnation.filterbikespoc.modules.filter.model.manager.FilterManager;
import com.example.meritnation.filterbikespoc.modules.filter.model.parser.FilterParser;

import org.json.JSONException;

import java.util.ArrayList;

public class FilteredBikeListActivity extends BaseActivity implements OnAPIResponseListener {

    private Toolbar mToolbar;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private ListView mBikesLv;
    private ArrayList<NewBikes> mFilteredBikeList;
    private FilteredBikeListAdapter mBikesListAdapter;
    private Dialog mDialog;
    private BikesData mBikesData;
    private FilterDataReq mFilterObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bikes_list);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer_home);
        mBikesLv = (ListView) findViewById(R.id.lv_bikes);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //ToDO: need to change with nav drawer toggle button
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawer,mToolbar,R.string.app_name,R.string.app_name);
        mDrawer.setDrawerListener(mActionBarDrawerToggle);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(FilteredBikeListActivity.this, ApplyFiltersActivity.class);
                startActivity(intent);
            }
        });

        /*showProgressBar();
        FilterManager filterManager = new FilterManager(new FilterParser(), this);
        try {
            if(mFilterObject == null){
                filterManager.fetchBikeListFromNetwork(RequestTagConstant.FETCH_BIKES_DATA_TAG, new FilterObj());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }

    private void showProgressBar() {
        mDialog = new Dialog(FilteredBikeListActivity.this, R.style.CustomDialogTheme);
        mDialog.setContentView(R.layout.dialog_loader);
        mDialog.setCancelable(false);
        if (null != FilteredBikeListActivity.this && !FilteredBikeListActivity.this.isFinishing()) {
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bikes_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAPIResponse(AppData appData, String requestTag) {
        hideProgressBar();
        if(appData != null){
            FilteredBikeResponse bikeResponse = (FilteredBikeResponse) appData;
            mBikesData = bikeResponse.getBikesData();
        }
            mBikesListAdapter = new FilteredBikeListAdapter(this, mBikesData.getNewBikeList());
            mBikesLv.setAdapter(mBikesListAdapter);
            mBikesListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onInternalServerError(String message, String requestTag) {

    }

    @Override
    public void onAPIParsingException(JSONException e, String requestTag) {

    }
}
