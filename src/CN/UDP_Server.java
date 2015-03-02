//Server Side for UDP connection

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
import java.net.UnknownHostException;

public class UDP_Server {

    public static void run() throws SocketException, UnknownHostException, IOException {

        String a = "Hello World";
        byte[] buff = a.getBytes();

//To Get The Address of The Local Machine
        InetAddress add = InetAddress.getLocalHost();
        DatagramSocket dgs = new DatagramSocket(1111);

//DGP for Sending Packets
        DatagramPacket dgp = new DatagramPacket(buff, buff.length, add, 6789);
        dgs.send(dgp);

//DGP for Receiving Packets
        dgp = new DatagramPacket(buff, buff.length);
        dgs.receive(dgp);

        a = buff.toString();
        System.out.print("Message received" + a);
    }
}
