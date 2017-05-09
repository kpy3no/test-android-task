package com.example.evgeny.testtask.parceJSON;

import com.example.evgeny.testtask.MyImage;
import com.example.evgeny.testtask.request.Converter;
import com.example.evgeny.testtask.request.MyParseException;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by palevo on 06.05.2017.
 */

public class ImageDataPacer extends Parser {

    public ImageDataPacer() {
        super("https://jsonplaceholder.typicode.com/photos");
    }

    public ImageDataPacer(String urlString) {
        super(urlString);
    }

    @Override
    public ArrayList<MyImage> parseJSONData(String json) throws JSONException, MyParseException {
        JSONArray jsonArray = new JSONArray(json);
        ArrayList<MyImage> imageDataList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            MyImage myImage = Converter.getMyImageDataFromJSON(jsonArray.getJSONObject(i));
            imageDataList.add(myImage);
        }

        return imageDataList;
    }
}
