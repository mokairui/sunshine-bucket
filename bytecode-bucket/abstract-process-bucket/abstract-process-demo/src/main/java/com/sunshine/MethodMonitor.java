package com.sunshine;

import com.sunshine.annotation.ApiAnnotation;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/2
 */
@ApiAnnotation(date = "2023-10-03")
public class MethodMonitor {
    
    @ApiAnnotation(date = "2023-10-01")
    public void echoHi() {
        System.out.println("say hello abstract processor!");
    }
    
}
