package cn.js.today.service.gantt;

import cn.js.today.domain.gantt.Resource;
import cn.js.today.repository.gantt.ResourceRepository;
import cn.js.today.service.dto.gantt.ResourceDTO;
import cn.js.today.service.mapper.ResourceMapper;
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
 * @Since 2020-02-21
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-21
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Service
public class ResourceService {

    private final Logger log = LoggerFactory.getLogger(ResourceService.class);

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceMapper resourceMapper;

    public Resource saveResource(ResourceDTO resourceDTO){
        Resource resource = resourceMapper.resourceDTO2Resource(resourceDTO);
        return resourceRepository.save(resource);
    }

    public Resource findByResourceId(Long resourceId){
        Optional<Resource> resource = resourceRepository.findOneByResourceId(resourceId);
        return resource.orElse(null);
    }

    /**
     *
     * @return
     */
    public List<Resource> findAll(){
        return resourceRepository.findAll();
    }

}
