package com.icebery.springboot.webservice;


/**
 * @Author: 低调的小码农
 * @Date: 2021/4/25 4:02 PM
 * @Version 1.0
 */
public class WebServiceTestClient {

    public static void main(String[] args){
        WebServiceTest fu;
        try {
            fu=new WebServiceTest();
            String str = fu.transWords("i love you!");
            System.out.println(str);
        }catch (Exception e){
            System.out.println("yichang");
        }
    }
}
