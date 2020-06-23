package cn.js.today.service.gantt;

import cn.js.today.domain.gantt.Role;
import cn.js.today.domain.gantt.Task;
import cn.js.today.repository.gantt.RoleRepository;
import cn.js.today.repository.gantt.TaskRepository;
import cn.js.today.service.dto.gantt.RoleDTO;
import cn.js.today.service.dto.gantt.TaskDTO;
import cn.js.today.service.mapper.RoleMapper;
import cn.js.today.service.mapper.TaskMapper;
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
 * @Since 2020-02-20
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-20
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Service
public class RoleService {

    private final Logger log = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    public Role saveRole(RoleDTO roleDTO){
        Role role = roleMapper.roleDTO2Role(roleDTO);
        return roleRepository.save(role);
    }

    public Role findByRoleId(Long roleId){
        Optional<Role> role = roleRepository.findOneByRoleId(roleId);
        return role.orElse(null);
    }

    /**
     *
     * @return
     */
    public List<Role> findAll(){
        return roleRepository.findAll();
    }

}
