package ch1.helloworld.test.pattern.singleton_pattern;

/**
 * author: liguoping
 * date: 2019/6/15 20:36
 * description: 静态内部类的方式实现单例模式
 */
public class SingletonInnerClass {
    // 内部类
    private static class SingletonHolder {
        private static  SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }
    private SingletonInnerClass(){}
    public static  SingletonInnerClass getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
