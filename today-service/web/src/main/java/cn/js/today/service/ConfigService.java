package cn.js.today.service;

import cn.js.today.repository.sys.ConfigRepository;
import cn.js.today.service.dto.ConfigDTO;
import cn.js.today.service.mapper.ConfigMapper;
import cn.js.today.domain.sys.Config;
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
 * @Since 2020-02-09
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-09
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Service
public class ConfigService {

    private final Logger log = LoggerFactory.getLogger(ConfigService.class);

    private final ConfigRepository configRepository;

    @Autowired
    private ConfigMapper configMapper;

    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }


    public Config saveConfig(ConfigDTO configDTO){
        Config config = configMapper.configDTO2Config(configDTO);
        return configRepository.save(config);
    }

    public Config findById(Long id){

        Optional<Config> config = configRepository.findById(id);
        return config.orElse(null);
    }

    /**
     *
     * @param configKey
     * @return
     */
    public Config findByConfigKey(String configKey){
        return configRepository.findOneByConfigKey(configKey).orElse(null);
    }

    /**
     *
     * @return
     */
    public List<Config> findAll(){
        return configRepository.findAll();
    }

}
