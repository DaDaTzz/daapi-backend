package com.yupi.springbootinit.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.constant.CommonConstant;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.springbootinit.exception.ThrowUtils;
import com.yupi.springbootinit.model.dto.userInterfaceInfo.UserInterfaceInfoQueryRequest;
import com.yupi.springbootinit.model.entity.InterfaceInfo;
import com.yupi.springbootinit.model.entity.UserInterfaceInfo;
import com.yupi.springbootinit.service.UserInterfaceInfoService;
import com.yupi.springbootinit.mapper.UserInterfaceInfoMapper;
import com.yupi.springbootinit.utils.SqlUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 13491
 * @description 针对表【user_interface_info(用户调用接口)】的数据库操作Service实现
 * @createDate 2024-01-20 10:26:36
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        long userId = userInterfaceInfo.getUserId();
        long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        int totalNum = userInterfaceInfo.getTotalNum();
        int leftNum = userInterfaceInfo.getLeftNum();

        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(userId <= 0, new BusinessException(ErrorCode.PARAMS_ERROR));
            ThrowUtils.throwIf(interfaceInfoId <= 0, new BusinessException(ErrorCode.PARAMS_ERROR));
            ThrowUtils.throwIf(totalNum < 0, new BusinessException(ErrorCode.PARAMS_ERROR));
            ThrowUtils.throwIf(leftNum < 0, new BusinessException(ErrorCode.PARAMS_ERROR));
        }
        // 有参数则校验

    }

    @Override
    public Wrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest) {
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        if (userInterfaceInfoQueryRequest == null) {
            return queryWrapper;
        }
        Long id = userInterfaceInfoQueryRequest.getId();
        Long userId = userInterfaceInfoQueryRequest.getUserId();
        Long interfaceInfoId = userInterfaceInfoQueryRequest.getInterfaceInfoId();
        Integer totalNum = userInterfaceInfoQueryRequest.getTotalNum();
        Integer leftNum = userInterfaceInfoQueryRequest.getLeftNum();
        Integer status = userInterfaceInfoQueryRequest.getStatus();
        String sortField = userInterfaceInfoQueryRequest.getSortField();
        String sortOrder = userInterfaceInfoQueryRequest.getSortOrder();

        // 拼接查询条件
        queryWrapper.eq(id != null && id > 0, "id", id);
        queryWrapper.eq(status != null && (status == 0 || status == 1), "status", status);
        queryWrapper.eq(userId != null && userId > 0, "user_id", userId);
        queryWrapper.eq(totalNum != null && userId >= 0, "total_num", userId);
        queryWrapper.eq(leftNum != null && leftNum >= 0, "left_num", userId);
        queryWrapper.eq(interfaceInfoId != null && userId > 0, "user_id", userId);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }

    @Override
    public boolean invokeCount(long interfaceId, long userId) {
        // 校验参数
        ThrowUtils.throwIf(interfaceId <= 0 || userId <= 0, new BusinessException(ErrorCode.PARAMS_ERROR));
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interface_info_id", interfaceId);
        updateWrapper.eq("user_id", userId);
        updateWrapper.gt("left_num", 0);
        updateWrapper.setSql("left_num = left_num - 1, total_num = total_num + 1");
        return this.update(updateWrapper);
    }
}




