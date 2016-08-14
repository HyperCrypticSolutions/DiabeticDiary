package com.hypercryptic.diabeticdiary.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import com.hypercryptic.diabeticdiary.fragments.OnFragmentInteractionListener;

import java.util.Calendar;

/**
 * Created by Sharukh Hasan on 8/14/16.
 * Copyright © 2016 HyperCryptic Solutions, LLC. All rights reserved.
 */
public class DialogDate extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    private OnFragmentInteractionListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        mListener.onFragmentInteraction(year,month,day);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }
}
