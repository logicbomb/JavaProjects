package com.example.javafragments;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;


public class ChatClient extends Thread {
    private String userName;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter printWriter;



    public ChatClient() {

        try {
            this.socket = new Socket("localhost", 5000);
            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);

            this.printWriter.println("User " + (new Random(10)).toString());
            new ReceiveMessage().start();
        }
        catch (IOException e){
            Log.d(e.getMessage(), "Connection error for client");//System.out.println("Data send/receive failed: " + e.getMessage());

        }
    }

//    @Override
//    public void run() {
//        try {
//            this.socket = new Socket("localhost", 5000);
//            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
//
//            this.printWriter.println("User " + (new Random(10)).toString());
//            new ReceiveMessage().start();
//        }
//        catch (IOException e){
//            Log.d(e.getMessage(), "Connection error for client");//System.out.println("Data send/receive failed: " + e.getMessage());
//
//        }
//    }
//
    public void sendMessage(String message){
        printWriter.println(message);
    }

//    public void sendMesage(String message) throws IOException {
//    //    Scanner scanner = new Scanner(System.in);
//
//     //   ChatClient m = new ChatClient();
//       // while (true) {
//
//            sendMessage(message);
////            if(message.equals("logout")){
////                System.out.println("Logged Out");
////                m.socket.close();
////
////         //   }
////        }
//
//
//    }

    class ReceiveMessage extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    String inMessage = input.readLine();
                    System.out.println("New Message: " + inMessage);
                }
            }
            catch (IOException e){

            }

        }
    }


}