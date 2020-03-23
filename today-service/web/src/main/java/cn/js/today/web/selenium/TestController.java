package cn.js.today.web.selenium;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.js.today.domain.sys.Config;
import cn.js.today.domain.sys.User;
import cn.js.today.service.dto.jira.JiraIssueDTO;
import cn.js.today.service.dto.sys.ConfigDTO;
import cn.js.today.service.jira.JiraService;
import cn.js.today.service.sys.ConfigService;
import cn.js.today.service.sys.UserService;
import cn.js.today.web.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-03-09
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-09
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@RestController
@RequestMapping("/api")
public class TestController {

    private final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private ConfigService configService;

    @Autowired
    private JiraService jiraService;

    @Autowired
    private UserService userService;

    private static final String ENTITY_NAME = "jira";

    @Value("${spring.application.name}")
    private String applicationName;


    /**
     *
     * @param
     * @return
     */
    @GetMapping("/test")
    public ResponseEntity<String> getConfig() {
//        Config config = configService.findById(id);
        System.setProperty("webdriver.ie.driver", "C:/data/softwares/selenium-driver/IEDriverServer.exe"); // 必须加入
        WebDriver driver = new InternetExplorerDriver();  // Internet Explorer浏览器
//        System.setProperty("webdriver.chrome.driver", "C:/data/softwares/selenium-driver/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();    //Chrome浏览器

        driver.get("https://4a.cmvideo.cn/login_loginV.action");
        driver.manage().window().maximize();
//        log.info("```111111223333:  " + driver.getPageSource());


        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        String loginUserName = "wd_liuping";
        String loginPassword = "cde3CDE#";
//        String js="document.getElementsById(\"textarea\")[0].value=\"'+lb_cert+\"'\"";

        // 利用JS来输入内容
        waitTime(5000);
        String text = "input by js";
        String usernameJS = "var sum = document.getElementById('username'); sum.value='" + loginUserName + "';";
        String passwordJS = "var sum = document.getElementById('password'); sum.value='" + loginPassword + "';";
        ((JavascriptExecutor) driver).executeScript(usernameJS);
        ((JavascriptExecutor) driver).executeScript(passwordJS);

//        driver.execute_script(js)
//        setClipboardData(loginUserName);
//        usernameInput.sendKeys(loginUserName);
//        passwordInput.sendKeys(loginPassword);
//        search_text.clear();
//        search_text.sendKeys("Selenium");
//        search_button.click();


//        driver.findElementById("kw").sendKeys(Keys.chord(Keys.CONTROL, "a"));
//        driver.findElementById("kw").sendKeys(Keys.chord(Keys.CONTROL, "c"));

//        passwordInput.submit();
//        driver.manage().window().setSize(new Dimension(480, 800));
//        Thread.sleep(2000);


//        driver.quit();



        return ResponseEntity.ok().body("ok");
    }

    static public void waitTime(int time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    private void captureScreenshot(String fileName,  WebDriver driver) {
        String imagePath = System.getProperty("user.dir") + File.separator
                + fileName + ".png";
        try {
            byte[] decodedScreenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            FileOutputStream fos = new FileOutputStream(new File(imagePath));
            fos.write(decodedScreenshot);
            fos.close();
            System.out.println("截图保存至" + imagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
    }

}
