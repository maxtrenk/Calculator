package com.company;

import java.util.ArrayList;

public class ArabCalculator {
    public int calculator(ArrayList<String> list){
        int i = Integer.parseInt(list.get(0));
        int b = Integer.parseInt(list.get(2));
        int result = 0;
        switch (list.get(1)) {
            case "+":
                result = i + b;
                break;
            case "-":
                result = i - b;
                break;
            case "*":
                result = i * b;
                break;
            case "/":
                result = i / b;
                break;
        }
        return result;
    }
}
