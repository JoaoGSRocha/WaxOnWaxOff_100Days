package com.joaogsrocha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    private static ArrayList<String> names = new ArrayList<>(Arrays.asList("Banana","With","Tofu"));

    private static String listNames() {
        var bld = new StringBuilder();
        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            bld.append(it.next());
            if(it.hasNext())
                bld.append(",");
        }
        var listOfNames = bld.toString();

        return "List of Names:" + listOfNames;
    }

    public static boolean isNumeric(String string) {
        int intValue;

        if(string == null || string.equals("")) {
            System.out.println("String is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    private static String addName() throws IOException {
        var bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("New Name to Add: ");
        String name;
        name = bufferedReader.readLine();
        names.add(name);
        var bld = new StringBuilder();
        bld.append("Names:" + names +"\n"+ "Added Name:"+ name);
        bld.append("\n ----------------------------");
        return bld.toString();
    }

    private static String doesitHaveSpecificWord() throws IOException {
        var bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Check if Word Exists: ");
        String word;
        word = bufferedReader.readLine();
        if(names.contains(word))
            return word+" is in the list of names.";
        else
            return word+" is not in the list.";
    }

    private static String removeNameByIndex() throws IOException {
        var bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Insert Index by: ");
        String index;
        index = bufferedReader.readLine();
        names.remove(Integer.parseInt(index));
        var bld = new StringBuilder();
        bld.append("Names:" + names +"\n");
        bld.append("\n ----------------------------");
        return bld.toString();
    }


    private static String pickMenuOption(String option) throws IOException {
        switch (option){
            case "1":
                return listNames();
            case "2":
                return addName();
            case "3":
                return removeNameByIndex();
            case "4":
                return doesitHaveSpecificWord();
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
                    "2 - Add Name \n"   +
                    "3 - Remove Name \n"   +
                    "4 - Does it Have X Word? \n" +
                    "0 - Exit Program");
            option = bufferedReader.readLine();
            System.out.println("Option Picked: "+ option);
            if(isNumeric(option))
                System.out.println(pickMenuOption(option));
            else
                option= "404"; // As in not found
        } while (Integer.parseInt(option) != 0);
    }
}
