package com.yupi.springbootinit.model.dto.user;

import lombok.Data;

/**
 * 校验权限请求
 */
@Data
public class CheckPowerRequest {
    private String accessKey;
}
