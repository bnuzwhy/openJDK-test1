package com.why.oom;

import java.util.ArrayList;
import java.util.List;

public class TestJProfiler {
    byte[] array = new byte[1024*1024];

    public static void main(String[] args) {
        List<TestJProfiler> list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {
                list.add(new TestJProfiler());
                count += 1;
            }
        }catch (Exception e){
            System.out.println("count: "+count);
        }
    }
}
