//Wolv - 4hp007@gmail.com

package ACN;

import java.io.*;

public class DVR {

    public static void run() throws IOException {

        BufferedReader hp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter total number of nodes:");
        int n = Integer.parseInt(hp.readLine());
        int[][][] a = new int[n][n][n];
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) 
            for (int j = i + 1; j < n; j++) {
                System.out.println("Enter distance between " + (i + 1) + " and " + (j + 1));
                a[i][j][j] = a[j][i][i] =Integer.parseInt(hp.readLine());
                if (a[i][j][j] != 0)
                    adj[i][j] = adj[j][i] = 1;       
            }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 0; j < adj.length; j++) 
                for (int k = 0; k < adj.length; k++) 
                    if (j != k) 
                        for (int l = 0; l < adj.length; l++)                             
                            if (j != l && k != l && adj[j][k]==1) {
                                int x = min(a[k][l]);                                           
                                int y = a[j][k][k];
                                if((a[j][l][k]>x+y||a[j][l][k]==0)&&x!=0){
                                    flag = true;
                                    a[j][l][k]=x+y;
                                }
                            }   
        }
        for (int i = 0; i < adj.length; i++) {
            System.out.println("Router "+(i+1));
            for (int j = 0; j < adj.length; j++) {             
                for (int k = 0; k < adj.length; k++) 
                    System.out.print(""+a[i][j][k]+"\t");  
                System.out.println("");
            }
        }
    }
    
    public static int min(int[] a){
        
        int min = 1000;
        for (int i = 0; i < a.length; i++) 
            if(a[i]<min&&a[i]!=0)
                min=a[i];     
        if(min==1000)
            return 0;
        return min;                
    }

}


/*
Enter total number of nodes:
4
Enter distance between 1 and 2
3
Enter distance between 1 and 3
23
Enter distance between 1 and 4
0
Enter distance between 2 and 3
2
Enter distance between 2 and 4
0
Enter distance between 3 and 4
5
Router 1
0	0	0	0	
0	3	25	0	
0	5	23	0	
0	10	28	0	
Router 2
3	0	7	0	
0	0	0	0	
8	0	2	0	
13	0	7	0	
Router 3
23	5	0	15	
26	2	0	12	
0	0	0	0	
33	9	0	5	
Router 4
0	0	10	0	
0	0	7	0	
0	0	5	0	
0	0	0	0	
*/



