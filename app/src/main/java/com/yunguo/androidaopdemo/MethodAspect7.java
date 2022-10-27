package com.yunguo.androidaopdemo;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author : Axes
 * create at:  10/27/22  10:47 AM
 * @description: 示例基本用法 带返回值的织入
 */
@Aspect
public class MethodAspect7 {
    private static final String TAG = "MethodAspect7";

    @Pointcut("execution(* com.yunguo.androidaopdemo.Animal.getName(..))")
    public void callMethod() {
    }

    @After("callMethod()")
    public void beforeMethodCall(JoinPoint joinPoint) {
        Log.e(TAG, "After->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }

    //必须声明返回值 可以不精确
    @Around("callMethod()")
    public Object aroundMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "around->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
        Object proceed = joinPoint.proceed();
        Log.e(TAG, "around proceed->" + proceed);
        return proceed;
    }
}
