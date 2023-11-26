package com.sunshine.client;

import com.sunshine.infrastructure.Context;
import com.sunshine.infrastructure.impl.ClosingState;

/**
 * @author Mokairui
 * @description
 * @since 2023/11/26
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());

        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
