package com.example.evgeny.testtask.Validate;

import com.example.evgeny.testtask.request.InputData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by palevo on 04.05.2017.
 */

public class EmailValidator implements IValidate {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public boolean validate(String data) {
        matcher = pattern.matcher(data);
        return matcher.matches();
    }
}
