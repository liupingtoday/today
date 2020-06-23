package cn.js.today.web.front;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.js.today.service.cms.CategoryService;
import cn.js.today.service.cms.IndexService;
import cn.js.today.service.sys.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/front/newsList")
public class NewsListController {

    private final Logger log = LoggerFactory.getLogger(NewsListController.class);

    @Autowired
    private ConfigService  configService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "list")
    public String list(Model model) {
        JSONArray allCategory = categoryService.getAllCategory();

        allCategory = categoryService.addParamCategory(allCategory);

        JSONObject indexJsonObject = indexService.getIndexParam();

        model.addAttribute("allCategory",allCategory);
        model.addAttribute("indexJsonObject",indexJsonObject);
        log.info("111111111"+"allCategory:"+allCategory);
        return "modules/cms/front/newsList";
    }

}
