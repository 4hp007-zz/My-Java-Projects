//Client Side for UDP connection

/*
 The side which has 
 an element to be 
 received is run 
 first. Here, Client.
 */
package CN;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDP_Client {

    public static void run() throws SocketException, IOException {

        DatagramSocket dgs = new DatagramSocket(6789);
        byte[] buff = new byte[32];

//DGP for Receiving Packets
        DatagramPacket dgp = new DatagramPacket(buff, buff.length);
        dgs.receive(dgp);
        String data = new String(buff);
        System.out.println("Message from server: " + data);

        String a = "Hello World";
        buff = a.getBytes();

//To Get The Address of The Local Machine
        InetAddress add = InetAddress.getLocalHost();

//DGP for Sending Packets
        dgp = new DatagramPacket(buff, buff.length, add, 1111);
        dgs.send(dgp);
    }
}
