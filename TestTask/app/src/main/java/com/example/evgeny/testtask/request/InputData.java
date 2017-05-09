package com.example.evgeny.testtask.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.example.evgeny.testtask.observer.Observable;
import com.example.evgeny.testtask.observer.Observer;
import com.example.evgeny.testtask.observer.Observers;

/**
 * Created by palevo on 03.05.2017.
 */

public class InputData implements Parcelable, Observable {
    public static final String LOG_TAG = "InputData";

    private int id;
    private Type type;
    private String placeHolder;
    private String text;
    private boolean isValid = true;
    private Observers observers = new Observers();

    public InputData(int id, Type type, String placeHolder, String text) {
        this.id = id;
        this.type = type;
        this.placeHolder = placeHolder;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        if (isValid != valid) {
            isValid = valid;
            observers.notifyObjectModified(this);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<InputData> CREATOR = new Parcelable.Creator<InputData>() {
        // распаковываем объект из Parcel
        public InputData createFromParcel(Parcel in) {
            Log.d(LOG_TAG, "createFromParcel");
            return new InputData(in);
        }

        public InputData[] newArray(int size) {
            return new InputData[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(type.ordinal());
        dest.writeString(placeHolder);
        dest.writeString(text);
    }

    private InputData(Parcel parcel){
        id = parcel.readInt();
        type = Type.values()[parcel.readInt()];
        placeHolder = parcel.readString();
        text = parcel.readString();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

}
