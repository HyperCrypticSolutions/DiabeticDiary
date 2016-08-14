package com.hypercryptic.diabeticdiary.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import com.hypercryptic.diabeticdiary.fragments.OnFragmentInteractionListener;

import java.util.Calendar;

/**
 * Created by Sharukh Hasan on 8/14/16.
 * Copyright © 2016 HyperCryptic Solutions, LLC. All rights reserved.
 */
public class DialogTimer extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
    private OnFragmentInteractionListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        mListener.onFragmentInteraction(hourOfDay,minute);
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
}
