package com.example.evgeny.testtask;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by palevo on 06.05.2017.
 */

public class MyImage implements Parcelable {
    public static final String LOG_TAG = "MyImage";

    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public MyImage(int albumId, int id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<MyImage> CREATOR = new Parcelable.Creator<MyImage>() {
        // распаковываем объект из Parcel
        public MyImage createFromParcel(Parcel in) {
            Log.d(LOG_TAG, "createFromParcel");
            return new MyImage(in);
        }

        public MyImage[] newArray(int size) {
            return new MyImage[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(albumId);
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeString(thumbnailUrl);
    }

    private MyImage(Parcel parcel){
        albumId =parcel.readInt();
        id = parcel.readInt();
        title = parcel.readString();
        url = parcel.readString();
        thumbnailUrl = parcel.readString();
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }


}
