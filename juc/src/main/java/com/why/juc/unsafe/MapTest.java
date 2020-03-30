package com.why.juc.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        testMap();
    }

    public static void testMap(){
        //Map<String,Object> map = new HashMap<>();
        Map<String,Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 300; i++) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(1,5),new Object());
                System.out.println(map);
            }).start();
        }

    }
}
