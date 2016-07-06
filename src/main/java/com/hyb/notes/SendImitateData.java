package com.hyb.notes;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 发送模拟数据，可以自动重连
 * <p/>
 * 创建日期：2012-7-26
 *
 * @author luoxianmu
 */
public class SendImitateData {

    public static final String HOST_ = "127.0.0.1";
    public static final int PORT_ = 11222;
    public static final int TIME_OUT = 60 * 1000;

    public static void main(String[] args) throws InterruptedException {
        Socket socket = null;
        CyclicBarrier barr = new CyclicBarrier(3);
        while (true) {
            System.out.println("conecting to Server " + HOST_ + ":" + PORT_);

            socket = initSocket();
            if (socket != null && socket.isConnected() && !socket.isClosed()) {
                System.out.println("conected。。。。");
                OutThread out = new OutThread(barr, socket);
                out.start();

                InThread in = new InThread(barr, socket);
                in.start();
                try {
                    barr.await();
                } catch (Exception e) {
                }
            } else {
                System.out.println("connected failed, sleep for 30 s!");
                Thread.sleep(5 * 1000);
            }
            barr.reset();
        }
    }

    private static Socket initSocket() {
        Socket socket = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(HOST_, PORT_), TIME_OUT);
        } catch (UnknownHostException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        return socket;
    }
}

class OutThread extends Thread {
    private Socket socket;
    private CyclicBarrier barr;

    public OutThread(CyclicBarrier barr, Socket socket) {
        this.barr = barr;
        this.socket = socket;
    }

    @Override
    public void run() {
        boolean target = true;
        DataOutputStream bos = null;
        while (target) {
            try {
                if (socket.isConnected() && !socket.isClosed()) {
//                    bos = getBufferedOutputStream(socket);
//                    bos.write(getCommandBytes());
//                    bos.write(new byte[]{0x0d, 0x0a});
                    bos = new DataOutputStream(socket.getOutputStream());
                    bos.writeUTF("client");
                    bos.flush();
                } else {
                    target = false;
                }
                Thread.sleep(1000 * 20);
            } catch (Exception e) {
                System.out.println("OutThread = " + e.getMessage());
                target = false;
            } finally {
//                try {
//                    if (bos != null) {
//                        bos.close();
//                    }
//                    if (socket != null) {
//                        socket.close();
//                    }
//                } catch (Exception e) {
//                    // TODO: handle exception
//                }
            }
        }
        try {
            barr.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static BufferedOutputStream getBufferedOutputStream(Socket socket) {
        try {
            return new BufferedOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] getCommandBytes() {
        StringBuffer command = new StringBuffer("##00000");
        command.append(";A0=" + getRandomFloat());
        command.append(";A1=" + getRandomFloat());
        command.append(";B0=" + getRandomFloat());
        command.append(";C0=" + getRandomFloat());
        command.append(";C1=" + getRandomFloat());
        command.append(";C2=" + getRandomFloat());
        command.append(";C3=" + getRandomFloat());
        System.out.println(command.toString());
        return command.toString().getBytes();
    }

    private static Float getRandomFloat() {
        Random random = new Random();
        return BigDecimal.valueOf(random.nextDouble() * 100).setScale(2, RoundingMode.UP).floatValue();
    }

}

class InThread extends Thread {
    private Socket socket;
    private CyclicBarrier barr;

    public InThread(CyclicBarrier barr, Socket socket) {
        this.barr = barr;
        this.socket = socket;
    }

    @Override
    public void run() {
        boolean target = true;
//        BufferedInputStream bis = null;
        DataInputStream bis = null;
        while (target) {
            try {
                if (socket.isConnected() && !socket.isClosed()) {
//                    bis = getBufferedInputStream(socket);
//                    byte[] tmp = new byte[1024];
//                    int re = -1;
//                    while ((re = bis.read(tmp)) != -1) {
//                        System.out.println(new String(tmp, 0, re));
//                    }
                    bis = new DataInputStream(socket.getInputStream());
                    System.out.println(bis.readUTF());
                } else {
                    target = false;
                }
//                Thread.sleep(1000 * 10);
            } catch (Exception e) {
                System.out.println("InThread = " + e.getMessage());
                target = false;
            } finally {
//                try {
//                    if (bis != null) {
//                        bis.close();
//                    }
//                    if (socket != null) {
//                        socket.close();
//                    }
//                } catch (Exception e) {
//                    // TODO: handle exception
//                }
            }

        }
        try {
            barr.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static BufferedInputStream getBufferedInputStream(Socket socket) {
        try {
            return new BufferedInputStream(socket.getInputStream());
        } catch (IOException e) {
            return null;
        }
    }

}

