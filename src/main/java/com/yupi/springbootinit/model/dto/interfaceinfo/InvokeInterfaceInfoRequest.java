package com.yupi.springbootinit.model.dto.interfaceinfo;

import lombok.Data;

/**
 * 接口调用请求
 */
@Data
public class InvokeInterfaceInfoRequest {
    private Long id;
    private String userRequestParams;
}
