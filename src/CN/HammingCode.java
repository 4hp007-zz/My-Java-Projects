package CN;

import java.io.DataInputStream;
import java.io.IOException;

public class HammingCode {

    public static void run() throws IOException {

        DataInputStream din = new DataInputStream(System.in);

//Sender's Side        
        System.out.print("Enter number of data bits: ");
        int n = Integer.parseInt(din.readLine());
        System.out.print("Enter Data: ");
        int[] d = convert(din.readLine());

//Determining no. of Parity Bits        
        int r = 1;
        while (n + 1 > Math.pow(2, r) - r)
            r++;
        int[] a = new int[r + d.length];

//Placing Data Bits in position
        int x = 0;
        for (int i = 0, j = 0; i < a.length; i++) 
            if (Math.pow(2, x) == i + 1) {
                a[i] = 0;
                x++;
            } else {
                a[i] = d[j];
                j++;
            }
        
//Placing Parity Bits in Position        
        for (int i = 0; i < r; i++) {
            x = (int) Math.pow(2, i) - 1;
            for (int j = x; j < a.length; j = j + (i + 2)) {
                a[x] = a[x] + a[j];
                int k = x;
                while (k > 0 && j + 1 < a.length) {
                    j++;
                    a[x] = a[x] + a[j];
                    k--;
                }
            }
            if (a[x] % 2 == 0)
                a[x] = 0;
            else
                a[x] = 1;
        }

        System.out.print("The Haming Code is: ");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]);

//Receiver's End        
        System.out.print("\nEnter Received Data: ");
        a = convert(din.readLine());
        r = 1;
        while (n + 1 > Math.pow(2, r))
            r++;
        int[] x2 = new int[r];

        for (int i = 0; i < r; i++) {
            x = (int) Math.pow(2, i) - 1;
            for (int j = x; j < a.length; j = j + (i + 2)) {
                x2[i] = x2[i] + a[j];
                int k = x;
                while (k > 0 && j + 1 < a.length) {
                    j++;
                    x2[i] = x2[i] + a[j];
                    k--;
                }
            }
            if (x2[i] % 2 == 0)
                x2[i] = 0;
            else
                x2[i] = 1;
        }

        x = 0;
        for (int i = 0; i < r; i++)
            x = (int) (x + x2[i] * Math.pow(2, i));
        
        if (x == 0)
            System.out.print("no error");
        else
            System.out.println("Error is in bit no. " + x);
    }

    static int[] convert(String a) {

        int[] b = new int[a.length()];
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) == '1')
                b[i] = 1;
            else
                b[i] = 0;
        return b;
    }
}
