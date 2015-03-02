//Client Side for TCP connection
//Server Should be run First
package CN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCP_Client {

    public static void run() throws IOException {

        try (Socket sock = new Socket("ALICE", 1234)) {

            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            out.println("Hello World");
            System.out.print(in.readLine());
        }
    }
}
