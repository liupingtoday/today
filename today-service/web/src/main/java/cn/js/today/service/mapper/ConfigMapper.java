package cn.js.today.service.mapper;

import cn.js.today.service.dto.sys.ConfigDTO;
import cn.js.today.domain.sys.Config;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-09
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-09
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Service
public class ConfigMapper {

    /**
     *
     * @param configDTO
     * @return
     */
    public Config configDTO2Config(ConfigDTO configDTO){

        if(configDTO == null){
            return  null;
        } else {
            Config config = new Config();
//            config.setId(configDTO.getId());
            config.setConfigKey(configDTO.getConfigKey());
            config.setConfigValue(configDTO.getConfigValue());
            config.setConfigName(configDTO.getConfigName());
            config.setIsSys(configDTO.getIsSys());
            config.setCreatedBy("");
            config.setCreatedTime(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
            config.setUpdatedBy("");
            config.setUpdatedTime(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
            config.setRemarks(configDTO.getRemarks());
            return config;
        }

    }
}
