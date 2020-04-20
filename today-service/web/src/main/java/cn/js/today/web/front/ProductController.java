package cn.js.today.web.front;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.js.today.common.CommonResponse;
import cn.js.today.service.cms.ArticleService;
import cn.js.today.service.cms.CategoryService;
import cn.js.today.service.cms.IndexService;
import cn.js.today.service.dto.cms.ArticleDTO;
import cn.js.today.service.dto.cms.ArticleDataDTO;
import cn.js.today.service.sys.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("/front/product")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ConfigService  configService;

    @Autowired
    private IndexService indexService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

//    @RequestMapping(value = "list")
//    public String list(Model model) {
//        JSONArray allCategory = categoryService.getMenu();
//        model.addAttribute("allCategory",allCategory);
//        log.info("111111111"+"allCategory:"+allCategory);
//        return "modules/cms/front/product";
//    }

    @RequestMapping(value = "/{articleId}")
    public String list(@PathVariable String articleId, Model model)  {
        log.info("----------------articleId:"+ articleId);
        JSONArray allCategory = categoryService.getMenu();
        JSONObject indexJsonObject = indexService.getIndexParam();

        ArticleDataDTO articleDataDTO = articleService.getArticleDataByArticleId(articleId);

        //根据articleId查询文章详情
        model.addAttribute("allCategory",allCategory);
        model.addAttribute("indexJsonObject",indexJsonObject);
        //文章详情内容
        model.addAttribute("articleDataDTO", articleDataDTO);
        log.info("111111111"+"articleDataDTO:"+ articleDataDTO);
        return "modules/cms/front/product";
    }


}
