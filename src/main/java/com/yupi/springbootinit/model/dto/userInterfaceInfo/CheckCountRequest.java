package com.yupi.springbootinit.model.dto.userInterfaceInfo;

import lombok.Data;

/**
 * 检查接口调用次数请求
 */
@Data
public class CheckCountRequest {
    private long userId;
    private long interfaceId;
}
