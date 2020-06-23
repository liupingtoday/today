package cn.js.today.utils;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.poi.ss.formula.functions.T;

import java.util.*;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-03-15
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-15
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class SortUtils{


    /**
     *  根据Map的key排序，key为日期类型，例如：2020-03-11
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        Map sortedMap = new LinkedHashMap();
        List list = new ArrayList(map.keySet());
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String valA = new String();
                String valB = new String();
                valA = o1.replaceAll("-", "");
                valB = o2.replaceAll("-", "");
                return -valA.compareTo(valB);
            }

        });
        for (int i = 0; i < map.size(); i++) {
            String  sortedKey = (String) list.get(i);
            String sortedValue = map.get(sortedKey);
            sortedMap.put(sortedKey, sortedValue);
        }
        return sortedMap;
    }

    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
//    public static Map<String, String> sortMapByKey(Map<String, String> map) {
//        if (map == null || map.isEmpty()) {
//            return null;
//        }
//
//        Map<String, String> sortMap = new TreeMap<String, String>(
//                new MapKeyComparator());
//
//        sortMap.putAll(map);
//
//        return sortMap;
//    }


    /**
     * 使用 Map按value进行排序
     * @param oriMap
     * @return
     */
    public static Map<String, String> sortMapByValue(Map<String, String> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, String>> iter = entryList.iterator();
        Map.Entry<String, String> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }




    /**
     * flag = 1 正序
     * flag = 0 倒序
     * 对MAP中的value进行排序
     * @param map
     * @param flag
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, int flag) {

        if (flag == 1) {
            return map.entrySet().stream().sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue())).map(entry -> {
                Map<K, V> result = new LinkedHashMap<>();
                result.put(entry.getKey(), entry.getValue());
                return result;
            }).reduce((map1, map2) -> {
                map2.entrySet().forEach(entry -> map1.put(entry.getKey(), entry.getValue()));
                return map1;
            }).get();
        } else {
            return map.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).map(entry -> {
                Map<K, V> result = new LinkedHashMap<>();
                result.put(entry.getKey(), entry.getValue());
                return result;
            }).reduce((map1, map2) -> {
                map2.entrySet().forEach(entry -> map1.put(entry.getKey(), entry.getValue()));
                return map1;
            }).get();

        }

    }


}


class MapKeyComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        String valA = new String();
        String valB = new String();

        valA = str1.replaceAll("-", "");
        valB = str2.replaceAll("-", "");
        return -valA.compareTo(valB);
    }
}

class MapValueComparator implements Comparator<Map.Entry<String, String>> {

    @Override
    public int compare(Map.Entry<String, String> me1, Map.Entry<String, String> me2) {

        return me1.getValue().compareTo(me2.getValue());
    }
}