package com.example.meritnation.filterbikespoc.modules.filter.controller;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.meritnation.filterbikespoc.R;
import com.example.meritnation.filterbikespoc.modules.filter.model.data.Name;

import java.util.ArrayList;

/**
 * Created by root on 1/11/15.
 */
public class FilterTypeDetailAdapter extends BaseAdapter {
    private final Activity mActivity;
    private ArrayList<Name> mFilterDetailList;
    public FilterTypeDetailAdapter(Activity activity) {
        mActivity = activity;
        mFilterDetailList = new ArrayList<>();
    }

    public void setFilterDataList(ArrayList<Name> filterDetailList) {
        mFilterDetailList = filterDetailList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFilterDetailList.size();
    }

    @Override
    public Name getItem(int position) {
        return mFilterDetailList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if (view == null || view.getTag() == null) {
            view = mActivity.getLayoutInflater().inflate(R.layout.adapter_filter_details, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mListItemTv.setText(mFilterDetailList.get(position).getName());
        return view;
    }

    class ViewHolder {
        private TextView mListItemTv;
        private CheckBox mCheckBox;

        public ViewHolder(View view) {
            mListItemTv = (TextView) view.findViewById(R.id.tv_adpater_filter_title);
            mCheckBox = (CheckBox) view.findViewById(R.id.cb_adapter_filter_detail);

        }
    }
}
