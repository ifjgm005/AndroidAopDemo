package com.yunguo.androidaopdemo;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import static android.content.ContentValues.TAG;

/**
 * @author : Axes
 * create at:  10/26/22  2:04 PM
 * @description: 本类是一个AspectJ配置文件
 */
@Aspect  //① 声明了本类是一个AspectJ配置文件
public class MethodAspect {
    String TAG = "zhang";




/**
 * 指定代码织入点，注解内的call(* com.wandering.sample.aspectj.Animal.fly(..)) 是一个切点表达式，
 * 第一个*号表示返回值可为任意类型，
 * 后跟包名+类名+方法名，
 * 括号内表示参数列表， .. 表示匹配任意个参数，参数类型为任何类型，
 * 这个表达式指定了一个时机：在Animal类的fly方法被调用时。
 * */
    @Pointcut("call(* com.yunguo.androidaopdemo.Animal.fly(..))")//②
    public void callMethod() {
    }




    /**
     * 1. 声明Advice类型为Before
     * 2. 指定切点为上面 callMethod方法所表示的那个切点。
     * */
    @Before("callMethod()")//③
    public void beforeMethodCall(JoinPoint joinPoint) {
        Log.e(TAG, "getTarget->" + joinPoint.getTarget());
        Log.e(TAG, "getThis->" + joinPoint.getThis());
        //④
    }
}
