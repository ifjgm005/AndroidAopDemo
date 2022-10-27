package com.yunguo.androidaopdemo;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author : Axes
 * create at:  10/27/22  10:35 AM
 * @description: 示例基本用法 execution vs. call
 */
@Aspect
public class MethodAspect2 {
    private static final String TAG = "MethodAspect2";

    @Pointcut("execution(* com.wandering.sample.aspectj.Animal.fly(..))")
    public void callMethod() {
    }

    @Around("callMethod()")
    public void beforeMethodCall(ProceedingJoinPoint joinPoint) {
        Log.e(TAG, "around 1->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Log.e(TAG, "around 2->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());

    }

}
