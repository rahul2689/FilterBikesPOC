package com.example.meritnation.filterbikespoc.modules.filter.controller;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meritnation.filterbikespoc.R;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.NewBikes;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by root on 31/10/15.
 */
public class FilteredBikeListAdapter extends BaseAdapter{
    private final Activity mActivity;
    private final ArrayList<NewBikes> mFilteredBikeList;

    public FilteredBikeListAdapter(Activity activity, ArrayList<NewBikes> filteredBikeList) {
        mActivity = activity;
        mFilteredBikeList = filteredBikeList;
    }

    @Override
    public int getCount() {
        return mFilteredBikeList.size();
    }

    @Override
    public NewBikes getItem(int position) {
        if(mFilteredBikeList.size() == 0){
            return new NewBikes();
        }else{
            return mFilteredBikeList.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if(view == null && view.getTag() == null){
            view = mActivity.getLayoutInflater().inflate(R.layout.adapter_bikes_list, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Picasso.with((Context)mActivity).load(mFilteredBikeList.get(position).getImageUrl()).into(viewHolder.mBikeIv);
        viewHolder.mBikeNameTv.setText(mFilteredBikeList.get(position).getBikeName());
        viewHolder.mBikeCapacityTv.setText(mFilteredBikeList.get(position).getEngineCapacity());
        viewHolder.mBikeMileageTv.setText(mFilteredBikeList.get(position).getMileage());
        viewHolder.mBikePriceTv.setText(mFilteredBikeList.get(position).getPrice());
        return view;
    }

    class ViewHolder{
        private ImageView mBikeIv;
        private TextView mBikeNameTv;
        private TextView mBikeCapacityTv;
        private TextView mBikeMileageTv;
        private TextView mBikePriceTv;

        public ViewHolder(View view){
            mBikeIv = (ImageView) view.findViewById(R.id.iv_bikes_adapter_img);
            mBikeNameTv = (TextView) view.findViewById(R.id.tv_adapter_bikes_bike_name);
            mBikeCapacityTv = (TextView) view.findViewById(R.id.tv_adapter_bikes_bike_capacity);
            mBikeMileageTv = (TextView) view.findViewById(R.id.tv_adapter_bikes_bike_mileage);
            mBikePriceTv = (TextView) view.findViewById(R.id.tv_adapter_bikes_bike_price);
        }
    }
}
