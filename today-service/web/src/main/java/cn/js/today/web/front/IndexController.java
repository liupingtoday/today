package cn.js.today.web.front;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.js.today.domain.sys.Config;
import cn.js.today.service.cms.CategoryService;
import cn.js.today.service.cms.IndexService;
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
@RequestMapping("/front/index")
public class IndexController {

    private final Logger log = LoggerFactory.getLogger(IndexController.class);

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
        return "modules/cms/front/index";
    }

    /**
     * 获取首页的幻灯片地址
     * @return
     */
    public String getSlides(){
        //首页上部的幻灯片地址
        Config topSlidesConfig = configService.findByConfigKey("");   // '/' + SERVER_FLAG + '/f/company/companyInfo/listData'
        String topSlidesURL = topSlidesConfig.getConfigValue();


        //首页中部的幻灯片访问地址
        Config centerSlidesConfig = configService.findByConfigKey("");   // '/' + SERVER_FLAG + '/f/company/companyInfo/listData'
        String centerSlidesURL = centerSlidesConfig.getConfigValue();

        return "";
    }

    //获取公司的信息，包括logo、电话、联系人等
    public String getCompanyInfo(){


        return "";
    }


    //获取友情链接信息
    public String getFriendlyLink(){
        Config friendlyLinkConfig = configService.findByConfigKey("");   // '/' + SERVER_FLAG + '/f/company/companyInfo/listData'
        String friendlyLinkURL = friendlyLinkConfig.getConfigValue();

        return "";
    }

}
