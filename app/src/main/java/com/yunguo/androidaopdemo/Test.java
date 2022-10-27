package com.yunguo.androidaopdemo;

/**
 * @author : Axes
 * create at:  10/26/22  10:56 AM
 * @description: aop 测试类
 */
public class Test {
    static public class TestBase{
        static {
            int x = 0;
        }

        int base = 0;

        public  TestBase(int index) {
            base = index;
        }
    }

    static  public class TestDerived extends TestBase{
        public int derived = 0;
        public TestDerived(){
            super(0);
            this.derived = 1000;
        }
        public void testMethod(){
            try {
                byte[] test = null;
                test[1] = 0x33;
            } catch (Exception ex) {
            }
        }
        static int getFixedIndex() {
            return 1000;
        }
    }

//    public static void main(String[] arg) {
//        System.out.println("Test begin");
//        TestDerived testDerived = new TestDerived();
//        testDerived.testMethod();
//        testDerived.base = 1;
//
//        System.out.println("Test end");
//    }
}
