package com.yupi.springbootinit.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.yupi.springbootinit.model.dto.userInterfaceInfo.UserInterfaceInfoQueryRequest;
import com.yupi.springbootinit.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 13491
* @description 针对表【user_interface_info(用户调用接口)】的数据库操作Service
* @createDate 2024-01-20 10:26:36
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean b);

    Wrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest);

    /**
     * 调用接口统计
     * @param interfaceId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceId, long userId);
}
