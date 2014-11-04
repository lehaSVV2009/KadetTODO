package com.kadet.kadetTODO.util.extjs;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExtJSResponse<T> {

    public Map<String, Object> mapOK (List<T> items) {

        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("total", items.size());
        modelMap.put("data", items);
        modelMap.put("success", true);

        return modelMap;
    }

    public Map<String, Object> mapOK (List<T> items, long total) {

        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("total", total);
        modelMap.put("data", items);
        modelMap.put("success", true);

        return modelMap;
    }

    public Map<String, Object> mapOK (List<T> items, String message) {

        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("message", message);
        modelMap.put("data", items);
        modelMap.put("success", true);

        return modelMap;
    }

    public Map<String, Object> mapOK (T item) {

        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("data", item);
        modelMap.put("success", true);

        return modelMap;
    }

    public Map<String, Object> mapOK (T item, String msg) {

        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("data", item);
        modelMap.put("message", msg);
        modelMap.put("success", true);

        return modelMap;
    }


    public Map<String, Object> mapError (String msg) {

        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("message", msg);
        modelMap.put("success", false);

        return modelMap;
    }
}
