//Wolv - 4hp007@gmail.com

package DWM;

import java.io.*;

public class Agglomerative {

    public static void run() throws IOException {
        
        BufferedReader hp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no. of elements:");
        int n = Integer.parseInt(hp.readLine());
        System.out.println("Enter name of elements");
        String[] K = new String[n];
        for (int i = 0; i < K.length; i++) 
            K[i] = hp.readLine();                    
        System.out.println("Enter:\n1.Minimum link\n2.Average link\n3.Complete link");
        int a = Integer.parseInt(hp.readLine());
        int[][] adj = new int[n][];
        int d=0;        
        for (int i = 0; i < adj.length; i++) 
            adj[i] = new int[i+1];            
        System.out.println("Enter distances:");
        for (int i = 0; i < adj.length-1; i++) 
            for (int j = i+1; j < adj.length; j++) 
                adj[j][i] = Integer.parseInt(hp.readLine());     
        display(d++,K);             
        while(K.length>1){ 
            for (int i = 0; i < adj.length-1; i++) 
                for (int j = i+1; j < adj.length; j++) 
                    if(adj[j][i]==d){
                        adj = cluster(adj,i,j,a);
                        K = names(K,i,j);                          
                    }                                                       
            display(d,K);
            d=100;
            for (int i = 0; i < adj.length-1; i++) 
                for (int j = i+1; j < adj.length; j++) 
                    if(d>adj[j][i])
                        d=adj[j][i];   
        }         
    }
    
    public static String[] names(String[] k, int i,int j){
        
        String[] temp = new String[k.length-1];
        System.arraycopy(k, 0, temp, 0, j);
        temp[i] += k[j];
        System.arraycopy(k, j+1, temp, j, k.length-j-1);
        return temp;
    }

    public static int[][] cluster(int[][] adj, int i, int j, int a) {
        
        int[][] temp = new int[adj.length-1][];
        for (int k = 0; k < temp.length; k++) 
            temp[k] = new int[k+1];           
        for (int k = 0,m=0; k < temp.length; k++,m++)             
            for (int l = k,n=m; l < temp.length; l++,n++) {                  
                if(n==j)
                    n++;
                if(m==j)
                    m++;
                if(l==i&&k==i)
                    temp[l][k] = 0;
                else if(l==i)
                    temp[l][k] = link(adj[j][m],adj[j][m],a);                    
                else if(k==i)   
                    if(n>j)
                        temp[l][k] = link(adj[n][j],adj[n][i],a);   
                    else
                        temp[l][k] = link(adj[j][n],adj[n][i],a);                
                else 
                    temp[l][k] = adj[n][m];
            }            
        return temp;        
    }
    
    public static int link(int a, int b,int c){
        
        if(c==1)
            return a<b?a:b;
        else if(c==2)
            return (a+b)/2;
        else
            return a<b?b:a;
    }                       

    public static void display(int d, String[] K) {
        
        System.out.print("\nD = "+d+" k = "+K.length+" K = ");            
        for (int l = 0; l < K.length; l++) 
          System.out.print(" {"+K[l]+"} ");           
    }
}