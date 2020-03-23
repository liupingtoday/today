package cn.js.today.web.front;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.js.today.domain.cms.Category;
import cn.js.today.domain.cms.Site;
import cn.js.today.domain.sys.Config;
import cn.js.today.service.cms.CategoryService;
import cn.js.today.service.dto.cms.CategoryDTO;
import cn.js.today.service.sys.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-15
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-15
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Controller
@RequestMapping("/front/category")
public class CategoryController {

    private final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private ConfigService  configService;

    @Autowired
    private CategoryService  categoryService;

    /**
     * 获取所有的栏目信息
     * @param
     * @return
     */
    @RequestMapping(value = "getAll")
    @ResponseBody
    public String getAllCategory() {
        return categoryService.getAllCategory().toString();
    }

    @RequestMapping(value = "getArticleListByCategoryId", method = RequestMethod.GET)
    @ResponseBody
    public String getArticleListByCategoryId(String categoryCode, String pageNo, String pageSize){
        String result = categoryService.getArticleListByCategoryId(categoryCode, pageNo, pageSize);
        return result;
    }
}
