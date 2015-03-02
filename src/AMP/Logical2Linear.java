//Wolv - 4hp007@gmail.com

package AMP;

import java.io.*;

public class Logical2Linear {

    public static void run() throws IOException {
        
        
        String[] gdt = new String[10];
        String[] ldt = new String[10];
        for (int i = 0; i < 10; i++) {
            gdt[i] = ldt[i] = "";
            for (int j = 0; j < 32; j++) {                                            
                gdt[i] += (int)(Math.random()*100)%2;
                ldt[i] += (int)(Math.random()*100)%2;            
            }
        }
        System.out.println("Global Descriptor Table");
        for (int i = 0; i < ldt.length; i++) 
            System.out.println((i+1)+" : "+gdt[i]);
        System.out.println("Local Descriptor Table");
        for (int i = 0; i < ldt.length; i++) 
            System.out.println((i+1)+" : "+ldt[i]);        
        BufferedReader hp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 16 bit selector:");
        String sel = hp.readLine();
        System.out.println("Enter 32 bit offset:");
        String off = hp.readLine();
        String str = "";
        for (int i = 0; i < 13; i++) 
            str += sel.charAt(i);              
        int a  = Integer.parseInt(str, 2);
        System.out.println("Selector address is: "+a                                                             );
        int l,k=0;
        if(sel.charAt(13)=='0'){
            
            for (int i = 0; i < gdt.length; i++) 
                if(gdt[a].charAt(i)=='1'){
                    k=i;
                    break;
                }                                                
            l = Integer.parseInt(gdt[a].substring(k),2)+Integer.parseInt(off,2);
        }
        else {
            for (int i = 0; i < gdt.length; i++) 
                if(gdt[a].charAt(i)=='1'){
                    k=i;
                    break;
                }            
            l = Integer.parseInt(ldt[a].substring(k),2)+Integer.parseInt(off,2);
        }
        str = Integer.toBinaryString(l);
        String x = "";
        System.out.println("Linear Address is:");
        for (int i = 0; i < 32-str.length(); i++) 
            x = "0";
        x += str;
        System.out.println(x);
    }

}
