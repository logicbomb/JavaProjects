package com.rukon.example;

import java.nio.charset.MalformedInputException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(1/0);
        }
        catch (Exception e){
            System.out.println(e);

        }
    }
}
