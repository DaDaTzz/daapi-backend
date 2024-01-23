package com.yupi.springbootinit.model.dto.userInterfaceInfo;

import lombok.Data;

@Data
public class InvokeCountRequest {
    private long userId;
    private long interfaceId;
}
