package OS;

import java.io.DataInputStream;
import java.io.IOException;

public class LFU {

    public static void run() throws IOException {
        DataInputStream din = new DataInputStream(System.in);
        System.out.print("Enter no. of pages: ");
        int n = Integer.parseInt(din.readLine());
        System.out.print("Enter no. of frames: ");
        int m = Integer.parseInt(din.readLine());
        int page[] = new int[n];
        int f[] = new int[m];
        int p[] = new int[50];
        int frame = m, min = 0, hit = 0, a = n;
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            f[i] = 49;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Enter page no.: ");
            page[i] = Integer.parseInt(din.readLine());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (f[j] == page[i]) {
                    p[page[i]]++;
                    hit++;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                a = (a + 1) % m;
                frame = a;
                for (int j = a, c = 0; c < m; j = (j + 1) % m, c++) {
                    if (p[f[frame]] > p[f[j]]) {
                        frame = j;
                    }
                }
                a = frame;
                f[frame] = page[i];
                p[f[frame]]++;
            }
            for (int j = 0; j < m; j++) {
                if (f[j] == 49) {
                    System.out.print("0 ");
                    continue;
                }
                System.out.print(f[j] + " ");
            }
            flag = true;
        }
        System.out.print("\nNumber of hits: " + hit);
    }
}
