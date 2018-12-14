package com.huyan.eurekaclient.service.impl;

import com.huyan.eurekaclient.entity.InterfaceUsage;
import com.huyan.eurekaclient.mapper.InterfaceUsageMapper;
import com.huyan.eurekaclient.service.InterfaceUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author by hu_yan on 2018/12/14.
 */
@Component
public class InterfaceUsageServiceImpl implements InterfaceUsageService {

    @Autowired
    InterfaceUsageMapper interfaceUsageMapper;

    @Override
    public List<InterfaceUsage> getUsage(String uid) {
        return interfaceUsageMapper.getUsage(uid);
    }
}
