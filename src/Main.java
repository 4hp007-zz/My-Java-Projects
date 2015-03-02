//Wolv - 4hp007@gmail.com

import ACN.*;
import AMP.*;
import CN.*;
import DWM.*;
import OS.*;
import SPCC.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select a package:\n1. AMP\n2. CN\n3. DWM\n4. OS\n5. SPCC\n6. ACN");
        int a = Integer.parseInt(br.readLine());//System.in.read() - '0';
        int b;
        switch (a) {
            case 1:
                System.out.println("Select a program\n1. Logical to Linear\n2. SCSI\n3. Register Windowing");
                b = Integer.parseInt(br.readLine());
                switch(b) {
                    case 1:
                        Logical2Linear.run();
                        break;
                    case 2:
                        SCSI.run();
                        break;
                    case 3:
                        RegWindow.run();
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
                break;
            case 2:
                System.out.println("Select a program:\n1. CRC\n2. Checksum\n"
                        + "3. Hamming Code\n4. Stop & wair client\n5. stop & wait server"
                        + "\n6. TCP Client\n7. TCP Server\n8. UDP Client\n9. UDP Server");
                b = Integer.parseInt(br.readLine());//b = System.in.read() - '0';
                switch (b) {
                    case 1:
                        CRC.run();
                        break;
                    case 2:
                        Checksum.run();
                        break;
                    case 3:
                        HammingCode.run();
                        break;
                    case 4:
                        StopAndWait_Client.run();
                        break;
                    case 5:
                        StopAndWait_Server.run();
                        break;
                    case 6:
                        TCP_Client.run();
                        break;
                    case 7:
                        TCP_Server.run();
                        break;
                    case 8:
                        UDP_Client.run();
                        break;
                    case 9:
                        UDP_Server.run();
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                break;
            case 3:
                System.out.println("Select a program:\n1. Agglomerative\n2. Decision Tree\n3. Kmeans\n4. Apriori");
                b = Integer.parseInt(br.readLine());
                switch(b) {
                    case 1:
                        Agglomerative.run();
                        break;
                    case 2:
                        DecisionTree.run();
                        break;
                    case 3:
                        Kmeans.run();
                        break;
                    case 4:
                        Apriori.run();
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                break;
            case 4:
                System.out.println("Select a program:\n1. FIFO\n2. LRU\n3. LFU\n4. Round Robin"
                        + "\n5. SJF Priemptive\n6. SJF Non-Priemptive");
                b = Integer.parseInt(br.readLine());//System.in.read() - '0';
                switch (b) {
                    case 1:
                        FIFO.run();
                        break;
                    case 2:
                        LRU.run();
                        break;
                    case 3:
                        LFU.run();
                        break;
                    case 4:
                        RoundRobin.run();
                        break;
                    case 5:
                        SJF_Preemptive.run();
                        break;
                    case 6:
                        SJF_NonPreemptive.run();
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                break;
            case 5:
                System.out.println("Select a program:\n1. Lexical analyser\n2. LL1 Parser");
                b = Integer.parseInt(br.readLine());//System.in.read() - '0';
                switch (b) {
                    case 1:
                        lexicalAnalyser.run();
                        break;
                    case 2:
                        LL1_First_Follow.run();
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                break;
            case 6:
                System.out.println("Select a program:\n1. DVR");
                b = Integer.parseInt(br.readLine());//System.in.read() - '0';
                switch (b) {
                    case 1:
                        DVR.run();
                        break;                    
                    default:
                        System.out.println("Invalid choice");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
