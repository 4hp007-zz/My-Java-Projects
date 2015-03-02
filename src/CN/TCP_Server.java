//Client Side for TCP connection
//Server Should be run First
package CN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {

    public static void run() throws IOException {

        ServerSocket servSock = new ServerSocket(6789);
        Socket sock = servSock.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
        String b = in.readLine();
        out.println(b);
        System.out.print(b);
    }
}
