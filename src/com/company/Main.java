package com.company;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    CheckString check = new CheckString();
	    ArrayList<String> example  = input();
	    ArabCalculator arabCalc = new ArabCalculator();
	    RimCalculator rimCalculator = new RimCalculator();
	    String result = check.checkStringOnMistake(example);
	    switch (result){
			case "Арабские цифры":
				System.out.println(arabCalc.calculator(example));
				break;
			case "Римские цифры":
				System.out.println(rimCalculator.calculator(example));
		}
    }

	public static ArrayList<String> input(){
		Scanner scan = new Scanner(System.in);
		ArrayList<String> example = new ArrayList<>(Arrays.asList(scan.nextLine().split(" ")));
		scan.close();
		return example;
	}
}

