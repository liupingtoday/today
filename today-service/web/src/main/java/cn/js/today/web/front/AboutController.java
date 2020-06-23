package cn.js.today.web.front;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.js.today.common.CommonResponse;
import cn.js.today.service.cms.ArticleService;
import cn.js.today.service.cms.CategoryService;
import cn.js.today.service.cms.IndexService;
import cn.js.today.service.dto.cms.ArticleDTO;
import cn.js.today.service.dto.cms.ArticleDataDTO;
import cn.js.today.service.sys.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
@RequestMapping("/front/about")
public class AboutController {

    private final Logger log = LoggerFactory.getLogger(AboutController.class);

    @Autowired
    private ConfigService  configService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "list")
    public String list(Model model) {
        JSONArray allCategory = categoryService.getMenu();
        JSONObject indexJsonObject = indexService.getIndexParam();

//        String result = categoryService.getArticleListByCategoryId(categoryCode, pageNo, pageSize);
        CommonResponse<ArticleDTO> articleDTOCommonResponse = articleService.getArticleListByCategoryCode("A1015", 1, 12);
        List<ArticleDTO> articleDTOList = articleDTOCommonResponse.getData();
        ArticleDTO articleDTO = articleDTOList.get(0);
        String articleId = articleDTO.getId();
        String articleTitle = articleDTO.getTitle();
        log.info("111111111"+"articleId:"+ articleId);
        log.info("111111111"+"articleTitle:"+ articleTitle);
        //根据articleId查询文章详情
        ArticleDataDTO articleDataDTO = articleService.getArticleDataByArticleId(articleId);
        model.addAttribute("allCategory",allCategory);
        model.addAttribute("indexJsonObject",indexJsonObject);
        //文章详情内容
        model.addAttribute("articleData",articleDataDTO);
        model.addAttribute("articleTitle",articleTitle);
        log.info("111111111"+"allCategory:"+allCategory);
        log.info("111111111"+"articleData:"+articleDataDTO.toString());
        return "modules/cms/front/about";
    }

    @ApiOperation(value="添加医生信息", notes="")
    @RequestMapping(value = "queryArticleByCategoryCode")
    @ResponseBody
    public CommonResponse<ArticleDTO> queryArticleByCategoryId(String categoryCode, Integer pageNo, Integer pageSize) {

        CommonResponse<ArticleDTO> articleDTOCommonResponse = articleService.getArticleListByCategoryCode(categoryCode, pageNo, pageSize);

        log.info("1111111112222"+"articleDTOCommonResponse:"+ articleDTOCommonResponse);
        return articleDTOCommonResponse;
    }

}
