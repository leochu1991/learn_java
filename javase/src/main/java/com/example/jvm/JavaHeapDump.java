package com.example.jvm;

/**
 * jvm heap oom dump
 */
public class JavaHeapDump {

    public static void main(String[] args) {
        System.out.println("jvm heap dump");
        while (true) {
            Byte[] bytes = new Byte[1024];
        }
    }
}
