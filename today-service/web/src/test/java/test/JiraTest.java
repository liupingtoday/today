package test;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author:
 * @Since
 * @UpdateUser:
 * @UpdateDate:
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.ssl.SSLSocketFactoryBuilder;
import cn.js.today.service.jira.JiraService;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link HttpRequest}单元测试
 *
 * @author Looly
 *
 */
public class JiraTest {

    private final Logger log = LoggerFactory.getLogger(JiraTest.class);
    final String url = "http://jian.mam.miguvideo.com:48080/api/statistic/success/rate";

    @Autowired
    JiraService jiraService;

    @Test
    @Ignore
    public void getWorklogByUserNameTest() {

//        jiraService.getWorklogByUserName("刘平");

    }


    @Test
    @Ignore
    public void getHttpsTest() {
        String body = HttpRequest.get("https://www.gjifa.com/pc/").execute().body();
        Console.log(body);
    }

    @Test
    @Ignore
    public void getCookiesTest() {
        // 检查在Connection关闭情况下Cookie是否可以正常获取
        HttpResponse res = HttpRequest.get("https://www.oschina.net/").execute();
        String body = res.body();
        Console.log(res.getCookies());
    }

    @Test
    @Ignore
    public void getWithParamsTest() {
        String url = "http://gc.ditu.aliyun.com/geocoding?ccc=你好";

        HttpRequest request = HttpRequest.get(url).setEncodeUrlParams(true).body("a=乌海");
        String body = request.execute().body();
        Console.log(body);

//		String body2 = HttpUtil.get(url);
//		Console.log(body2);
    }

    @Test
    @Ignore
    public void asyncHeadTest() {
        HttpResponse response = HttpRequest.head(url).execute();
        Map<String, List<String>> headers = response.headers();
        Console.log(headers);
        Console.log(response.body());
    }

    @Test
    @Ignore
    public void asyncGetTest() {
        TimeInterval timer = DateUtil.timer();
        HttpResponse body = HttpRequest.get(url).charset("GBK").executeAsync();
        long interval = timer.interval();
        timer.restart();
        Console.log(body.body());
        long interval2 = timer.interval();
        Console.log("Async response spend {}ms, body spend {}ms", interval, interval2);
    }

    @Test
    @Ignore
    public void syncGetTest() {
        TimeInterval timer = DateUtil.timer();
        HttpResponse body = HttpRequest.get(url).charset("GBK").execute();
        long interval = timer.interval();
        timer.restart();
        Console.log(body.body());
        long interval2 = timer.interval();
        Console.log("Async response spend {}ms, body spend {}ms", interval, interval2);
    }

    @Test
    @Ignore
    public void customGetTest() {
        // 自定义构建HTTP GET请求，发送Http GET请求，针对HTTPS安全加密，可以自定义SSL
        HttpRequest request = HttpRequest.get(url)
                // 自定义返回编码
                .charset(CharsetUtil.CHARSET_GBK)
                // 禁用缓存
                .disableCache()
                // 自定义SSL版本
                .setSSLProtocol(SSLSocketFactoryBuilder.TLSv12);
        Console.log(request.execute().body());
    }

    @Test
    @Ignore
    public void getDeflateTest() {
        String res = HttpRequest.get("https://comment.bilibili.com/67573272.xml")
                .execute().body();
        Console.log(res);
    }
}