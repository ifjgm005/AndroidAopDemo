package com.yunguo.androidaopdemo;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author : Axes
 * create at:  10/27/22  10:42 AM
 * @description: 示例基本用法 全局OnClickListener监听 注意lamada表达式不生效的问题
 */
@Aspect
public class MethodAspect5 {
    private static final String TAG = "MethodAspect5";

    @Pointcut("execution(* android.view.View.OnClickListener+.onClick(..))")
    public void callMethod() {
    }

    @Around("callMethod()")
    public void aroundMethodCall(ProceedingJoinPoint joinPoint) {
        Log.e(TAG, "around 1->");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        Object[] args = joinPoint.getArgs();

        Log.e(TAG, "around 2-> 点击事件切入点:"+ args[0]);


    }

}
