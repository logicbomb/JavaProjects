package com.rukon.clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;
import java.util.function.DoubleToIntFunction;
import java.util.logging.SocketHandler;

public class Echoer extends Thread {

private String clientID;
private Socket socket;
private BufferedReader input;

private PrintWriter writer;


public Echoer(Socket socket) throws IOException {
    this.socket = socket;


    this.clientID = this.getName();

    this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

   this.writer = new PrintWriter(socket.getOutputStream(), true);
    this.start();
}


    public void sendToAllClient(String message) throws IOException {
       writer.println(message);

    }
    @Override
    public void run() {
        try {


            System.out.println(this.clientID + " is Connected ");


            while(true){


                String echoString = input.readLine();

                System.out.println("Received new message from: [Client " + this.clientID + "] " );//echoString);

                if(echoString=="exit"){
                   break;
              }

                Main.broadCast(echoString);




                //sendToClient(this, "From server to client: ");
           //     sendToClient(this, "From server to client: 2 ");



            }
        }
        catch (IOException e){
            System.out.println("Ops " + e.getMessage());
        }
        finally {
            try {
                socket.close();
            }
            catch (IOException e){

            }
        }
    }

    public String  getClientID() {
        return clientID;
    }

    public Socket getSocket() {
        return socket;
    }
}
