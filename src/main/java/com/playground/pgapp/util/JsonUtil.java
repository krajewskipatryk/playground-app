package com.playground.pgapp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.util.Collection;

public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String marshalJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            System.out.printf(e.getMessage());
            return null;
        }
    }

    public static <T> T unmarshalJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            System.out.printf(e.getMessage());
            return null;
        }
    }

    public static <T> T unmarshalJsonCollection(String json, Class<? extends Collection> collection, Class<?> clazz){
        try {
            CollectionType typeReference = TypeFactory.defaultInstance().constructCollectionType(collection, clazz);
            return mapper.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            System.out.printf(e.getMessage());
            return null;
        }
    }
}
