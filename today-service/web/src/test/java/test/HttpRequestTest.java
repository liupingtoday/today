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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.http.HttpUtil;
import org.junit.Ignore;
import org.junit.Test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.ssl.SSLSocketFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link HttpRequest}单元测试
 *
 * @author Looly
 *
 */
public class HttpRequestTest {

    private final Logger log = LoggerFactory.getLogger(HttpRequestTest.class);
    final String url = "http://jian.mam.miguvideo.com:48080/api/statistic/success/rate";

    @Test
    @Ignore
    public void getHttpswwTest() {
//        String body = HttpRequest.get("https://www.gjifa.com/pc/").execute().body();
//

        Map<String, Object> map = new HashMap<>();//存放参数

        HashMap<String, String> headers = new HashMap<>();//存放请求头，可以存放多个请求头
        headers.put("Cookie", "userInfo={%22userId%22:%22105007292%22%2C%22userToken%22:%224CB114889E98A766B3E8%22%2C%22clientId%22:%2279acd784-cbbb-4cae-8778-8723e001164b%22%2C%22carrierCode%22:%22CM%22%2C%22sname%22:%22158****4759%22%2C%22mobile%22:%2215851974759%22%2C%22picture%22:%22http://img.cmvideo.cn:8080/publish/voms2/uic_service/picture/userImage/543/626/5181.jpg%22%2C%22sex%22:%22%22%2C%22ssotoken%22:%22STnid0000011581005944062zCJzMH0qlQov4KuFhe68XaiofFcx4GI0%22%2C%22clientProvinceCode%22:%22250%22%2C%22clientCityId%22:%220519%22%2C%22sign%22:%22CFFD097928203B88E4600947D6B1393D%22%2C%22userInfo%22:%22{%5C%22userId%5C%22:%5C%22105007292%5C%22%2C%5C%22userNum%5C%22:%5C%228615851974759%5C%22%2C%5C%22mobile%5C%22:%5C%2215851974759%5C%22%2C%5C%22areaId%5C%22:%5C%22250%5C%22%2C%5C%22cityId%5C%22:%5C%220519%5C%22%2C%5C%22carrierCode%5C%22:%5C%22CM%5C%22%2C%5C%22passId%5C%22:%5C%223674136819957%5C%22%2C%5C%22userToken%5C%22:%5C%224CB114889E98A766B3E8%5C%22%2C%5C%22expiredOn%5C%22:%5C%221583597944787%5C%22}%22}; UserInfo=105007292|4CB114889E98A766B3E8; WT_FPC=id=254f5f9bca8d3cbbfe41581005757816:lv=1581005946752:ss=1581005757816; accessToken=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwd2Rfc3RhdHVzIjowLCJ1c2VyX2lkIjoxMDAzMzYwMSwiYWRkaXRpb25hbF9pbmZvIjp7fSwidXNlcl9uYW1lIjoieWZ6eDAwM2xpdXBpbmciLCJ1c2VyX3NvdXJjZSI6IjEiLCJleHAiOjE1ODEwODAwNTEsImp0aSI6ImM0M2M4ZjA5LThmNTYtNDczZi04ODI3LTJiNTkzMTkzYmQ0YiIsImNsaWVudF9pZCI6ImlubmVyQ2xpZW50In0.HQWtQ5yid4xxUqY7_2x9f9v_afBDsMzN4wYouVsV7DXf5rGBF2-hNbiJXG6Lx3yPDybgTCKRE4L8hup-n2Zr2im5Wdgil9W_ExU8pLOH22egWDnpZ0BaaKuEgoEAflD20xi1mzkRpCibojrb4mI9Q7A8owV0zi3Cdo607Z7FR94; refreshToken=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwd2Rfc3RhdHVzIjowLCJ1c2VyX2lkIjoxMDAzMzYwMSwiYWRkaXRpb25hbF9pbmZvIjp7fSwidXNlcl9uYW1lIjoieWZ6eDAwM2xpdXBpbmciLCJ1c2VyX3NvdXJjZSI6IjEiLCJhdGkiOiJjNDNjOGYwOS04ZjU2LTQ3M2YtODgyNy0yYjU5MzE5M2JkNGIiLCJleHAiOjE1ODEwODI0NTEsImp0aSI6IjI1Zjg0NzI3LTAzNmYtNDM0ZS1hNzY0LTI1OWY1NmRiNmQ3ZSIsImNsaWVudF9pZCI6ImlubmVyQ2xpZW50In0.Dd4dpiZ-WQuhc8VSOYTdI6boF0LqphrZ4zBnlpgs5ZfG9MiDegCtZh9lyAN673ba4XvNEEDosaSWeJwunCdKclCk46OEGpzHlFyhCqRgJGHdap-gb6uvVHrw_jULhMR-fev6DNNDbyNnVh-IgfkmkZjA711LjiYB4P_QUvicMgA");
//发送get请求并接收响应数据
        String result= HttpUtil.createGet(url).addHeaders(headers).form(map).execute().body();
//发送post请求并接收响应数据
//        String result= HttpUtil.createPost(url).addHeaders(headers).form(map).execute().body();
//        Console.log(result);
        log.info(result);
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