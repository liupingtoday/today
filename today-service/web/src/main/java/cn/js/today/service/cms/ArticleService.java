package cn.js.today.service.cms;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.js.today.domain.sys.Config;
import cn.js.today.repository.cms.ArticleRepository;
import cn.js.today.service.sys.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

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
@Service
@Transactional
public class ArticleService {

    private final Logger log = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ConfigService configService;


    public JSONObject getArticleById(String articleId) {

        /***********************companyInfo********************************/
        Config articleConfig = configService.findByConfigKey("czfytArticleDataURL");   // '/' + SERVER_FLAG + '/f/company/companyInfo/listData'
        String articleURL = articleConfig.getConfigValue();

        HttpResponse httpResponse = null;
        try {
            httpResponse = HttpRequest.get(articleURL + "?id=" + articleId).timeout(20*1000).execute();
        } catch (Exception e) {
            log.info("error-----" + e.getMessage());
            return JSONUtil.createObj();
        }
        //请求不成功的情况
        if(!httpResponse.isOk()){
            return JSONUtil.createObj();
        }

        String httpResponseStr = httpResponse.body();
        log.info("httpResponseStr:" + httpResponseStr);
        JSONObject jsonObject = JSONUtil.parseObj(httpResponseStr);
        JSONArray jsonArray = (JSONArray)jsonObject.get("list");
        JSONArray articlesJsonArray = JSONUtil.createArray();
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject articlesJsonObject = JSONUtil.createObj();
            JSONObject jsonObject1 = (JSONObject)iterator.next();
            String content = (String)jsonObject1.get("content");
//            articlesJsonObject.put();
            articlesJsonArray.add(jsonObject1);

        }
//        articlesJsonObject.put("articlesJsonArray",articlesJsonArray);

        return JSONUtil.createObj();

    }

}
