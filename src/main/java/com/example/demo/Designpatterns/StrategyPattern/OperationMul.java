package com.example.demo.Designpatterns.StrategyPattern;

public class OperationMul implements Strategy {
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
