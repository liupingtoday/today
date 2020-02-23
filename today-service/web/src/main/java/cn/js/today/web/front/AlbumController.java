package cn.js.today.web.front;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.js.today.service.cms.CategoryService;
import cn.js.today.service.sys.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("/front/album")
public class AlbumController {

    private final Logger log = LoggerFactory.getLogger(AlbumController.class);

    @Autowired
    private ConfigService  configService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "list")
    public String list(Model model) {
        JSONArray allCategory = categoryService.getMenu();
        model.addAttribute("allCategory",allCategory);
        log.info("111111111"+"allCategory:"+allCategory);
        return "modules/cms/front/album";
    }

}
