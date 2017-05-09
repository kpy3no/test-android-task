package com.example.evgeny.testtask;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ImageFragment extends android.app.Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String ARG_DATA_LIST = "data-list";

    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private ArrayList<MyImage> imageArrayList;

    public ImageFragment() {
    }

    public static ImageFragment newInstance(int columnCount, ArrayList<MyImage> imageArrayList) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_DATA_LIST, imageArrayList);
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            imageArrayList = getArguments().getParcelableArrayList(ARG_DATA_LIST);
        } else{
            imageArrayList = new ArrayList<>();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyImageRecyclerViewAdapter(view.getContext(),imageArrayList,
                    mListener));
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

}
