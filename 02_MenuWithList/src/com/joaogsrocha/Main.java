package com.joaogsrocha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    private static ArrayList<String> names = new ArrayList<>(Arrays.asList("Geeks","for","Geeks"));
    private static String pickMenuOption(String option){
        switch (option){
            case "1":
                var bld = new StringBuilder();
                Iterator<String> it = names.iterator();
                while(it.hasNext()) {
                    bld.append(it.next());
                    if(it.hasNext())
                        bld.append(",");
                }
                var listOfNames = bld.toString();

                return "List of Names:" + listOfNames;
            default:
                return option;
        }
    }
    public static void main(String[] args) throws IOException {
        var bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        String option;
        do{
            System.out.println( "1 - List Names \n" +
                                "0 - Exit Program");
            option = bufferedReader.readLine();
            System.out.println("Option Picked: "+ option);
            System.out.println(pickMenuOption(option));
        } while (Integer.parseInt(option) != 0);
    }
}
