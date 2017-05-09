package com.example.evgeny.testtask.request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by palevo on 03.05.2017.
 */

public enum Type {
    Text, Email, Phone, Number, Url;
    private static final Map<String, Type> hashMap = new HashMap<String, Type>(){{
       put("TEXT", Text);
       put("EMAIL", Email);
       put("PHONE", Phone);
       put("NUMBER", Number);
       put("URL", Url);
    }};
    public static Type parse(String key) throws MyParseException {
        if (!hashMap.containsKey(key)){
            throw new MyParseException("Type.parse");
        }
        return hashMap.get(key);
    }
}
