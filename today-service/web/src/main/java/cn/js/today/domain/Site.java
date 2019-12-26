package cn.js.today.domain;

import javax.persistence.*;
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
@Entity
@Table(name = "cc_site")
public class Site {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 	// 栏目编码

    @Column(name = "site_code")
    private String siteCode; 	// 站点编码

    @Column(name = "site_name")
    private String siteName; 	// 站点名称

    @Column(name = "title")
    private String title; 		// 站点标题

    @Column(name = "logo")
    private String logo; 		// 站点Logo

    @Column(name = "domain")
    private String domain; 		// 站点域名

    @Column(name = "keywords")
    private String keywords; 	// 关键字

    @Column(name = "description")
    private String description; // 描述

    @Column(name = "theme")
    private String theme; 		// 主题

    @Column(name = "copyright")
    private String copyright; 	// 版权信息

//    private List<String> categoryCodes;		//某角色下某站点下授权的栏目id集合
//
//    private List<Category> categoryList;	//某站点下所有栏目集合

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

}
