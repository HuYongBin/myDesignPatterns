package com.hyb.notes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(11222);
        while (true) {
            Socket s = ss.accept();
            System.out.println("a client connect!");
            final DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            final DataInputStream dis = new DataInputStream(s.getInputStream());

            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println(dis.readUTF());
                        } catch (IOException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                    }
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            dos.writeUTF("server");
                        } catch (IOException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                    }
                }
            }.start();
        }
    }
}