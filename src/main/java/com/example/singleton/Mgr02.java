package com.example.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不用管用到与否，类加载时就完成实例化
 * Class.forName("")
 * (话说你不用的，你装载它干啥) -- > 懒汉式
 */
public class Mgr02 {
    private static final Mgr02 INSTANCE;
    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02() {};

    public static Mgr02 getInstance() { return INSTANCE; }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr02 m1 = Mgr02.getInstance();
        Mgr02 m2 = Mgr02.getInstance();
        System.out.println(m1 == m2);
    }
}
