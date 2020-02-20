package cn.js.today.web.front;

import cn.hutool.json.JSONArray;
import cn.js.today.service.cms.CategoryService;
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
 * @Since 2020-02-18
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-18
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Controller
@RequestMapping("/about")
public class AboutController {

    private final Logger log = LoggerFactory.getLogger(AboutController.class);

    @Autowired
    private ConfigService  configService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "list")
    public String list(Model model) {
        JSONArray allCategory = categoryService.getAllCategory();
        model.addAttribute("allCategory",allCategory);
        log.info("111111111"+"allCategory:"+allCategory);
        return "modules/cms/front/about";
    }

}
