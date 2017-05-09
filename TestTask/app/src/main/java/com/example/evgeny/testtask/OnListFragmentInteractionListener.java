package com.example.evgeny.testtask;

import com.example.evgeny.testtask.request.InputData;

/**
 * Created by palevo on 06.05.2017.
 */

public interface OnListFragmentInteractionListener {
    void onListFragmentInteraction(InputData item);
    void onListFragmentInteraction(MyImage item);
    void onValidationCompleted();
}
