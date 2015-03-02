
package SS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 4hp007
 */
public class RSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        long p = 10 + (long) (Math.random()*100);
        long q = 10 + (long) (Math.random()*100);
        p = prime(p);
        q = prime(q);
        long n = p*q;
        long phin = (p-1)*(q-1);
        long e = (long) (10 + Math.random()*100); 
        e = coprime(e,phin);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        char[] pt = a.toCharArray();
        long pt1[] = new long[pt.length];
        for (int i = 0; i < pt1.length; i++) {
            pt1[i]=pt[i];
            
        }
        for (int i = 0; i < pt.length; i++) {
            
            pt1[i] = (char) ( Math.pow(pt1[i], e)%n);
        }
        long d = 0;
        for (int i = 0; i < phin; i++) {
            if((e*i)%phin==1) {
                
                d=i;
                break;
            }
            
        }
        
        System.out.println(p);
        System.out.println(q);
        System.out.println(n);
        System.out.println(phin);
        System.out.println(e);
        System.out.println(d);
       /* for (int i = 0; i < pt.length; i++) {
            System.out.println(pt1[i]);
            
        }
        for (int i = 0; i < pt.length; i++) {
            
            pt1[i] = (char) (Math.pow(pt1[i], d)%n);
        }
        for (int i = 0; i < pt.length; i++) {
            System.out.println(pt1[i]);
            
        }*/
        System.out.println("");
        long x = 65;
        x = (long) ( Math.pow(x, e)%n);
        System.out.println(x);
        System.out.println(d/100);
        System.out.println(Math.pow(2, d));
        long s=1;
        for (int i = 0; i < 100; i++) {
            
            s =  s*(long) ( Math.pow(x,d/100)%n);
            //x = (x*x)%n;
        }
        
        System.out.println(s%n);
    }
    static long prime(long p) {
        
        if(p%2==0)
            return prime(p+1);
        for (int i = 3; i < Math.sqrt(p); i+=2) {
            
            if(p%i==0)
                return prime(p+1);
            
        }
        return p;
    }
    static long coprime(long e,long phi){
        
        for (int i = 2; i < phi/2; i++) {
            if(e%i==0&&phi%i==0)
                return coprime(e+1,phi);
            
        }
        return e;
    }
}
