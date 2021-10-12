package com.tianhai.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MemoryOut {

    static class OOMObject {}

    public static void main(String[] args) throws InterruptedException {
        int[] a;
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println(maxMemory);
        System.out.println(totalMemory);

        List<OOMObject> oomObjectList = new ArrayList<>();
        while (true){
//            TimeUnit.MILLISECONDS.sleep(10);
            oomObjectList.add(new OOMObject());
        }
    }
}
