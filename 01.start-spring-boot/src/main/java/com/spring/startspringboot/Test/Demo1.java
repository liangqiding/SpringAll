package com.spring.startspringboot.Test;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/5/23/023 11:39
 * @descriptio
 */

public class Demo1 {

    /**
     * @Author : 梁其定
     * @Date : 2020/5/23/023 11:45
     * @Description : TODO 测试
     * @params: s
     * @Return : String
     */
    public String Test(String s) {
        System.out.println(s);
        return null;
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.Test("我是叮当老师");
    }

}
