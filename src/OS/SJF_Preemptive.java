package OS;

import java.io.DataInputStream;
import java.io.IOException;

public class SJF_Preemptive {

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
        System.arraycopy(bt, 0, tat, 0, n);
        System.out.print("| ");
        sum[0] = 0;
        int prev = 0, count = 0, min = 0, j = 0;
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < n && flag; i++) {
                for (int k = 0; at[k] <= count; k++) {
                    max = k;
                    if (bt[k] != 0) 
                        min = k;
                    if (k + 1 == n) 
                        break;
                }
                for (int k = 0; k <= max; k++) 
                    if (bt[k] < bt[min] && bt[k] != 0) 
                        min = k;
                bt[min]--;
                if (prev != process[min]) {
                    sum[j++] = count;
                    wt[min] = count - at[min];
                    prev = process[min];
                    System.out.print(process[min] + " |");
                }
                at[min]++;
                count++;
                flag = false;
                for (int k = 0; k < n; k++) 
                    if (0 < bt[k]) 
                        flag = true;
            }
        }
        System.out.print("\n");
        for (int i = 0; i < j; i++) 
            System.out.print(sum[i] + "   ");
        System.out.print(count);
        for (int i = 0; i < n; i++) {
            tat[i] += wt[i];
            ttat += tat[i];
            twt += wt[i];
        }
        System.out.print("\nTotal Waiting time: " + twt + " Total Turnaround time: " + ttat);
    }
}
