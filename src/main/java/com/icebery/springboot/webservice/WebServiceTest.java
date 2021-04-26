package com.icebery.springboot.webservice;

/**
 * @Author: 低调的小码农
 * @Date: 2021/4/25 3:38 PM
 * @Version 1.0
 */


import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class WebServiceTest {
    public String transWords(String words){
        String str = words;
        String strUpper = str.toUpperCase();
        return strUpper;
    }

    public static void main(String[] args) {
        // 使用Endpoint(终端)类发布webservice
        //http://localhost:8089/service/webservicetest?wsdl  测试地址
        Endpoint.publish("http://localhost:8089/service/webservicetest", new WebServiceTest());
        System.out.println("Publish Success");
    }
}