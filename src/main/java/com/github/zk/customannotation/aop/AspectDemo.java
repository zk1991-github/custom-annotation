package com.github.zk.customannotation.aop;

import com.github.zk.customannotation.annotation.MyAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhaokai
 * @date 2019/4/7 下午2:59
 */
@Aspect
@Component
public class AspectDemo {
    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.github.zk.customannotation.service.impl.*.*(..))")'
     */
    @Pointcut(value = "@annotation(com.github.zk.customannotation.annotation.MyAnnotation)")
    public void pointCutMethod() {}

    @Around("pointCutMethod()")
    public void doAround(ProceedingJoinPoint joinPoint) {
        System.out.println("进入切面");
        long stime = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long etime = System.currentTimeMillis();
        long time = etime - stime;
        System.out.println("使用时间【"+ time +"】毫秒");

        doDeal(joinPoint);
    }

    public void doDeal(JoinPoint joinPoint){
        String methodDesc = "";
        //获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取方法
        Method method = signature.getMethod();
        //获取自定义注解
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        if (annotation != null) {
            methodDesc = annotation.name();
        }
        System.out.println("调用的方法描述：【"+ methodDesc +"】");
    }
}
