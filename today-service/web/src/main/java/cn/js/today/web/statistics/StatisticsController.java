package cn.js.today.web.statistics;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.js.today.service.ConfigService;
import cn.js.today.sys.entity.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static cn.js.today.utils.DateUtils.getDays;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2019-12-14
 * @UpdateUser: liuping
 * @UpdateDate: 2019-12-14
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@RestController
@RequestMapping("/api")
public class StatisticsController {

    private final Logger log = LoggerFactory.getLogger(StatisticsController.class);

    @Autowired
    private ConfigService  configService;

    /**
     *
     * @return
     */
    @GetMapping(value = "/statistics/clipcloud/usage")
    public String getClipCloudUsage() {
        Config urlConfig = configService.findByConfigKey("clipCloudStatisticsURL");
        Map<String, Object> map = new HashMap<>();//存放参数
        Config cookieConfig = configService.findByConfigKey("clipCloudCookies");
        log.info(cookieConfig.toString());
        HashMap<String, String> headers = new HashMap<>();//存放请求头，可以存放多个请求头
        headers.put("Cookie", cookieConfig.getConfigValue());
        //发送get请求并接收响应数据
        String result= HttpUtil.createGet(urlConfig.getConfigValue()).addHeaders(headers).form(map).execute().body();
        JSONObject jsonObject = JSONUtil.parseObj(result);
        JSONObject jsonObject1 = (JSONObject)jsonObject.get("result");

        //获取最近七天的日期，包括当天的日期
        ArrayList<String> arrayList = getDays(7);
        JSONArray newJSONArray = JSONUtil.createArray();

        for(String str : arrayList){
            JSONObject newJsonObject = JSONUtil.createObj();
            newJsonObject.put("currentDate",str);

            JSONObject jsonObjectTemp =(JSONObject)jsonObject1.get(str);
            JSONObject childJsonObject = (JSONObject)jsonObjectTemp.get("child");
            newJsonObject.put("uploadNum",jsonObjectTemp.get("uploadNum"));// 上传数量
            JSONObject childJsonObject2 = (JSONObject)childJsonObject.get("2");//现场直播
            newJsonObject.put("liveProduce",childJsonObject2.get("productSuccessNum"));
            newJsonObject.put("liveDist",childJsonObject2.get("distSuccessNum"));
            childJsonObject2.remove("productSuccessRate");
            childJsonObject2.remove("distSuccessRate");
            JSONObject childJsonObject3 = (JSONObject)childJsonObject.get("3"); // 开路直播
            if(null != childJsonObject3){
                childJsonObject3.remove("productSuccessRate");
                childJsonObject3.remove("distSuccessRate");
            }
            JSONObject childJsonObject4 = (JSONObject)childJsonObject.get("4"); // 点播
            newJsonObject.put("videoProduce",childJsonObject4.get("productSuccessNum"));
            newJsonObject.put("videoDist",childJsonObject4.get("distSuccessNum"));
            childJsonObject4.remove("productSuccessRate");
            childJsonObject4.remove("distSuccessRate");
            newJSONArray.add(newJsonObject);
        }
        log.info(jsonObject1.toString());
        return newJSONArray.toString();
    }

}
