//Wolv - 4hp007@gmail.com

package AMP;

import java.io.*;

public class RegWindow {

    public static void run() throws IOException {
        
        BufferedReader hp = new BufferedReader(new InputStreamReader(System.in));
        int[] in = new int[10];
        int [] local = new int[10];
        int[] out = new int[10];
        for (int i = 0; i < out.length; i++) {
            in[i] = (int)(Math.random()*100);
            local[i] = (int)(Math.random()*100);
            out[i] = (int)(Math.random()*100);            
        }
        String a;
        while(true) {
            System.out.print("in = { ");
            for (int i = 0; i < in.length; i++) 
                System.out.print(" "+in[i]+" ");                    
            System.out.println("}");
            System.out.print("local = { ");
            for (int i = 0; i < in.length; i++) 
                System.out.print(" "+local[i]+" ");                    
            System.out.println("}");
            System.out.print("out = { ");
            for (int i = 0; i < in.length; i++) 
                System.out.print(" "+out[i]+" ");                    
            System.out.println("}");
            System.out.println("Do you want to continue(y/n)?");
            a = hp.readLine();
            if(a.equals("n"))
                break;
            for (int i = 0; i < out.length; i++) {
                in[i] = out[i];
                local[i] = (int)(Math.random()*100);
                out[i] = (int)(Math.random()*100);
            
            }                                           
        } 
        
    }

}
