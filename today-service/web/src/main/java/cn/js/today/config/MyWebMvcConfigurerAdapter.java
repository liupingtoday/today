package cn.js.today.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-06
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-06
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    /**
     * 以前要访问一个页面需要先创建个Controller控制类，在写方法跳转到页面
     * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/toLogin就跳转到login.html页面了
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/api/test").setViewName("test");
        registry.addViewController("/api/index").setViewName("/modules/cms/front/index");
//        registry.addViewController("/tologin").setViewName("login");
//        registry.addViewController("/welcome").setViewName("welcome");
//        registry.addViewController("/error/errordeal").setViewName("error/errordealogin");
//        registry.addViewController("/error/unauthorized").setViewName("error/unauthorized");
//        registry.addViewController("/main").setViewName("main");
        super.addViewControllers(registry);
    }

}
