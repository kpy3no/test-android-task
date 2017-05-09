package com.example.evgeny.testtask;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.evgeny.testtask.Validate.ValidateHandler;

import com.example.evgeny.testtask.observer.InputDataObserver;
import com.example.evgeny.testtask.request.InputData;
import com.example.evgeny.testtask.request.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class InputDataFragment extends android.app.Fragment
        implements View.OnClickListener {


    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String ARG_DATA_LIST = "data-list";

    private int mColumnCount = 1;
    private ArrayList<InputData> inputDataArrayList;
    private OnListFragmentInteractionListener mListener;
    private Button btnValidate;
    private MyInputDataRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public InputDataFragment() {
    }


    public static InputDataFragment newInstance(int columnCount, ArrayList<InputData> inputDataList) {
        InputDataFragment fragment = new InputDataFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_DATA_LIST, inputDataList);
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            inputDataArrayList = getArguments().getParcelableArrayList(ARG_DATA_LIST);
        } else{
            inputDataArrayList = new ArrayList<>();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inputdata_list, container, false);

        // Set the adapter
        if (view.findViewById(R.id.list) != null) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view.findViewById(R.id.list);
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new MyInputDataRecyclerViewAdapter(inputDataArrayList, mListener);
            recyclerView.setAdapter(adapter);

            btnValidate = (Button) view.findViewById(R.id.btn_validate);
            btnValidate.setOnClickListener(this);

            InputDataObserver observer = new InputDataObserver(adapter);
            for (InputData data: inputDataArrayList){
                data.addObserver(observer);
            }
        }
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        attach(activity);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        attach(context);
    }

    private void attach(Context context){
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_validate:
                onButtonPressed();
        }
    }

    private void onButtonPressed() {

        List<InputData> dataList = adapter.getmValues();
        boolean hasInvalid = false;

        for (int i = 0; i < dataList.size(); i++){
            InputData inputData = dataList.get(i);
            boolean isValid = ValidateHandler.handleValidate(inputData.getType(), inputData.getText());
            if (!isValid)
                hasInvalid = true;
            inputData.setValid(isValid);
        }
        if (!hasInvalid){
            if (mListener != null){
                mListener.onValidationCompleted();
            }
        }
    }
}
