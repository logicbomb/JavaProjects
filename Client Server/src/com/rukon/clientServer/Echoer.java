package com.rukon.clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.function.DoubleToIntFunction;
import java.util.logging.SocketHandler;

public class Echoer extends Thread {

private long clientID;
private Socket socket;
public Echoer(Socket socket){
    this.socket = socket;
    this.clientID = this.getId();
}

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            System.out.println(this.clientID + " is Connected");
            while(true){
                String echoString = input.readLine();
                System.out.println("Received new message from: [Client " + this.clientID + "] " + echoString);
                if(echoString=="exit"){
                    break;
                }
                writer.println("Hi I am your server, you just wrote: from " + this.clientID+ " "  + echoString);
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
}
