package com.github.zk.customannotation.service.impl;

import com.github.zk.customannotation.annotation.MyAnnotation;
import com.github.zk.customannotation.service.IDemo;
import org.springframework.stereotype.Service;

/**
 * @author zhaokai
 * @date 2019/4/7 下午5:20
 */
@Service
public class DemoImpl implements IDemo {

    @MyAnnotation(name = "methodOne相关处理demo")
    @Override
    public void methodOne(String... args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("处理DemoImpl.methodOne()相关业务,接收到的参数【");
        for (int i=0;i<args.length-1;i++) {
            stringBuffer.append(args[i] + ",");
        }
        stringBuffer.append(args[args.length-1] + "】");
        System.out.println(stringBuffer);
    }

    @Override
    public void methodTwo() {
        System.out.println("处理DemoImpl.methodTwo()相关业务");
    }
}
