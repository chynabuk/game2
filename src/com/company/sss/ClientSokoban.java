package com.company.sss;

import com.company.Desktop;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientSokoban {
    public static void main(String[] args) {
        ServerSokoban serverSokoban = new ServerSokoban(4446);
        serverSokoban.go();

        String hostName = "149.152.37.7";
        int portNumber = 4446;

        System.out.println("Connection to Server...");
        try(
                Socket socket = new Socket(hostName, portNumber);
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        )
        {
            Desktop object = (Desktop) in.readObject();
            int[][] desktop = object.getDesktop();
            for (int i = 0; i < desktop.length; i++){
                for (int j = 0; j < desktop[i].length; j++){
                    System.out.print(desktop[i][j] + "");
                }
                System.out.println();
            }
            System.out.println();
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Error " + cnfe);
        }
        catch (IOException ioException){
            System.out.println("Error " + ioException);
        }
    }
}
