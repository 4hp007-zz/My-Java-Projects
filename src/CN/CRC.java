/*CRC Error Detection Program*/
package CN;

import java.io.DataInputStream;
import java.io.IOException;

public class CRC {

    public static void run() throws IOException {

        DataInputStream din = new DataInputStream(System.in);

//Sender's End
        System.out.print("Enter Divisor: ");
        int[] d = convert(din.readLine());

        System.out.print("Enter Message: ");
        int[] m1 = convert(din.readLine());

//Add Divisor-1 Bits of 0's to Message
        int[] mr = new int[m1.length + d.length - 1];
        System.arraycopy(m1, 0, mr, 0, m1.length);
        for (int i = m1.length; i < d.length; i++)
            mr[i] = 0;

        mr = divide(d, mr);

//Add Message to Remainder
        for (int i = 0; i < m1.length; i++)
            mr[i] = mr[i] + m1[i];

        System.out.println("Message to be sent is: ");
        for (int i = 0; i < mr.length; i++)
            System.out.print(mr[i]);

//Receiver's End
        System.out.print("\nEnter Received Message: ");
        m1 = convert(din.readLine());
        m1 = divide(d, m1);

//Checks if Remainder is 0
        boolean flag = true;
        for (int i = 0; i < m1.length; i++)
            if (m1[i] == 1)
                flag = false;

        if (flag == true)
            System.out.print("no error");
        else
            System.out.print("error");
    }

//Converting Decimal (String) to Binary (Integer Array)
    static int[] convert(String a) {

        int[] b = new int[a.length()];
        for (int i = 0; i < a.length(); i++) 
            if (a.charAt(i) == '1') 
                b[i] = 1;
            else 
                b[i] = 0;    
        return b;
    }

//Modulo-2 Division
    static int[] divide(int[] d, int[] m) {

        for (int i = 0; i <= m.length - d.length; i++)
            if (m[i] != 0)
                for (int j = 0; j < d.length; j++)
                    m[i + j] = m[i + j] ^ d[j];
        return m;
    }
}
