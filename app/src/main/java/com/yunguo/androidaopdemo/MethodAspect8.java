package com.yunguo.androidaopdemo;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author : Axes
 * create at:  10/27/22  11:03 AM
 * @description: if条件、args参数
 */
@Aspect
public class MethodAspect8 {
    private static final String TAG = "MethodAspect8";


    /**
     切点方法someCallWithIfTest声明的注解表示任意方法，
     此方法返回值为boolean，参数签名为仅一个int类型的参数，
     后面跟上if条件，表示此int参数值大于0，且方法签名以setAge开头。
     * */
    @Pointcut("call(boolean *.*(int)) && args(i) && if()")
    public static boolean someCallWithIfTest(int i, JoinPoint jp) {
        // any legal Java expression...
        return i > 0 && jp.getSignature().getName().startsWith("setAge");
    }


    /**
     * 1. 如此一来切面代码的执行就具备了动态性，但不是说不满足if条件的切点就不会织入代码。
     * 2. 只是在调用织入代码前会执行someCallWithIfTest方法，当返回值为true时才会执行织入代码，下图是反编译class的结果。
     *3. 了解了原理后，实际上if逻辑也完全可以放到织入点代码中，理解起来会更容易一些。

     * */

    @Before("someCallWithIfTest(i, jp)")
    public void aroundMethodCall(int i, JoinPoint jp) {
        Log.e(TAG, "before if ");
    }

}
