package com.example.evgeny.testtask.Validate;

import com.example.evgeny.testtask.request.InputData;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by palevo on 04.05.2017.
 */

public class UrlValidator implements IValidate {
    @Override
    public boolean validate(String data) {
        try {
            new URL(data);
            return true;
        } catch (MalformedURLException e){
            return false;
        }
    }
}
