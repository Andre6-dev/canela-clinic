package com.devandre.canelaclinic.entity.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

/**
 * andre on 14/11/2023
 */
@Slf4j
public class ResponseHandler {

    public static ResponseEntity<Object> response(HttpStatus status, Object data, boolean result) {
        Map<String, Object> map = new HashMap<>();

        try {
            map.put("timestamp", new Date());
            map.put("status", status.value());
            map.put("result", result);
            // Check if the data is a List<Object>
            if (data instanceof List<?>) {
                map.put("data", data);
            } else {
                // If it's not a list, wrap it into a list
                List<Object> dataList = new ArrayList<>();
                dataList.add(data);
                map.put("data", dataList);
            }
            return new ResponseEntity<>(map, status);
        } catch (Exception exception) {
            log.error("Error while building response", exception);
            map.clear();
            map.put("timestamp", new Date());
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("result", false);
            map.put("message", exception.getMessage());
            map.put("data", null);
            return new ResponseEntity<>(map, status);
        }
    }
}
