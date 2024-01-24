package com.yupi.springbootinit.controller;

import com.yupi.springbootinit.common.BaseResponse;
import com.yupi.springbootinit.common.ResultUtils;
import com.yupi.springbootinit.mapper.UserInterfaceInfoMapper;
import com.yupi.springbootinit.model.entity.InterfaceInfo;
import com.yupi.springbootinit.model.entity.UserInterfaceInfo;
import com.yupi.springbootinit.model.vo.InterfaceVO;
import com.yupi.springbootinit.service.InterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;
    @Resource
    private InterfaceInfoService interfaceInfoService;

    @GetMapping("/interface/invoke/top")
    public BaseResponse<List<InterfaceVO>> getInvokeCountTOPList(){
        List<UserInterfaceInfo> invokeCountTOPList = userInterfaceInfoMapper.getInvokeCountTOPList(3);
        ArrayList<InterfaceVO> interfaceVOS = new ArrayList<>();
        for (UserInterfaceInfo userInterfaceInfo : invokeCountTOPList) {
            InterfaceInfo interfaceInfo = interfaceInfoService.getById(userInterfaceInfo.getInterfaceInfoId());
            InterfaceVO interfaceVO = new InterfaceVO();
            BeanUtils.copyProperties(interfaceInfo, interfaceVO);
            interfaceVO.setTotalNum(userInterfaceInfo.getTotalNum());
            interfaceVOS.add(interfaceVO);
        }
        return ResultUtils.success(interfaceVOS);
    }




}
