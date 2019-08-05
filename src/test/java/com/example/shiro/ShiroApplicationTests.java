package com.example.shiro;

import com.example.shiro.repository.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroApplicationTests {

    @Resource
    private RoleRepository roleRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRoles(){
//        List<UserRoleView> userRoleViews = roleRepository.findUserRole(6L);
//        System.out.println(userRoleViews);
    }

}
