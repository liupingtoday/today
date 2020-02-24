package cn.js.today.service.mapper;

import cn.js.today.common.idgen.IdGenerate;
import cn.js.today.domain.sys.Menu;
import cn.js.today.service.dto.cms.MenuDTO;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

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
@Service
public class MenuMapper {

    /**
     *
     * @param menuDTO
     * @return
     */
    public Menu menuDTO2Menu(MenuDTO menuDTO){

        if(menuDTO == null){
            return  null;
        } else {
            Menu menu = new Menu();
            menu.setId(menuDTO.getId());
            menu.setMenuCode(IdGenerate.nextId());
            menu.setMenuName(menuDTO.getMenuName());
            menu.setMenuTitle(menuDTO.getMenuTitle());
            menu.setMenuHref(menuDTO.getMenuHref());
            menu.setMenuType(menuDTO.getMenuType());
            menu.setMenuIcon(menuDTO.getMenuIcon());
            menu.setIsShow(menuDTO.getIsShow());
            menu.setMenuColor(menuDTO.getMenuColor());
            menu.setMenuTarget(menuDTO.getMenuTarget());
            menu.setSysCode(menuDTO.getSysCode());
            menu.setPermission(menuDTO.getPermission());
            menu.setStatus(menuDTO.getStatus());
            menu.setModuleCodes(menuDTO.getModuleCodes());
            menu.setParentCode(menuDTO.getParentCode());
            menu.setParentCodes(menuDTO.getParentCodes());
            menu.setTreeLeaf(menuDTO.getTreeLeaf());
            menu.setTreeLevel(menuDTO.getTreeLevel());
            menu.setTreeNames(menuDTO.getTreeNames());
            menu.setTreeSort(menuDTO.getTreeSort());
            menu.setTreeSorts(menuDTO.getTreeSorts());
            menu.setRemarks(menuDTO.getRemarks());
            menu.setCreatedBy("");
            menu.setCreatedTime(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
            menu.setUpdatedBy("");
            menu.setUpdatedTime(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
            return menu;
        }

    }
}
