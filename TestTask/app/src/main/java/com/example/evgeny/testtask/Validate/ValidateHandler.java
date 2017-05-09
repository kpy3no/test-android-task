package com.example.evgeny.testtask.Validate;

import com.example.evgeny.testtask.request.Type;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by palevo on 05.05.2017.
 */

public class ValidateHandler {
    private static final Map<Type, IValidate> commandMap = new HashMap<Type, IValidate>(){{
        put(Type.Text, new TextValidator());
        put(Type.Email, new EmailValidator());
        put(Type.Phone, new PhoneValidator());
        put(Type.Number, new NumberValidator());
        put(Type.Url, new UrlValidator());
    }};

    public static boolean handleValidate(Type type, String data){
        IValidate validator = commandMap.get(type);
        return validator.validate(data);
    }
}
