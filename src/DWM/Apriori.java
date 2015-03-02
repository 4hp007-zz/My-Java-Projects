//Wolv - 4hp007@gmail.com

package DWM;

import java.io.*;
import java.sql.*;

public class Apriori {

    public static void run() throws Exception{
                
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:odbc:DWM");
        PreparedStatement stmt = conn.prepareStatement("Select * from AP");
        ResultSet rs = stmt.executeQuery();
        int n=0;
        while(rs.next())
            n++;
        String[] T = new String[n];
        rs=stmt.executeQuery();
        while(rs.next())
            T[--n] = rs.getString(2);        
        boolean f1 = true,f;
        String st = "1";
        int c=1;
        while(f1){
            f1 = false;
            for (int i = 0; i < T.length; i++) {
                f = check(st,T[i]);
                if(f){
                    f1=true;                   
                    st = ""+(++c);
                }                
            }            
        } 
        BufferedReader hp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter minimum support items out of "+(T.length));
        int s = Integer.parseInt(hp.readLine());
        int t = c-1, h = 0,k;
        String[] item = new String[t];
        int[] I = new int[t];
        for (int i = 0; i < item.length; i++)
            item[i] = "" + (i + 1);
        while (true) {
            for (int i = 0; i < item.length; i++)
                for (int j = 0; j < T.length; j++)
                    if (check(item[i], T[j]))
                        I[i]++;
            System.out.println("C"+(h+1));            
            for (int i = 0; i < I.length; i++)                
                    System.out.println(item[i] + "=" + I[i]);
            System.out.println("L"+(h+1));
            for (k = 0; k < I.length; k++)
                if(I[k]>=s)
                    System.out.println(item[k] + "=" + I[k]);
            int a = 0;
            String[] temp = new String[(k-1) * (k) / 2 ];
            for (int i = 0; i < I.length; i++)
                if (I[i] >= s)
                    for (int j = i + 1; j < I.length; j++)
                        if (I[j] >= s) {
                            temp[a] = combine(item[i], item[j]);
                            if (temp[a].length() > 0 && temp[a].length() < 2 * (h + 2))
                                a++;
                        }     
            int b = a;
            for (int i = 0; i < b-1; i++)  
                for (int j = i+1; j < a; j++) 
                    if (check(temp[i],temp[j])) {                  
                        for (int l = j; l < a-1; l++) 
                            temp[l] = temp[l+1];                                            
                        b--;
                    }         
            if (b <= 0)
                break;
            item = new String[b];
            I = new int[b];
            System.arraycopy(temp, 0, item, 0, b);            
            h++;            
        }
    }

    public static String combine(String a, String b) {

        String c = a;
        String[] t1 = a.split(",");
        String[] t2 = b.split(",");
        for (int i = 0; i < t2.length; i++) {            
            boolean flag = true;
            for (int j = 0; j < t1.length; j++)               
                if (t1[j].equals(t2[i]))
                    flag = false;            
            if (flag)
                c += "," + t2[i];
        }                           
        return c;
    }

    public static boolean check(String a, String b) {

        String[] t1 = a.split(",");
        String[] t2 = b.split(",");
        boolean flag[] = new boolean[t1.length];
        for (int i = 0; i < t1.length; i++)                    
            for (int j = 0; j < t2.length; j++)                
                if (t1[i].equals(t2[j]))                 
                    flag[i] = true;                                    
        for (int i = 0; i < flag.length; i++)
            if (flag[i] == false)
                return false;
        return true;
    }

}
