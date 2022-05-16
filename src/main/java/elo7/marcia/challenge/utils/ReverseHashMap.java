package elo7.marcia.challenge.utils;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ResponseBody
public class ReverseHashMap<K, V> extends HashMap<K, V> {

    Map<V, K> reverseMap = new HashMap<>();

    @Override
    public V put(K key, V value)
    {
        reverseMap.put(value, key);
        return super.put(key, value);
    }

    public K getKey(V value) {
        return reverseMap.get(value);
    }
}
