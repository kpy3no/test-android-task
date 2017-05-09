package com.example.evgeny.testtask.parceJSON;

import com.example.evgeny.testtask.request.Converter;
import com.example.evgeny.testtask.request.InputData;
import com.example.evgeny.testtask.request.MyParseException;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by palevo on 06.05.2017.
 */

public class InputDataParser extends Parser {

    public InputDataParser(String urlString) {
        super(urlString);
    }

    @Override
    public ArrayList<InputData> parseJSONData(String json) throws JSONException, MyParseException {
        JSONArray jsonArray = new JSONArray(json);
        ArrayList<InputData> inputDataList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            InputData inputData = Converter.getInputDataFromJSON(jsonArray.getJSONObject(i));
            inputDataList.add(inputData);
        }

        return inputDataList;
    }
}
