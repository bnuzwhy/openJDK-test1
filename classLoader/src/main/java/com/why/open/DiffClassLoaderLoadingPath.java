package com.why.open;

import java.util.Arrays;
import java.util.List;

public class DiffClassLoaderLoadingPath {
    public static void main(String[] args) {
        //bootClassLoaderLoadingPath();
        //extClassLoaderLoadingPath();
        appClassLoaderLoadingPath();
    }
    //启动类加载器
    public static void bootClassLoaderLoadingPath(){
        //获取启动类加载器加载的目录
        String bootStrapLoadingPath = System.getProperty("sun.boot.class.path");
        //把加载的目录转为集合
        List<String> bootLoadingPathList = Arrays.asList(bootStrapLoadingPath.split(";"));

        for (String s : bootLoadingPathList) {
            System.out.println(s);
        }
    }
    //扩展类加载器
    public static void extClassLoaderLoadingPath(){
        String extClassLoadingPath = System.getProperty("java.ext.dirs");
        List<String> strings = Arrays.asList(extClassLoadingPath.split(";"));
        for (String string : strings) {
            System.out.println(string);
        }
    }
    //应用类加载器
    public static void appClassLoaderLoadingPath(){
        String extClassLoadingPath = System.getProperty("java.class.path");
        List<String> strings = Arrays.asList(extClassLoadingPath.split(";"));
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
