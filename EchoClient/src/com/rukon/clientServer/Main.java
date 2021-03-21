package com.rukon.clientServer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Main {
    Socket client;
    BufferedReader echoes;
    PrintWriter stringtoEcho;
    MessagesThread messagesThread;
    Button clickMe;
    TextField textArea;
    TextArea text;

    public void sendMessage(String message){
        stringtoEcho.println(message);
    }

    public Main() throws IOException {
        client = new Socket("localhost", 5000);
        echoes = new BufferedReader(new InputStreamReader(client.getInputStream()));
        stringtoEcho = new PrintWriter(client.getOutputStream(), true);
        stringtoEcho.println("Hi");
        clickMe = new Button();
        textArea = new TextField();
        text = new TextArea();
        screenBuilder();
    }

    private void screenBuilder() {
        Frame frame = new Frame();
        frame.setSize(300, 300);
        Panel panel = new Panel();
        Panel panel2 = new Panel();
        panel.setSize(300, 100);
        panel2.setSize(300, 100);

        textArea.setBounds(50, 50, 50, 50);
        textArea.setSize(200, 10);

        clickMe.setLabel("Click Me");
        clickMe.setSize(50, 20);
        clickMe.setBounds(10, 10, 50, 50);
        text.setSize(50, 50);
        panel.add(text);
        panel2.add(textArea);
        panel2.add(clickMe);
        frame.add(panel);
        frame.add(panel2);



        frame.setVisible(true);
    }



    public static void main(String[] args) {



	try {

       Main m = new Main();

       m.clickMe.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               m.sendMessage(m.textArea.getText());
           }
       });
    //   new MessagesThread().start();



//        do {
//
//            System.out.println("Enter the new line: ");
//            echoString = scanner.nextLine();
//          //  System.out.println("Changes in Git Hub");
//            stringtoEcho.println(echoString);
//
//            if(!echoString.equals("exit")){
//                response = echoes.readLine();
//                System.out.println(response);
//            }
//
//
//        }
//        while (!echoString.equals("exit"));

//        while(true){
//            response = echoes.readLine();
//            System.out.println(response);
//
////            System.out.println("Enter the new line: ");
////            echoString = scanner.nextLine();
//////          //  System.out.println("Changes in Git Hub");
////           stringtoEcho.println(echoString);
////
////            if(!echoString.equals("exit")){
////                response = echoes.readLine();
////                System.out.println(response);
////            }
//        }

    }


	catch (IOException e){
        System.out.println("Exception in Client " + e.getMessage());
        e.printStackTrace();
    }


    }



    class  MessagesThread extends Thread {
        public void run() {
            String line;
            try {
                while(true) {
                    line = echoes.readLine();
                    System.out.println(line);
                } // end of while
            } catch(Exception ex) {}
        }
    }
}
