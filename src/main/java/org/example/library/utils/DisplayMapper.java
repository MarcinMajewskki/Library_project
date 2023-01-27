package org.example.library.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DisplayMapper {

    public static <T> Map<Integer, T> convertToMap(Collection<T> collection) {
        Integer index = 1;
        Map<Integer, T> map = new HashMap<>();
        for (T t : collection) {
            map.put(index, t);
            index++;
        }
//        Map<Integer, T> map = collection.stream()
//                .collect(Collectors.toMap(Integer, Function.identity()));
        return map;
    }


}
