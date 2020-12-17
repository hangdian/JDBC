package com.hg.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBeforeadvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        //额外功能
        System.out.println("控制事务");
        System.out.println("日志打印");

    }
}
