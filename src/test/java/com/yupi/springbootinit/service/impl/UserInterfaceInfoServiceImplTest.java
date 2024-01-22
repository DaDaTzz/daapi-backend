package com.yupi.springbootinit.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInterfaceInfoServiceImplTest {
    @Resource
    private UserInterfaceInfoServiceImpl userInterfaceInfoService;

    @Test
    void invokeCount() {
        boolean res = userInterfaceInfoService.invokeCount(1, 1);
        Assertions.assertEquals(true, res);
    }
}