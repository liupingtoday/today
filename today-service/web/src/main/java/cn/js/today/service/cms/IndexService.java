package cn.js.today.service.cms;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.js.today.domain.cms.Site;
import cn.js.today.domain.sys.Config;
import cn.js.today.repository.cms.CategoryRepository;
import cn.js.today.repository.sys.ConfigRepository;
import cn.js.today.service.dto.cms.CategoryDTO;
import cn.js.today.service.mapper.ConfigMapper;
import cn.js.today.service.mapper.MenuMapper;
import cn.js.today.service.sys.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-23
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-23
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Service
public class IndexService {

    private final Logger log = LoggerFactory.getLogger(IndexService.class);

    @Autowired
    private ConfigRepository configRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ConfigService configService;

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private MenuMapper menuMapper;


    public JSONArray getAllCategory(){

        Config czfytCategoryURL = configService.findByConfigKey("czfytCategoryURL");

        HttpResponse httpResponse = null;
        try {
            httpResponse = HttpRequest.get(czfytCategoryURL.getConfigValue()).timeout(2000).execute();
        } catch (Exception e) {
            log.info("error-----" + e.getMessage());
            return JSONUtil.createArray();
        }
        //请求不成功的情况
        if(!httpResponse.isOk()){
            return JSONUtil.createArray();
        }
        String httpResponseStr = httpResponse.body();
        log.info("httpResponseStr:" + httpResponseStr);
        JSONArray newJSONArray = JSONUtil.createArray();
        JSONArray jsonArray = JSONUtil.parseArray(httpResponseStr);
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            CategoryDTO categoryDTO = new CategoryDTO();
            JSONObject jsonObject = (JSONObject)iterator.next();
            String id = (String)jsonObject.get("id");
            categoryDTO.setCategoryId(id);//特殊处理，模型不匹配
            String categoryCode = (String)jsonObject.get("categoryCode");
            categoryDTO.setCategoryCode(categoryCode);
            String categoryName = (String)jsonObject.get("categoryName");
//            log.info("categoryName:" + categoryName);
            categoryDTO.setCategoryName(categoryName);
//            String status = (String)jsonObject.get("status");
            Integer treeLevel = (Integer)jsonObject.get("treeLevel");
            categoryDTO.setTreeLevel(treeLevel);
            String treeLeaf = (String)jsonObject.get("treeLeaf");
            categoryDTO.setTreeLeaf(treeLeaf);
            Integer treeSort = (Integer)jsonObject.get("treeSort");
            categoryDTO.setTreeSort(treeSort);
            String keywords = (String)jsonObject.get("keywords");
            categoryDTO.setKeywords(keywords);
            String description = (String)jsonObject.get("description");
            categoryDTO.setDescription(description);
//            String isTreeLeaf = (String)jsonObject.get("isTreeLeaf");
//            String isRoot = (String)jsonObject.get("isRoot");
//            String inMenu = (String)jsonObject.get("inMenu");
//            String inList = (String)jsonObject.get("inList");
//            String url = (String)jsonObject.get("url");
//            String image = (String)jsonObject.get("image");
//            String href = (String)jsonObject.get("href");
//            String target = (String)jsonObject.get("target");
            String moduleType = (String)jsonObject.get("moduleType");
            categoryDTO.setModuleType(moduleType);
//            String createDate = (String)jsonObject.get("createDate");
//            String updateDate = (String)jsonObject.get("updateDate");
//            String updateBy = (String)jsonObject.get("updateBy");
//            String createBy = (String)jsonObject.get("createBy");
//            JSONObject siteJSONObject = JSONUtil.parseObj(jsonObject.get("site"));
//            JSONObject siteJSONObject = (JSONObject)jsonObject.get("site");
            JSONObject siteJSONObject = (JSONObject)jsonObject.get("site");
//            log.info("siteJSONObject:" + siteJSONObject.toString());
            String siteId = (String)siteJSONObject.get("id");
            Site site = new Site();
            site.setSiteCode(siteId);
            String siteName = (String)siteJSONObject.get("siteName");
            site.setSiteName(siteName);
            String siteCode = (String)siteJSONObject.get("siteCode");
//            log.info("siteCode:" + siteCode);
            site.setSiteCode(siteCode);
            String siteRemarks = (String)siteJSONObject.get("remarks");
            site.setRemarks(siteRemarks);
            String siteTitle = (String)siteJSONObject.get("title");
            site.setTitle(siteTitle);
            String siteLogo = (String)siteJSONObject.get("logo");
            site.setLogo(siteLogo);
            String siteDomain = (String)siteJSONObject.get("domain");
            site.setDomain(siteDomain);
            String siteDescription = (String)siteJSONObject.get("description");
            site.setDescription(siteDescription);
            String siteKeywords = (String)siteJSONObject.get("keywords");
            site.setKeywords(siteKeywords);
            String siteCopyright = (String)siteJSONObject.get("copyright");
            site.setCopyright(siteCopyright);
            categoryDTO.setSite(site);
            JSONArray childListJSONArray = (JSONArray)jsonObject.get("childList");
            List<CategoryDTO> categoryList = new ArrayList<>();
            if(!StringUtils.isEmpty(childListJSONArray)){
                Iterator childListIterator = childListJSONArray.iterator();
                while (childListIterator.hasNext()){
                    CategoryDTO childListCategory = new CategoryDTO();
                    JSONObject childListObject = (JSONObject)childListIterator.next();
                    String childListId = (String)childListObject.get("id");
                    childListCategory.setCategoryId(childListId);
                    String childListCategoryName = (String)childListObject.get("categoryName");
                    childListCategory.setCategoryName(childListCategoryName);
                    String childListCategoryCode = (String)childListObject.get("categoryCode");
                    childListCategory.setCategoryCode(childListCategoryCode);
                    String childListTreeNames = (String)childListObject.get("treeNames");
                    Integer childListTreeLevel = (Integer)childListObject.get("treeLevel");
                    childListCategory.setTreeLevel(childListTreeLevel);
                    String childListTreeSorts = (String)childListObject.get("treeSorts");
                    String childListTreeLeaf = (String)childListObject.get("treeLeaf");
                    childListCategory.setTreeLeaf(childListTreeLeaf);
                    String childListUpdateDate = (String)childListObject.get("updateDate");
                    String childListCreateDate = (String)childListObject.get("createDate");
                    categoryList.add(childListCategory);
                    categoryDTO.setChildList(categoryList);
                }
            }
            newJSONArray.add(categoryDTO);
        }
        return newJSONArray;
    }

//    public Menu saveMenu(MenuDTO menuDTO){
//
//        Menu menu = menuMapper.menuDTO2Menu(menuDTO);
//        return menuRepository.save(menu);
//    }
//
//    public Menu findByMenuCode(String menuCode){
//
//        Optional<Menu> menu = menuRepository.findByMenuCode(menuCode);
//        return menu.orElse(null);
//    }
//
//    public Menu findById(Long id){
//        Optional<Menu> menu = menuRepository.findById(id);
//        return menu.orElse(null);
//    }

//    /**
//     *
//     * @param configKey
//     * @return
//     */
//    public Config findByConfigKey(String configKey){
//        return configRepository.findOneByConfigKey(configKey).orElse(null);
//    }
//
    /**
     *
     * @return
     */
//    public List<Menu> findAll(){
//        return menuRepository.findAll();
//    }

//    public void deleteMenu(Long menuCode){
//        menuRepository.deleteByMenuCode(menuCode);
//        return;
//    }

}
