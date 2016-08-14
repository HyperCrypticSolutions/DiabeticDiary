package com.hypercryptic.diabeticdiary.fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.ListFragment;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hypercryptic.diabeticdiary.R;
import com.hypercryptic.diabeticdiary.adapters.SamplesAdapter;
import com.hypercryptic.diabeticdiary.db.DatabaseHelper;
import com.hypercryptic.diabeticdiary.db.SampleDataTables;
import com.hypercryptic.diabeticdiary.utils.DialogSample;

/**
 * Created by Sharukh Hasan on 8/14/16.
 * Copyright © 2016 HyperCryptic Solutions, LLC. All rights reserved.
 */
public class DiaryFragment extends ListFragment implements View.OnClickListener{
    private static final String ARG_SECTION_NUMBER = "section_number";
    public static final String TAG = "diaryFragment";

    private Button newSample;
    private SamplesAdapter adapterSamples;
    private TextView empty;

    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types of parameters
    public static DiaryFragment newInstance(int sectionNumber) {
        DiaryFragment fragment = new DiaryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public DiaryFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        final SQLiteDatabase db = databaseHelper.getReadableDatabase();
        adapterSamples = new SamplesAdapter(getActivity(), SampleDataTables.getSample(db));
        db.close();

        setListAdapter(adapterSamples);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  rootView = inflater.inflate(R.layout.fragment_diary, container, false);

        newSample = (Button) rootView.findViewById(R.id.add_button);
        newSample.setOnClickListener(this);

        empty = (TextView) rootView.findViewById(R.id.empty_diary);

        if(adapterSamples.isEmpty())
            empty.setVisibility(View.VISIBLE);
        else
            empty.setVisibility(View.INVISIBLE);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onClick(View view) {
        DialogFragment newFragment = new DialogSample();
        newFragment.show(getFragmentManager(), "sampleDialog");
    }

    public void updateData(){
        adapterSamples.clear();

        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        final SQLiteDatabase db = databaseHelper.getReadableDatabase();
        adapterSamples.addAll(SampleDataTables.getSample(db));
        db.close();

        adapterSamples.notifyDataSetChanged();

        if(adapterSamples.isEmpty())
            empty.setVisibility(View.VISIBLE);
        else
            empty.setVisibility(View.INVISIBLE);
    }
}
