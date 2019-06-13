/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package team.javaSpirit.teachingAssistantPlatform.facematch;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

/**
 * Json工具类.
 */
public class GsonUtils {
    private static Gson gson = new GsonBuilder().create();

    public static String toJson(Object value) {
        return gson.toJson(value);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonParseException {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) throws JsonParseException {
        return (T) gson.fromJson(json, typeOfT);
    }
}
