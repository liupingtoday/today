package cn.js.today.web.front;

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
@RequestMapping("/index")
public class IndexController {

    private final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ConfigService  configService;

    @RequestMapping(value = "list")
    public String list(Model model) {
        return "modules/cms/front/index";
    }

}
