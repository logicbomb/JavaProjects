package com.rukon.clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.security.MessageDigest;
import java.util.*;

public class Main {


    public static LinkedList<Echoer> threads = new LinkedList<>();

    public static void broadCast(String message) {
        try {
            for (Echoer echoer : Main.threads) {
            echoer.sendToAllClient(echoer.getClientID() + ": " + message);



            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }


    }

    public static void main(String[] args) throws IOException {



        try(ServerSocket serverSocket = new ServerSocket(5000)) {


            while(true) {


//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();

                Echoer ech = new Echoer(serverSocket.accept());
                threads.add(ech);




            }
        }
        catch (IOException exception){
            System.out.println("Server Exception " + exception.getMessage());
            exception.printStackTrace();
        }

    }


}
