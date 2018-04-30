package com.packtpublishing.tddjava.debug;
import static java.lang.System.out;

public class MyDebug {

    public static void myDebug(String format, Object ... args) {
        out.println("   <=== myDebug !!!===>" + String.format(format, args));
    }

    /*
    public static void myDebug(String s) {
//        System.out.println("   <=== myDebug !!!===>" + s);
        out.println("   <=== myDebug !!!===>" + s);
    }
    */
}
