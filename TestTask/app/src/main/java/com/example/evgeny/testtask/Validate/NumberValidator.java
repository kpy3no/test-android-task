package com.example.evgeny.testtask.Validate;

import com.example.evgeny.testtask.request.InputData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by palevo on 04.05.2017.
 */

public class NumberValidator implements IValidate {
    private Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_PATTERN =
            "^\\d{5,}+$";

    public NumberValidator() {
        pattern = Pattern.compile(PHONE_PATTERN);
    }

    @Override
    public boolean validate(String data) {
        matcher = pattern.matcher(data);
        return matcher.matches();
    }
}
