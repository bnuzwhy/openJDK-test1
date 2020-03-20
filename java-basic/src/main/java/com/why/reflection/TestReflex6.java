package com.why.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 通过反射获取泛型
 */
public class TestReflex6 {
    public void test1(Map<String,String> map, List<User> list){
        System.out.println("test1");
    }

    public Map<String,String> test2(){
        System.out.println("test2");
        return null;
    }

    public static void main(String[] args) {
        try {
            //获取参数对象泛型中的参数类型
            Method me = TestReflex6.class.getMethod("test1", Map.class, List.class);
            Type[] genericParameterTypes = me.getGenericParameterTypes();
            for (Type genericParameterType : genericParameterTypes) {
                System.out.println(genericParameterType);
                if(genericParameterType instanceof ParameterizedType){
                    Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                    for (Type actualTypeArgument : actualTypeArguments) {
                        System.out.println(actualTypeArgument);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("======================");
        try {
            //获取返回泛型的参数类型
            Method me = TestReflex6.class.getMethod("test2");
            Type genericReturnType = me.getGenericReturnType();
            if(genericReturnType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
