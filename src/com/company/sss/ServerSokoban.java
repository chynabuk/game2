package com.company.sss;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSokoban {
    private ServerSocket server;
    private final Object object;

    public ServerSokoban(int port)  {
        try {
            server = new ServerSocket(port);
        }
        catch (IOException ioe){
            System.out.println("error " + ioe);
        }
        object = new Object();
    }

    public void go(){
        System.out.println("The Server has been started");
        while (true){
            synchronized (object){
                Socket clientSocket;
                try {
                    clientSocket = server.accept();
                }
                catch (IOException ioe){
                    System.out.println(ioe);
                    clientSocket = null;
                }

                if (clientSocket != null){
                    MyClient client = new MyClient(clientSocket);
                    client.start();
                }

            }
        }
    }
}
