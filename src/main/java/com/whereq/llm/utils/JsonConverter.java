package com.whereq.llm.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import org.mapstruct.Context;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@Named("JsonConverter")
public class JsonConverter {

    public static final TypeReference<Map<String, Object>> mapTypeRef = new TypeReference<Map<String, Object>>() {};
    private static final ObjectMapper mapper = new ObjectMapper();

    @Named("toType")
    public static <T> T toType(String json, @Context TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (Exception ignore) {
            return null;
        }
    }

    @Named("toMap")
    public static Map<String, Object> toMap(String json) {
        return toType(json, mapTypeRef);
    }

    @Named("toList")
    public static List toList(String json) {
        try {
            return mapper.readValue(json, List.class);
        } catch (Exception ignore) {
            return null;
        }
    }

    @Named("toJson")
    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }
}
