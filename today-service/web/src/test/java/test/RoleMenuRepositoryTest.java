package test;

import cn.js.today.domain.sys.RoleMenu;
import cn.js.today.domain.sys.RoleMenuUPK;
import cn.js.today.repository.sys.RoleMenuRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liupingtoday
 * @Since 2020-03-23
 * @UpdateUser: liupingtoday
 * @UpdateDate: 2020-03-23
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleMenuRepositoryTest {

    @Resource
    private RoleMenuRepository roleMenuRepository;

//    @Test
//    public void testInsert(){
//
//        RoleMenuUPK upk = RoleMenuUPK.builder().roleCode("11").menuCode("Rose Duan").build();
//        RoleMenu student = RoleMenu.builder().roleMenuUPK(upk).build();
//
//        roleMenuRepository.save(student);
//    }

}
