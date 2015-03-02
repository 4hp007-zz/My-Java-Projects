/*CheckSum Error Detection Program*/
package CN;

import java.io.DataInputStream;
import java.io.IOException;

public class Checksum {

    public static void run() throws IOException {

        DataInputStream din = new DataInputStream(System.in);

//Sender's End
        System.out.print("Enter Number of data bits: ");
        int n = Integer.parseInt(din.readLine());

        System.out.println("Enter Data: ");
        int[] a = new int[n];

//Calculation of Sum
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(din.readLine());
            sum = sum + a[i];
        }
        convert(sum);

//Receiver's End
        System.out.print("Enter Number of received data bits: ");
        n = Integer.parseInt(din.readLine());

        System.out.println("Enter Data: ");
        a = new int[n];

//Calculation of Sum
        sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(din.readLine());
            sum = sum + a[i];
        }
        int chk = convert(sum);
        if (chk == 0)
            System.out.println("no error");
        else
            System.out.println("error");
    }

    static int convert(int a) {

        int[] b = new int[4];

//Decimal to Binary
        for (int i = 0; i < 4; i++) {
            b[i] = a % 2;
            a /= 2;
        }

        for (int i = 0; i < 4; i++) {
            b[i] = b[i] ^ (a % 2);
            a /= 2;
        }

//Binary to Decimal       
        a = 0;
        for (int i = 0; i < 4; i++)
            a = (int) (a + b[i] * Math.pow(2, i));
        System.out.println("Wrapped Sum is: " + a);

//1's Complement       
        for (int i = 0; i < 4; i++) 
            if (b[i] == 0)
                b[i] = 1;
            else
                b[i] = 0;

//Binary to Decimal        
        a = 0;
        for (int i = 0; i < 4; i++) 
            a = (int) (a + b[i] * Math.pow(2, i));
        System.out.println("Check Sum is: " + a);
        return a;
    }
}
