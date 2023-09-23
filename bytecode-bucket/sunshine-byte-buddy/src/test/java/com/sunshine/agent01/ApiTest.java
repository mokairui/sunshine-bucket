package com.sunshine.agent01;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/23
 */
public class ApiTest {
    
    public static void main(String[] args) {
        System.out.println("hi java agent!");
        ApiTest apiTest = new ApiTest();
        apiTest.echoHi();
    }
    
    private void  echoHi() {
        System.out.println("hi agent!");
    }
    
}
