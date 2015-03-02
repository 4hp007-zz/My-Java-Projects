package OS;

import java.io.DataInputStream;
import java.io.IOException;

public class RoundRobin {

    public static void run() throws IOException {
        DataInputStream din = new DataInputStream(System.in);
        System.out.print("Enter total no. of Processes: ");
        int n = Integer.parseInt(din.readLine());
        System.out.print("Enter time slice: ");
        int t = Integer.parseInt(din.readLine());
        int process[] = new int[n];
        int p[] = new int[n];
        int bt[] = new int[n];
        int sum[] = new int[50];
        int at[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];
        boolean flag = true;
        int count = 1,j = 1;
        for (int i = 0; i < n; i++) {
            System.out.print("Process no.: ");
            process[i] = Integer.parseInt(din.readLine());
            System.out.print("Arrival Time: ");
            at[i] = Integer.parseInt(din.readLine());
            System.out.print("Burst Time: ");
            bt[i] = Integer.parseInt(din.readLine());
        }
        System.arraycopy(bt, 0, tat, 0, n);
        sum[0] = 0;
        System.out.print("|");
        while (flag) {
            for (int i = 0; i < n && j < 50; i++) {
                if (0 < bt[i]) {
                    System.out.print(" " + process[i] + " |");
                    if (bt[i] < t) {
                        sum[j] = sum[j - 1] + bt[i];
                        wt[i] = sum[j - 1] - at[i];
                        bt[i] = 0;

                    } else {
                        bt[i] = bt[i] - t;
                        sum[j] = sum[j - 1] + t;
                        wt[i] = sum[j - 1] - at[i];
                        at[i] += 2;
                    }
                    count++;
                    j++;
                }
            }
            flag = false;
            for (int i = 0; i < n; i++) 
                if (0 < bt[i]) 
                    flag = true;
        }
        System.out.print("\n");
        for (int i = 0; i < j; i++) 
            System.out.print(sum[i] + "   ");
    }
}
