package com.example.evgeny.testtask;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.evgeny.testtask.request.Converter;
import com.squareup.picasso.Picasso;

import java.net.URLEncoder;
import java.util.List;


public class MyImageRecyclerViewAdapter extends RecyclerView.Adapter<MyImageRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private final List<MyImage> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyImageRecyclerViewAdapter(Context context, List<MyImage> items,
                                      OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        MyImage myImage = mValues.get(position);
        holder.mItem = myImage;
        Picasso.with(context)
                .setLoggingEnabled(true);

        String urlPath = Converter.convertUrl(myImage.getThumbnailUrl());

        Picasso.with(context)
                .load(urlPath)
                .placeholder(R.drawable.progress_animation)
                .into(holder.mImageView);
        holder.mTitle.setText(myImage.getTitle());
        holder.mId.setText(Integer.toString(myImage.getId()));

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
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImageView;
        public final TextView mId;
        public final TextView mTitle;
        public MyImage mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.image_view_card);
            mId = (TextView) view.findViewById(R.id.image_id);
            mTitle = (TextView) view.findViewById(R.id.image_title);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitle.getText() + "'";
        }
    }
}
