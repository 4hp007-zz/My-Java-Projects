//Wolv - 4hp007@gmail.com

package SPCC;

import java.io.*;

public class LL1_First_Follow {

    public static void run() throws IOException {

        BufferedReader hp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no. of rules:");
        int n = Integer.parseInt(hp.readLine());
        String[] T = new String[n];
        String[] nt = new String[n];
        String[] First = new String[n];
        System.out.println("Enter Rules:");
        boolean flag,f1;
        for (int i = 0; i < n; i++) {
            String[] temp = hp.readLine().split("=");
            T[i] = temp[0];
            nt[i] = temp[1];
        }         
//First Function              
        for (int l = 0; l < n; l++) {                    
            for (int i = 0; i < n; i++) {                 
                int k = 0;
                do {
                    char a = nt[i].charAt(k);
                    f1 = flag = false;                    
                    if (a >= 'a' && a <= 'z'){
                        First[i] = ""+a;      
                        f1=true;
                    }
                    else if (nt[i].equals("$"))
                        First[i] = nt[i];                           
                    else if (a >= 'A' && a <= 'Z')
                        for (int j = 0; j < n; j++)
                            if (a == T[j].charAt(0) && First[j] != null)
                                if (!First[j].equals("$"))
                                    if (First[i] == null)
                                        First[i] = First[j];
                                    else
                                        First[i] += "|" + First[j];
                                else
                                    flag = true;
                    k++;
                } while (flag);
                if (k > 1&&!f1)
                    First[i] += "|$";
            }
        }
        for (int i = 0; i < First.length; i++) {
            int a = First[i].lastIndexOf(First[i].charAt(0));
            First[i] = First[i].substring(a);            
        }                    
        for (int k=0; k < T.length;) {
            String temp = First[k++];
            while(k<T.length&&T[k-1].equals(T[k]))
                temp = combine(temp,First[k++]);            
            System.out.println(T[k-1]+"->"+temp);            
        }
//Follow Function
        String a="";
        String[] Follow = new String[n];
        for (int i = 0; i < Follow.length; i++) {
            if (T[i].equals(a))
                continue;
            a = T[i];
            for (int j = 0; j < Follow.length; j++) 
                for (int k = 0; k < nt[j].length(); k++) 
                    if (T[i].charAt(0) == nt[j].charAt(k)) 
                        do {
                            flag = false;
                            k++;
                            if (k < nt[j].length()) 
                                if (nt[j].charAt(k) >= 'a' && nt[j].charAt(k) <= 'z')
                                    if(Follow[i]==null)
                                        Follow[i] = ""+nt[j].charAt(k);
                                    else
                                       Follow[i] += "|" + nt[j].charAt(k); 
                                else 
                                    for (int l = 0; l < Follow.length; l++) 
                                        if (nt[j].charAt(k) == T[l].charAt(0)) {
                                            if (Follow[i] == null)
                                                Follow[i] = First[l];
                                            else
                                                Follow[i] += "|" + First[l];
                                            if (First[l].charAt(0) == '$')
                                                flag = true;
                                        }                           
                        } while (flag);
        }
        System.out.println("Follow");
        for (int i = 0; i < Follow.length; i++) 
            if(Follow[i]==null)
                Follow[i]="#";                                 
        for (int k=0; k < T.length;) {
            String temp = Follow[k++];
            while(k<T.length&&T[k-1].equals(T[k]))
                temp = combine(temp,Follow[k++]);            
            System.out.println(T[k-1]+"->"+temp);            
        }
    }

    public static String combine(String a, String b) {
        
        String c = a;
        String[] t1 = a.split("|");
        String[] t2 = b.split("|");
        for (int i = 0; i < t2.length; i++) {            
            boolean flag = true;
            for (int j = 0; j < t1.length; j++)               
                if (t1[j].equals(t2[i]))
                    flag = false;            
            if (flag)
                c += "|" + t2[i];
        }
        return c;
    }
}

/*
output

Enter no. of rules:
4
Enter Rules:
S=AaAb
S=BaBb
A=$
B=$
S->a
A->$
B->$
Follow
S->#
A->a|b
B->a|b

*/
