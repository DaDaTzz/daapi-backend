package com.yupi.springbootinit;

import com.da.daapiclientsdk.client.DaApiClient;
import com.da.daapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 主类测试
 *
 * 
 * 
 */
@SpringBootTest
class MainApplicationTests {


    @Resource
    private DaApiClient daApiClient;

    @Test
    void test(){
        daApiClient.getNameByGet("xiangda");
        User user = new User();
        user.setUsername("xiangda");
        daApiClient.getUsernameByPost(user);
    }




}
