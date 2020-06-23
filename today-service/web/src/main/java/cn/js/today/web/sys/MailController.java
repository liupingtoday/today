package cn.js.today.web.sys;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.js.today.service.sys.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-12
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-12
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@RestController
@RequestMapping("/api")
public class MailController {

    private final Logger log = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private ConfigService configService;

    private static final String ENTITY_NAME = "mail";

    @Value("${spring.application.name}")
    private String applicationName;

//    public MailController(ConfigService configService) {
//        this.configService = configService;
//    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/mail")
    public String getMail() {
//        log.debug("REST request to get Config : {}", id);
        MailAccount account = new MailAccount();
        account.setHost("smtphz.qiye.163.com");
        account.setPort(994);
        account.setAuth(true);
        account.setSslEnable(true);
        account.setFrom("liuping@wondertek.com.cn");
        account.setUser("liuping@wondertek.com.cn");
        account.setPass("t5r4E#W@Q!");


        // 收件人
//        ArrayList<String> tos = CollUtil.newArrayList(
//                "person1@bbb.com",
//                "person2@bbb.com",
//                "person3@bbb.com",
//                "person4@bbb.com");

        //抄送人
//        ArrayList<String> ccs = CollUtil.newArrayList(
//                "person1@bbb.com",
//                "person2@bbb.com",
//                "person3@bbb.com",
//                "person4@bbb.com");

//        MailUtil.send(tos, "测试", "邮件来自Hutool群发测试", false);
        MailUtil.send(account, CollUtil.newArrayList("liupingtoday@163.com"), "测试", "邮件来自Hutool测试", false);

        return "success";
    }


}
