package cn.js.today.service.sys;

import cn.js.today.domain.sys.Menu;
import cn.js.today.repository.sys.ConfigRepository;
import cn.js.today.repository.sys.MenuRepository;
import cn.js.today.service.dto.cms.MenuDTO;
import cn.js.today.service.mapper.ConfigMapper;
import cn.js.today.service.mapper.MenuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
public class MenuService {

    private final Logger log = LoggerFactory.getLogger(MenuService.class);

    private final ConfigRepository configRepository;

    private final MenuRepository menuRepository;

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private MenuMapper menuMapper;


    public MenuService(ConfigRepository configRepository, MenuRepository menuRepository) {
        this.configRepository = configRepository;
        this.menuRepository = menuRepository;
    }

    public Menu saveMenu(MenuDTO menuDTO){

        Menu menu = menuMapper.menuDTO2Menu(menuDTO);
        return menuRepository.save(menu);
    }

    public Menu findByMenuCode(String menuCode){

        Optional<Menu> menu = menuRepository.findByMenuCode(menuCode);
        return menu.orElse(null);
    }

    public Menu findByMenuType(String menuType){
        Optional<Menu> menu = menuRepository.findByMenuType(menuType);
        return menu.orElse(null);
    }

    public Menu findById(Long id){
        Optional<Menu> menu = menuRepository.findById(id);
        return menu.orElse(null);
    }

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
    public List<Menu> findAll(){
        return menuRepository.findAll();
    }

//    public void deleteMenu(Long menuCode){
//        menuRepository.deleteByMenuCode(menuCode);
//        return;
//    }

}
