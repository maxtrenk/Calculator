package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RimCalculator {
    private  Map<Integer, String> firstsOrder = new HashMap<>(Map.of(1, "I", 2 , "II", 3, "III", 4 , "IV", 5, "V", 6, "VI", 7, "VII", 8, "VIII", 9, "IX", 10, "X"));
    private  Map<String, Integer> reverse = Map.of( "I", 1, "II", 2, "III", 3, "IV", 4, "V", 5, "VI", 6, "VII", 7, "VIII", 8, "IX", 9,"X", 10);
    private  Map<Integer, String> secondOrder =  new HashMap<>(Map.of(1, "X", 2 , "XX", 3, "XXX", 4 , "XL", 5, "L", 6, "LX", 7, "LXX", 8, "LXXX", 9, "XC"));
    private  Map<Integer, String> thirdOrder = Map.of(1, "C", 0, "");

    public String calculator(ArrayList<String> list){
        ArrayList<String> copy  = new ArrayList<>(list);
        ArabCalculator arabCalculator = new ArabCalculator();
        Integer i = reverse.get(list.get(0));
        Integer b = reverse.get(list.get(2));
        copy.set(0, Integer.toString(i));
        copy.set(2, Integer.toString(b));
        int arabNumber = arabCalculator.calculator(copy);
        return arabInRim(arabNumber);
    }

    public String arabInRim(int arabNumber){
        String result = "";
        char[] order = Integer.toString(arabNumber).toCharArray();
        firstsOrder.put(0, "");
        secondOrder.put(0, "");
        switch (order.length){
            case 1:
                result += firstsOrder.get(Character.getNumericValue(order[0]));
                break;
            case  2:
                result += secondOrder.get(Character.getNumericValue(order[0])) + firstsOrder.get(Character.getNumericValue(order[1]));
                break;
            case 3:
                result += thirdOrder.get(Character.getNumericValue(order[0]))  + secondOrder.get(Character.getNumericValue(order[1])) + firstsOrder.get(Character.getNumericValue(order[2]));
        }
        return  result;
    }
}
