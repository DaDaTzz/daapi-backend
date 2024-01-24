package com.yupi.springbootinit.model.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 接口调用次数分析视图（脱敏）
 **/
@Data
public class InterfaceVO implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建人 id
     */
    private Long userId;


    /**
     * 接口名称
     */
    private String name;

    /**
     * 参数
     */
    private String params;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求方式
     */
    private String method;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String responseHeader;

    /**
     * 接口状态（0-关闭 1-开启）
     */
    private Integer status;


    /**
     * 总调用次数
     */
    private Integer totalNum;


    private static final long serialVersionUID = 1L;
}