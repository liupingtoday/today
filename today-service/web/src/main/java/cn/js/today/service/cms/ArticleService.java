package cn.js.today.service.cms;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.js.today.common.CommonResponse;
import cn.js.today.domain.cms.ArticleData;
import cn.js.today.domain.sys.Config;
import cn.js.today.repository.cms.ArticleRepository;
import cn.js.today.service.dto.cms.ArticleDTO;
import cn.js.today.service.sys.ConfigService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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


    /**
     * 根据栏目ID获取文章列表信息
     * @param categoryCode
     * @return
     */
    public CommonResponse<ArticleDTO> getArticleListByCategoryId(String categoryCode, Integer pageNo, Integer pageSize) {
        CommonResponse<ArticleDTO> articleDTOCommonResponse = new CommonResponse<>();

        /***********************companyInfo********************************/
        Config articleConfig = configService.findByConfigKey("czfytArticleListURL");   // '/' + SERVER_FLAG + '/f/company/companyInfo/listData'
        String articleURL = articleConfig.getConfigValue();

        HttpResponse httpResponse = null;
        try {
            String url = articleURL + "?categoryCode=" + categoryCode + "&pageNo=" + pageNo + "&pageSize=" + pageSize;
            log.info("request url ----- " + url);
            httpResponse = HttpRequest.get(url).timeout(30*1000).execute();
        } catch (Exception e) {
            log.info("error-----" + e.getMessage());
            return new CommonResponse<ArticleDTO>();
        }
        //请求不成功的情况
        if(!httpResponse.isOk()){
            return new CommonResponse<ArticleDTO>();
        }

        String httpResponseStr = httpResponse.body();
        log.info("httpResponseStr:" + httpResponseStr);
        JSONObject jsonObject = JSONUtil.parseObj(httpResponseStr);
        Integer pageRowNum = (Integer)jsonObject.get("pageRowNum");
        articleDTOCommonResponse.setPageSize(pageRowNum);
        Integer currentPageNo = (Integer)jsonObject.get("pageNo");
        articleDTOCommonResponse.setCurrentPage(currentPageNo);
        Integer totalPageNum = (Integer)jsonObject.get("totalPageNum");
        articleDTOCommonResponse.setTotalPage(totalPageNum);
        Integer totalRowNum = (Integer)jsonObject.get("totalRowNum");//总记录数
        articleDTOCommonResponse.setTotalCount(totalRowNum);
        JSONArray jsonArray = (JSONArray)jsonObject.get("result");
        JSONArray articlesJsonArray = JSONUtil.createArray();
        List articleDataList = new ArrayList();
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject articlesJsonObject = JSONUtil.createObj();
            ArticleDTO articleDTO = new ArticleDTO();
            JSONObject articleJsonObject = (JSONObject)iterator.next();
            String articleId = (String)articleJsonObject.get("id");
            articleDTO.setId(Long.valueOf(articleId));
            String articleStatus = (String)articleJsonObject.get("status");
            String articleCreateDate = (String)articleJsonObject.get("createDate");
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime createDate = LocalDateTime.parse(articleCreateDate, df);
            articleDTO.setCreatedTime(createDate);
            String articleUpdateDate = (String)articleJsonObject.get("updateDate");
            LocalDateTime updateDate = LocalDateTime.parse(articleUpdateDate, df);
            articleDTO.setUpdatedTime(updateDate);
            String articleRemarks = (String)articleJsonObject.get("remarks");
            articleDTO.setRemarks(articleRemarks);
            String articleUpdateBy = (String)articleJsonObject.get("updateBy");

            String articleCreateBy = (String)articleJsonObject.get("createBy");

            String articleTitle = (String)articleJsonObject.get("title");
            articleDTO.setTitle(articleTitle);
            String articleHref = (String)articleJsonObject.get("href");
            articleDTO.setHref(articleHref);
            String articleColor = (String)articleJsonObject.get("color");

            String articleImage = (String)articleJsonObject.get("image");
            articleDTO.setImage(articleImage);
            String articleKeywords = (String)articleJsonObject.get("keywords");
            articleDTO.setKeywords(articleKeywords);
            String articleDescription = (String)articleJsonObject.get("description");
            articleDTO.setDescription(articleDescription);
            String articleSource = (String)articleJsonObject.get("source");

            String articleUrl = (String)articleJsonObject.get("url");

            Integer articleWeight = (Integer)articleJsonObject.get("weight");

            Integer articleHits = (Integer)articleJsonObject.get("hits");

            JSONObject categoryJSONObject = (JSONObject)articleJsonObject.get("category");
            String currentCategoryCode = (String)categoryJSONObject.get("categoryCode");//文章所属栏目的ID
            articleDTO.setCategoryCode(currentCategoryCode);
            articleDataList.add(articleDTO);

        }

        articleDTOCommonResponse.setData(articleDataList);
        return articleDTOCommonResponse;

    }

}
