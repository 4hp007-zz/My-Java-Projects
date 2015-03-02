//Wolv - 4hp007@gmail.com

package DWM;

import java.sql.*;

public class DecisionTree {

    public static void run() throws Exception {
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:odbc:DWM");
        PreparedStatement stmt = conn.prepareStatement("Select * from DT");
        ResultSet rs = stmt.executeQuery();
        double t=0;
        while(rs.next())
            t++;
        rs.close();
        stmt.close();
        conn.close();
        double o;
        double[] gain = new double[4];
        o= calc("Outlook=","'sunny'",t);        
        o+=calc("Outlook=","'overcast'",t);                
        o+= calc("Outlook=","'rain'",t);
        System.out.println("Entropy is "+o);
        System.out.println("Overall Gain is "+(gain[0]=0.94-o)+"\n");
        o = calc("Temp=","'hot'",t);      
        o += calc("Temp=","'mild'",t);    
        o += calc("Temp=","'cool'",t);
        System.out.println("Entropy is "+o);
        System.out.println("Overall Gain is "+(gain[1]=0.94-o)+"\n");
        o += calc("Humidity=","'high'",t);  
        o += calc("Humidity=","'normal'",t); 
        System.out.println("Entropy is "+o);
        System.out.println("Overall Gain is "+(gain[2]=0.94-o)+"\n");
        o += calc("Wind=","'weak'",t);     
        o += calc("Wind=","'strong'",t);
        System.out.println("Entropy is "+o);
        System.out.println("Overall Gain is "+(gain[3]=0.94-o)+"\n");
        double max=gain[0];
        int j=0;
        for (int i = 1; i < gain.length; i++) 
            if(gain[i]>max)
                j=i;
        if(j==0)
            System.out.println("Root is Outook");
        else if(j==1)
            System.out.println("Root is Temperature");
        else if(j==2)
            System.out.println("Root is Humidity");
        else
            System.out.println("Root is Wind");        
    }
    
    static double calc(String a,String b,double t) throws Exception{
        
        double y=0,n=0;
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:odbc:DWM");
        PreparedStatement stmt = conn.prepareStatement("select * from DT where "+a+b+" and Play='yes'");
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
            y++;        
        stmt = conn.prepareStatement("select * from DT where "+a+b+" and Play='no'");
        rs = stmt.executeQuery();
        while(rs.next())
            n++;
        rs.close();
        stmt.close();
        conn.close();
        double gain = -(y/(y+n)*Math.log(y/(y+n))/Math.log(2))-(n/(y+n)*Math.log(n/(y+n))/Math.log(2));
        if(Double.isNaN(gain))
            gain=0.0;
        System.out.println(b+" gain is "+gain);
        return (y+n)/t*gain;        
    }
}
