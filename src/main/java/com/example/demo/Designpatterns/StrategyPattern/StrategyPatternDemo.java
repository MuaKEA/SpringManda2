package com.example.demo.Designpatterns.StrategyPattern;

import com.example.demo.Designpatterns.StrategyPattern.*;

public class StrategyPatternDemo {

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

        context= new Context(new Operationdivide());
        System.out.println("10/2 = " + context.executeStrategy(10,2));

    }


}
