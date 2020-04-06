package cn.js.today.web.front;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.js.today.common.CommonResponse;
import cn.js.today.service.cms.ArticleService;
import cn.js.today.service.cms.CategoryService;
import cn.js.today.service.cms.IndexService;
import cn.js.today.service.dto.cms.ArticleDTO;
import cn.js.today.service.sys.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-18
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-18
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Controller
@RequestMapping("/front/about")
public class AboutController {

    private final Logger log = LoggerFactory.getLogger(AboutController.class);

    @Autowired
    private ConfigService  configService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "list")
    public String list(Model model) {
        JSONArray allCategory = categoryService.getMenu();
        JSONObject indexJsonObject = indexService.getIndexParam();

//        String result = categoryService.getArticleListByCategoryId(categoryCode, pageNo, pageSize);

        model.addAttribute("allCategory",allCategory);
        model.addAttribute("indexJsonObject",indexJsonObject);
        log.info("111111111"+"allCategory:"+allCategory);
        return "modules/cms/front/about";
    }

    @RequestMapping(value = "queryArticleByCategoryId")
    @ResponseBody
    public CommonResponse<ArticleDTO> queryArticleByCategoryId(String categoryId, Integer pageNo, Integer pageSize) {

        CommonResponse<ArticleDTO> articleDTOCommonResponse = articleService.getArticleListByCategoryId(categoryId, pageNo, pageSize);

        log.info("1111111112222"+"articleDTOCommonResponse:"+ articleDTOCommonResponse);
        return articleDTOCommonResponse;
    }

}
