package com.hypercryptic.diabeticdiary.adapters;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hypercryptic.diabeticdiary.R;

/**
 * Created by Sharukh Hasan on 8/14/16.
 * Copyright © 2016 HyperCryptic Solutions, LLC. All rights reserved.
 */
public class LegendAdapter extends ArrayAdapter<LegendItem> {

    public LegendAdapter(Activity activity) {
        super(activity.getApplicationContext(), 0, LegendItem.getList(activity));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.legend_item, parent, false);
        }

        LegendItem sample = getItem(position);

        convertView.findViewById(R.id.color).setBackground(new ColorDrawable(sample.getColor()));
        ((TextView) convertView.findViewById(R.id.period)).setText(sample.getLable());

        return convertView;
    }

}
