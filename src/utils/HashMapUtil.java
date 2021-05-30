package utils;

import java.util.HashMap;

public class HashMapUtil {

	public HashMapUtil() {}
	
	
	public static String getValue(HashMap<String, String> map, String key) {
		return map.get(key).toString();
	}
	
}
