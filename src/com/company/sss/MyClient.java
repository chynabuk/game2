package com.company.sss;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient extends Thread{
    private Socket socket;

    public MyClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("socket = " + socket.toString());

        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
//            Desktop desktop = new Desktop();
//            out.writeObject(desktop);
            socket.close();
        }
        catch (IOException ioe){
            System.out.println(ioe);
        }
    }
}
