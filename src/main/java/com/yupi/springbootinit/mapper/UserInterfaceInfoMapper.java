package com.yupi.springbootinit.mapper;

import com.yupi.springbootinit.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 13491
* @description 针对表【user_interface_info(用户调用接口)】的数据库操作Mapper
* @createDate 2024-01-20 10:26:36
* @Entity com.yupi.springbootinit.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> getInvokeCountTOPList(long limit);
}




