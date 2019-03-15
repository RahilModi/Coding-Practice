package com.programming.JavaLearning;

import java.lang.reflect.Field;

public class ReflectionConcepts {

    int num =10;

    ReflectionConcepts(){
        num = 20;
        ReflectionConcepts.this.num = 22;
        System.out.println(num);
    }

    public static void main(String[] args) {
        ReflectionConcepts obj = new ReflectionConcepts();
    }
}
