package com.huyan.eurekaclient.controller;

import com.huyan.eurekaclient.entity.InterfaceUsage;
import com.huyan.eurekaclient.service.InterfaceUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author by hu_yan on 2018/12/14.
 */
@RestController
@RequestMapping("/interface")
public class InterfaceUsageController {

    @Autowired
    InterfaceUsageService interfaceUsageService;

    @GetMapping("")
    public List<InterfaceUsage> getUsage(@RequestParam(required = false) String uid){
        return interfaceUsageService.getUsage(uid);
    }
}
