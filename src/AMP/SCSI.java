//Wolv - 4hp007@gmail.com

package AMP;

import java.io.*;

public class SCSI {

    public static void run() throws IOException {
        
        BufferedReader hp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of Devices:");
        int n = Integer.parseInt(hp.readLine());
        int[] dev = new int[n];
        System.out.println("Enter Device priorities:");
        for (int i = 0; i < dev.length; i++) 
            dev[i] = Integer.parseInt(hp.readLine());               
        for (int i = 0; i < dev.length; i++) {
            int max = 0;
            for (int j = i; j < dev.length; j++) 
                if(dev[j]>dev[max])
                    max = j;                                        
            System.out.println("Device "+(max+1)+" is selected");
            System.out.println("Enter no. of bits:");
            int bits = Integer.parseInt(hp.readLine());
            for (int j = bits-1; j > 0 ; j--) 
                System.out.println(j);                            
            System.out.println("Transfer Completed");
            System.out.println("Device "+(max+1)+" released");
            dev[max] = 0;
            
        }
    }

}
