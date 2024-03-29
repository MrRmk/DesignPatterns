package com.example.singleton;

/**
 * 懒汉式
 * 双重检查
 */
public class Mgr03 {
    private volatile static Mgr03 INSTANCE;   //volatile 防止指令重排

    private Mgr03() {};

    public static Mgr03 getInstance() {
        if(INSTANCE == null){
            //双重检查
            synchronized (Mgr03.class){
                if(INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr03();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++){
            new Thread(()->{
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }

}
