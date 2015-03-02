package CN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class StopAndWait_Client {

    public static void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try (Socket sock = new Socket("ALICE", 6789)) {

            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            System.out.println("Connection Established");
            String a;
            do {
                a = in.readLine();
                System.out.println(a + " Received");
                System.out.println("Enter: \n1. Send ACK\n2.Send NACK\npress any key to timeout");
                int x = Integer.parseInt(br.readLine());
                if (x == 1)
                    out.println(true);
                else if (x == 2)
                    out.println(false);
                else {
                }
            } while (!"bye".equals(a));
            sock.close();
        }
    }
}
