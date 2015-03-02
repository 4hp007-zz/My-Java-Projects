package OS;

import java.io.DataInputStream;
import java.io.IOException;

public class LRU {

    public static void run() throws IOException {
        DataInputStream din = new DataInputStream(System.in);
        System.out.print("Enter no. of pages: ");
        int n = Integer.parseInt(din.readLine());
        System.out.print("Enter no. of frames: ");
        int m = Integer.parseInt(din.readLine());
        int page[] = new int[n];
        int f[] = new int[m];
        int p[] = new int[m];
        int frame = m, min = 0, hit = 0;
        for (int i = 0; i < m; i++) {
            p[i] = m - i;
            f[i] = 1000;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Enter page no.: ");
            page[i] = Integer.parseInt(din.readLine());
        }
        for (int i = 0; i < n; i++) {
            frame = m;
            for (int j = 0; j < m; j++) {
                if (f[j] == page[i]) {
                    frame = j;
                    hit++;
                    break;
                }
            }
            if (frame == m) {
                frame = 0;
                for (int j = 0; j < m; j++) {
                    if (p[frame] < p[j]) {
                        frame = j;
                    }
                }
            }
            f[frame] = page[i];
            for (int j = 0; j < m; j++) {
                if (p[j] < p[frame]) {
                    p[j]++;
                }
            }
            p[frame] = 1;
            for (int j = 0; j < m; j++) {
                if (f[j] == 1000) {
                    System.out.print("0 ");
                    continue;
                }
                System.out.print(f[j] + " ");
            }
        }
        System.out.print("\nNumber of hits: " + hit);
    }
}
