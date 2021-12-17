package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerLevel {
    public Desktop getDataFromServer(int level){
        try(
                Socket socket = new Socket("149.152.37.7", 4446);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
                ) {
            out.println(level);
            Desktop serverDesktop = (Desktop) in.readObject();
            return serverDesktop;
        }
        catch (IOException | ClassNotFoundException e){
            return null;
        }
    }
}
