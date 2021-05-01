package com.joaogsrocha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    // assumes the current class is called MyLogger
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        var bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println( "Insert name");
        String name = bufferedReader.readLine();
        System.out.println("Name: "+ name);
    }
}
