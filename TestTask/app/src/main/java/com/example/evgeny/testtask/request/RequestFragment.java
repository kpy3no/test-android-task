package com.example.evgeny.testtask.request;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.evgeny.testtask.R;

public class RequestFragment extends android.app.Fragment implements View.OnClickListener {
    private OnFragmentInteractionListener mListener;
    private EditText editTextRequest;
    private Button  btnSubmit;

    public RequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request, container, false);

        editTextRequest = (EditText) view.findViewById(R.id.edit_request);

        btnSubmit = (Button) view.findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);

        return view;
    }


    public void onButtonPressed(String uriString) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uriString);
        }
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
            case R.id.btn_submit:
                onButtonPressed(editTextRequest.getText().toString());
        }
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String uri);
    }
}
