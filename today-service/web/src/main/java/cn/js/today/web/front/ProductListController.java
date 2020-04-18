package cn.js.today.web.front;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.js.today.common.CommonResponse;
import cn.js.today.service.cms.ArticleService;
import cn.js.today.service.cms.CategoryService;
import cn.js.today.service.cms.IndexService;
import cn.js.today.service.dto.cms.ArticleDTO;
import cn.js.today.service.dto.cms.ArticleDataDTO;
import cn.js.today.service.sys.ConfigService;
import cn.js.today.utils.JSONUtils;
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
 * @Since 2019-12-14
 * @UpdateUser: liuping
 * @UpdateDate: 2019-12-14
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Controller
@RequestMapping("/front/productList")
public class ProductListController {

    private final Logger log = LoggerFactory.getLogger(ProductListController.class);

    @Autowired
    private ConfigService  configService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private IndexService indexService;

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "list")
    public String list(Model model)  {
        JSONArray allCategory = categoryService.getMenu();
        JSONObject indexJsonObject = indexService.getIndexParam();

        CommonResponse<ArticleDTO> articleDTOCommonResponse = articleService.getArticleListByCategoryCode("A1005", 1, 12);
        List<ArticleDTO>   articleDTOList = articleDTOCommonResponse.getData();
        JSONArray jsonArray = JSONUtil.parseArray(articleDTOList);
        //根据articleId查询文章详情
        model.addAttribute("allCategory",allCategory);
        model.addAttribute("indexJsonObject",indexJsonObject);
        //文章详情内容
//        model.addAttribute("articleData",articleDataDTO);
        model.addAttribute("articleDTOList", jsonArray);
        log.info("111111111"+"articleDTOList:"+ jsonArray);
//        log.info("111111111"+"articleData:"+articleDataDTO.toString());
        return "modules/cms/front/productList";
    }

    @RequestMapping(value = "getProductListPagable")
    @ResponseBody
    public String getProductListPagable(Integer pageNo, Integer pageSize)  {
        JSONArray allCategory = categoryService.getMenu();
        JSONObject indexJsonObject = indexService.getIndexParam();

        CommonResponse<ArticleDTO> articleDTOCommonResponse = articleService.getArticleListByCategoryCode("A1005", pageNo, pageSize);
//        List<ArticleDTO>   articleDTOList = articleDTOCommonResponse.getData();
//        JSONArray jsonArray = JSONUtil.parseArray(articleDTOList);
        //根据articleId查询文章详情
        String returnResult = JSONUtil.toJsonPrettyStr(articleDTOCommonResponse);
        log.info("111111111"+"returnResult:"+ returnResult);
        return returnResult;
    }


}
