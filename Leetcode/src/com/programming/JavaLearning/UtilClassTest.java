package com.programming.JavaLearning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

class UtilClass {

    static int i = 0;

    static String  toLowerPlusTrim(String input) {
        return (input + i++).trim().toLowerCase();
    }
}

public class UtilClassTest{

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(300);
        for(int i = 0; i <= 50; i++) {
            executorService.submit(() -> {
                System.out.println(UtilClass.toLowerPlusTrim("HEllO RahilMODI"));
            });
        }

    }

}
