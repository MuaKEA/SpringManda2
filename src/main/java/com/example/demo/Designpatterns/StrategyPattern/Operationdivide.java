package com.example.demo.Designpatterns.StrategyPattern;

public class Operationdivide implements Strategy {


    @Override
    public int doOperation(int num1, int num2) {
        return num1/num2;
    }
}
