package OS;

import java.io.DataInputStream;
import java.io.IOException;

public class FIFO {

    public static void run() throws IOException {
        DataInputStream din = new DataInputStream(System.in);
        System.out.print("Enter no. of pages: ");
        int n = Integer.parseInt(din.readLine());
        System.out.print("Enter no. of frames: ");
        int m = Integer.parseInt(din.readLine());
        int page[] = new int[n];
        int f[] = new int[m];
        int p[] = new int[m];
        int front = 0, rear = -1, hit = 0, frame;
        for (int i = 0; i < m; i++) {
            p[i] = i;
            f[i] = 1000;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Enter page no.: ");
            page[i] = Integer.parseInt(din.readLine());
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (f[j] == page[i]) {
                    hit++;
                    flag = false;
                }
            }
            if (flag) {
                frame = p[front];
                front = (front + 1) % m;
                f[frame] = page[i];
                rear = (rear + 1) % m;
                p[rear] = frame;
            }
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
