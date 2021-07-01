package com.bb8qq.life.lib;

public class Log {

    public static void p(Object o) {
        p(o.toString());
    }

    public static void p(String msg) {
        System.out.println(msg);
    }
}
