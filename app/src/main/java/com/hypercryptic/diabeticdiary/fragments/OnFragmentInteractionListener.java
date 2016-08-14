package com.hypercryptic.diabeticdiary.fragments;

/**
 * Created by Sharukh Hasan on 8/14/16.
 * Copyright © 2016 HyperCryptic Solutions, LLC. All rights reserved.
 */
public interface OnFragmentInteractionListener {
    void onFragmentInteraction(String id);

    void onFragmentInteraction(int year, int month, int day);

    void onFragmentInteraction(int hourOfDay, int minute);

    void updateDiary();
}
