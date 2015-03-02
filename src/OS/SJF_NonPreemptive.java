package OS;

import java.io.DataInputStream;
import java.io.IOException;

public class SJF_NonPreemptive {

    public static void run() throws IOException {
        DataInputStream din = new DataInputStream(System.in);
        System.out.print("Enter total no. of Processes: ");
        int n = Integer.parseInt(din.readLine());
        int process[] = new int[n];
        int bt[] = new int[n];
        int sum[] = new int[50];
        int at[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];
        int max = 0, twt = 0, ttat = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Process no.: ");
            process[i] = Integer.parseInt(din.readLine());
            System.out.print("Arrival Time: ");
            at[i] = Integer.parseInt(din.readLine());
            System.out.print("Burst Time: ");
            bt[i] = Integer.parseInt(din.readLine());
        }
        System.out.print("| ");
        sum[0] = bt[0];
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; at[j] < sum[i - 1]; j++) {
                max = j;
                if (j + 1 == n)
                    break;
            }
            int min = i;
            for (int j = i + 1; j <= max; j++) 
                if (bt[j] < bt[min]) 
                    min = j;
            int temp = process[min];
            process[min] = process[i];
            process[i] = temp;
            temp = at[min];
            at[min] = at[i];
            at[i] = temp;
            temp = bt[min];
            bt[min] = bt[i];
            bt[i] = temp;
            wt[i] = sum[i - 1] - at[i];
            twt = twt + wt[i];
            sum[i] = sum[i - 1] + bt[i];
        }
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
            ttat = ttat + tat[i];
        }
        for (int i = 0; i < n; i++) 
            System.out.print(" " + process[i] + " |");
        System.out.print("\n" + 0 + "   ");
        for (int i = 0; i < n; i++) 
            System.out.print(sum[i] + "   ");
        System.out.print("twt" + twt + "ttat" + ttat);
    }
}
