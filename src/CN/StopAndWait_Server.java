package CN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class StopAndWait_Server {

    public static void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Waiting for Clients: ");

//Creating Server            
        ServerSocket servSock = new ServerSocket(6789);
        try (Socket sock = servSock.accept()) {
            
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            System.out.println("Connection Established");
            System.out.print("Enter no. of frames: ");
            int n = Integer.parseInt(br.readLine());
            String ack;
            for (int i = 0; i < n; i++) {
                ack = "false";
                while ("false".equals(ack)) {
                    out.println(i + 1);
                    System.out.println("Frame no. " + (i + 1) + ": Sent");
                    try {
                        
                        sock.setSoTimeout(20000);       //Setting timeout 20000ms
                        ack = in.readLine();
                    } catch (SocketTimeoutException e) {
                        System.out.println("TimeOut");
                    }
                }
            }
            out.println("bye");
        }
    }
}
