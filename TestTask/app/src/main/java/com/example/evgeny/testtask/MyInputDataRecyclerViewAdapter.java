package com.example.evgeny.testtask;

import android.graphics.Color;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.evgeny.testtask.request.InputData;

import java.util.List;

/**

 */
public class MyInputDataRecyclerViewAdapter extends RecyclerView.Adapter<MyInputDataRecyclerViewAdapter.ViewHolder> {

    private final List<InputData> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyInputDataRecyclerViewAdapter(List<InputData> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_input_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        InputData mItem = mValues.get(position);
        holder.mItem = mItem;

        holder.editText.setText(mItem.getText());
        int color = mItem.isValid() ? Color.TRANSPARENT : Color.RED;
        holder.editText.setBackgroundColor(color);
        holder.editText.setHint(mItem.getType().toString());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                holder.mItem.setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public List<InputData> getmValues() {
        return mValues;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final EditText editText;
        public InputData mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            editText = (EditText) view.findViewById(R.id.edit_text_input_data);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + editText.getText() + "'";
        }
    }
}
