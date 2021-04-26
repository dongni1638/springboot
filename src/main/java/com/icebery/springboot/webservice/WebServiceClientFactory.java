package com.icebery.springboot.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

/**
 * @Author: 低调的小码农
 * @Date: 2021/4/26 9:16 AM
 * @Version 1.0
 */
public class WebServiceClientFactory {

    public Client createClient(String webserviceAddress) {
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient(webserviceAddress);
        return client;
    }

    private void testWebserviceClient(){
        //创建连接
        String url="http://localhost:8089/service/webservicetest?wsdl";
        String method="transWords";
        try {
            Client client = createClient(url);
            Object[] result = client.invoke(method, "i love you!!!");
            System.out.println("连接成功！");
            System.out.println((String) result[0]);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        WebServiceClientFactory webServiceClientFactory=new WebServiceClientFactory();
        webServiceClientFactory.testWebserviceClient();
    }


}
