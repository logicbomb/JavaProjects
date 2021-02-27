package com.rukon.clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Main {
    public static LinkedList<Echoer> threads = new LinkedList<>();
    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(5000)) {


            while(true) {

//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();
                System.out.println(".......");
               threads.add(new Echoer(serverSocket.accept()));
                System.out.println("....... 2");
               threads.getLast().start();



            }
        }
        catch (IOException exception){
            System.out.println("Server Exception " + exception.getMessage());
            exception.printStackTrace();
        }

    }


}
