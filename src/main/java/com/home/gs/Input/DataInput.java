package com.home.gs.Input;

import java.util.Scanner;

public class DataInput implements InputInterface {

    //displays user with a message and take input
    public static String Input(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }



}
