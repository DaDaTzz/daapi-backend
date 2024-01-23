package com.yupi.springbootinit.model.dto.interfaceinfo;

import lombok.Data;

/**
 * 校验接口是否存在请求
 */
@Data
public class CheckInterfaceInfoRequest {
    private String url;
    private String method;
}
