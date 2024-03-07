package com.playground.pgapp.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playground.pgapp.transactional.User;
import com.playground.pgapp.util.JsonUtil;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

class UserDeserializer implements Deserializer<User> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public User deserialize(String s, byte[] data) {
        if (data == null) {
            return null;
        }
        return JsonUtil.unmarshalJson(Arrays.toString(data), User.class);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
