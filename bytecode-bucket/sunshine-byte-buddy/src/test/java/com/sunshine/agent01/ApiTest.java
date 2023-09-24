package com.sunshine.agent01;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/23
 */
public class ApiTest {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hi java agent!");
        ApiTest apiTest = new ApiTest();
        apiTest.echoHi();
        
        /* agent04 使用 */
//        List<String> list = new ArrayList<>();
//        while (true) {
//            TimeUnit.SECONDS.sleep(2);
//            list.add("你好 JavaAgent!");
//            list.add("你好 JavaAgent!");
//            list.add("你好 JavaAgent!");
//        }
    }
    
    private void  echoHi() {
        System.out.println("hi agent!");
    }
    
}
