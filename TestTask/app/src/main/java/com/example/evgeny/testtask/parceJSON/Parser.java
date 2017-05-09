package com.example.evgeny.testtask.parceJSON;

import com.example.evgeny.testtask.request.MyParseException;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by palevo on 06.05.2017.
 */

public abstract class Parser<T> {
    protected String urlString;

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public Parser(String urlString) {
        this.urlString = urlString;
    }

    public abstract ArrayList<T> parseJSONData(String json) throws JSONException, MyParseException;
}
