package com.example.evgeny.testtask.Validate;

import com.example.evgeny.testtask.request.InputData;

/**
 * Created by palevo on 04.05.2017.
 */

public class TextValidator implements IValidate {
    @Override
    public boolean validate(String data) {
        int length = data.length();
        return length > 10 && length < 30;
    }
}
