package com.huyan.eurekaclient.service;

import com.huyan.eurekaclient.entity.InterfaceUsage;

import java.util.List;

/**
 * @author by hu_yan on 2018/12/14.
 */
public interface InterfaceUsageService {

    /**
     * 获取接口调用统计
     */
    List<InterfaceUsage> getUsage(String uid);
}
