package com.example.evgeny.testtask.observer;

import android.support.v7.widget.RecyclerView;

import com.example.evgeny.testtask.MyInputDataRecyclerViewAdapter;
import com.example.evgeny.testtask.request.InputData;

/**
 * Created by palevo on 05.05.2017.
 */

public class InputDataObserver implements Observer {

    private MyInputDataRecyclerViewAdapter adapter;

    public InputDataObserver(MyInputDataRecyclerViewAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void objectCreated(Object obj) {

    }

    @Override
    public void objectModified(Object obj) {
        if (obj instanceof InputData){
            InputData data = (InputData) obj;
            int position = adapter.getmValues().indexOf(data);
            if (position >= 0){
                adapter.notifyItemChanged(position);
            }
        }
    }
}
