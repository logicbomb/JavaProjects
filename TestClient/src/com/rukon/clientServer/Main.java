package com.rukon.clientServer;

public class Main {

    public static void main(String[] args) {
        ChatClient client;
        client = new ChatClient();
        client.start();
        client.sendMessage("Hi there");
	// write your code here
    }
}
