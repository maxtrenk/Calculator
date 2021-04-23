package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SplittableRandom;

public class CheckString {
    private ArrayList<String> rimNumber = new ArrayList<>(Arrays.asList("I","II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"));
    private ArrayList<String> permittedOperation = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    public String checkStringOnMistake(ArrayList<String> list) {
        try {
            if (list.size() != 3) throw new Exception("Не верное количество данных.");
            if (!permittedOperation.contains(list.get(1)))  throw new Exception("Данный тип операций не поддерживается(Разрешены действия +, -, *, /)");
            if ((arabCheck(list.get(0)) && rimNumber.contains(list.get(2))) || (rimNumber.contains(list.get(0)) && arabCheck(list.get(2))))
                throw new Exception("Можно вводить только Римские или арабские цифры одновременно.");
            if (rimNumber.contains(list.get(0)) && rimNumber.contains(list.get(2))) {
                return "Римские цифры";
            }
            try {
                int i = Integer.parseInt(list.get(0));
                int b = Integer.parseInt(list.get(2));
                if (chechRenge(i) && chechRenge(b)) {
                    return "Арабские цифры";
                } else throw new Exception("Можно вводить только цифры от 1 до 10.") ;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не цифры.");
                System.exit(1);
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        return "Непредвиденная ситуация!";
    }

    boolean chechRenge(int b){
        if (b >= 1 && b <= 10) return true;
        else return false;
    }

    private boolean arabCheck(String str) {
        try {
            int i = Integer.parseInt(str);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

}
