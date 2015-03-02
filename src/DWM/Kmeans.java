//Wolv - 4hp007@gmail.com

package DWM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kmeans {

    public static void run() throws IOException {

        BufferedReader hp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter total no. of elements:");
        int n = Integer.parseInt(hp.readLine());
        System.out.println("Enter Elements:");
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++)
            a[i] = Integer.parseInt(hp.readLine());
        System.out.println("Enter no. of clusters:");
        int k = Integer.parseInt(hp.readLine());
        int[][] m = new int[2][k];        
        System.arraycopy(a, 0, m[1], 0, k);
        boolean flag;
        do {
            int[][] temp = new int[k][n];
            int[] l = new int[k];
            for (int i = 0; i < n; i++) {
                int b = 0, min = Math.abs(m[1][0] - a[i]);
                for (int j = 1; j < k; j++)
                    if (min > Math.abs(m[1][j] - a[i])) {
                        b = j;
                        min = Math.abs(m[1][j] - a[i]);
                    }
                temp[b][l[b]++] = a[i];
            }
            flag = false;
            System.out.println("Mean:");
            for (int i = 0; i < k; i++) {
                m[1][i] = 0;
                for (int j = 0; j < l[i]; j++)
                    m[1][i] += temp[i][j];
                m[1][i] /= l[i];
                if (m[1][i] != m[0][i])
                    flag = true;
                m[0][i] = m[1][i];
                System.out.println("M" + (i + 1) + " = " + m[1][i]);
            }
            System.out.println("Clusters:");
            for (int i = 0; i < k; i++) {
                System.out.print("K" + (i + 1) + "{");
                for (int j = 0; j < l[i]; j++)
                    System.out.print(" " + temp[i][j] + " ");
                System.out.println("}");
            }
        }while(flag);
    }
}
