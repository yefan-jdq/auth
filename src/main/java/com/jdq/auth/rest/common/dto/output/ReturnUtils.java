package com.jdq.auth.rest.common.dto.output;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class ReturnUtils {

	public static JSONObject backObjId(Long id) {
		JSONObject data = new JSONObject();
		data.put("id", id);
		return data;
	}

	public static JSONObject backObjId(Long id, Map<String, Object> extra) {
		JSONObject data = new JSONObject(extra);
		data.put("id", id);
		return data;
	}

	public static JSONObject backObj(String key, Object value) {
		JSONObject data = new JSONObject();
		data.put(key, value);
		return data;
	}
}