package cn.js.today.utils;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-13
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-13
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class JSONUtils {

    /**
     * 按照JSONArray中的对象的某个字段进行排序(采用fastJson)
     *
     * @param jsonArrStr
     *            json数组字符串
     * @param sortKeyName
     *            需要排序的json中的key
     */
    public static String jsonArraySort(String jsonArrStr, String sortKeyName) {
        JSONArray jsonArr = JSONUtil.parseArray(jsonArrStr);
        JSONArray sortedJsonArray = new JSONArray();
        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < jsonArr.size(); i++) {
            jsonValues.add(jsonArr.getJSONObject(i));
        }
        Collections.sort(jsonValues, new Comparator<JSONObject>() {

            @Override
            public int compare(JSONObject a, JSONObject b) {
                String valA = new String();
                String valB = new String();
                try {
                    // 这里是a、b需要处理的业务，需要根据你的规则进行修改。
                    String aStr = a.getStr(sortKeyName);
                    valA = aStr.replaceAll("-", "");
                    String bStr = b.getStr(sortKeyName);
                    valB = bStr.replaceAll("-", "");
                } catch (JSONException e) {
                    // do something
                }
                return -valA.compareTo(valB);
                // if you want to change the sort order, simply use the following:
                // return -valA.compareTo(valB);
            }
        });
        for (int i = 0; i < jsonArr.size(); i++) {
            sortedJsonArray.add(jsonValues.get(i));
        }
        return sortedJsonArray.toString();
    }

    public static void main(String[] args) {
        String jsonArrStr = "[ { \"ID\": \"2016-05-25\", \"Name\": \"Fargo Chan\" },{ \"ID\": \"2016-05-23\", \"Name\": \"Aaron Luke\" },{ \"ID\": \"2016-05-26\", \"Name\": \"Dilip Singh\" }]";
        System.out.println("排序前："+jsonArrStr);
        String jsonArraySort = jsonArraySort(jsonArrStr, "ID");
        System.out.println("排序后："+jsonArraySort);
    }

}
