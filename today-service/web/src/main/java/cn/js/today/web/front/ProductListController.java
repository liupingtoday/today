package cn.js.today.web.front;

import cn.hutool.core.util.ObjectUtil;
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
import org.springframework.web.bind.annotation.PathVariable;
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


    @RequestMapping(value = "/{categoryCode}")
    public String list(@PathVariable String categoryCode, Integer pageNo, Integer pageSize, Model model)  {
        log.info("----------------categoryCode:"+ categoryCode + "pageNo:"+ pageNo + "pageSize:" + pageSize);

        if(ObjectUtil.isNull(pageNo)){
            pageNo = 1;
        }
        if(ObjectUtil.isNull(pageSize)){
            pageSize = 12;
        }
        JSONArray allCategory = categoryService.getMenu();
        JSONObject indexJsonObject = indexService.getIndexParam();

        CommonResponse<ArticleDTO> articleDTOCommonResponse = articleService.getArticleListByCategoryCode(categoryCode, pageNo, pageSize);

        List<ArticleDTO>   articleDTOList = articleDTOCommonResponse.getData();
        JSONArray jsonArray = JSONUtil.parseArray(articleDTOList);
        //根据articleId查询文章详情
        model.addAttribute("allCategory",allCategory);
        model.addAttribute("indexJsonObject",indexJsonObject);
        //文章详情内容
        model.addAttribute("articleDTOList", jsonArray);
        model.addAttribute("currentPage", articleDTOCommonResponse.getCurrentPage());
        model.addAttribute("totalPage", articleDTOCommonResponse.getTotalPage());
        model.addAttribute("totalCount", articleDTOCommonResponse.getTotalCount());
        log.info("111111111"+"articleDTOList:"+ jsonArray);
        return "modules/cms/front/productList";
    }

    @RequestMapping(value = "getProductListPagable")
    @ResponseBody
    public String getProductListPagable(String categoryCode, Integer pageNo, Integer pageSize)  {
        log.info("1222222222222222222"+"categoryCode:"+ categoryCode);
        CommonResponse<ArticleDTO> articleDTOCommonResponse = articleService.getArticleListByCategoryCode(categoryCode, pageNo, pageSize);
        //根据articleId查询文章详情
        String returnResult = JSONUtil.toJsonPrettyStr(articleDTOCommonResponse);
        log.info("111111111"+"returnResult:"+ returnResult);
        return returnResult;
    }


}
