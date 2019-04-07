package com.github.zk.customannotation.controller;

import com.github.zk.customannotation.annotation.MyAnnotation;
import com.github.zk.customannotation.service.IDemo;
import com.github.zk.customannotation.service.impl.DemoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaokai
 * @date 2019/4/7 下午2:40
 */
@RestController
public class DemoController {

    @Autowired
    private IDemo iDemo;

    @RequestMapping("/methodOne")
    public void methodOne(@RequestParam String... args) {
        iDemo.methodOne(args);
    }

    @RequestMapping("/methodTwo")
    public void methodTwo() {
        iDemo.methodTwo();
    }
}
