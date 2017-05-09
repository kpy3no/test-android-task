package com.example.evgeny.testtask.request;

import com.example.evgeny.testtask.MyImage;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by palevo on 03.05.2017.
 */

public class Converter {
    public static final String LOG_TAG = "Converter";

    public static InputData getInputDataFromJSON(JSONObject object) throws JSONException,
            MyParseException {
        return  new InputData(object.getInt("id"), Type.parse(object.getString("type")),
                object.getString("placeholder"), object.getString("default_value"));
    }

    public static MyImage getMyImageDataFromJSON(JSONObject object) throws JSONException,
            MyParseException {
        return  new MyImage(object.getInt("albumId"), object.getInt("id"), object.getString("title"),
                object.getString("url"), object.getString("thumbnailUrl"));
    }

    ///TODO разобраться с запросом  url к placehold.it
    public static String convertUrl(String placeholdUrl){
        String[] parts = placeholdUrl.split("/");
        String size = parts[parts.length - 2];
        String id = parts[parts.length - 1];
        String txtSize;
        if (size.equals("150")){
            txtSize = "14";
        } else {
            txtSize = "56";
        }
        return "https://placeholdit.imgix.net/~text?txtsize="+txtSize +"&bg="+id+"&txt="+size+
                "%C3%97"+size+"&w="+size+"&h="+size;
    }
}
