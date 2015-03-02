//Wolv - 4hp007@gmail.com
//Input Output files in root of folder My Java Projects

package SPCC;

import java.io.*;

public class lexicalAnalyser {

    public static void run() throws Exception {

        FileReader fr = new FileReader("test_input");
        FileWriter fw = new FileWriter("test_output");
        String[] terminal = {"{", ";", ",", ".", "}", "(", ")","[","]"};
        String[] operator = {"!", "*", "+", "-", "/", "&", "|", "="};
        String[] keywords = {"void", "int", "class", "public", "static"};        
        String token = "";
        int line = 1, a;    
        fw.write("Line no\t\t\tToken\t\t\t\tToken Type\n");
        while ((a = fr.read()) != -1) {           
            if ((a < '0' || a > '9') && (a < 'a' || a > 'z') && (a < 'A' || a > 'Z')) {
                if (search(keywords, token))
                    fw.write(line + "\t\t\t\t" + token + "\t\t\t\tKeyword\n");
                else if(!token.equals(""))
                        fw.write(line + "\t\t\t\t"+token + "\t\t\t\tIdentifier\n");                            
                token = "";
                if (a != 13 && a != 10 && a != 32)       //Ascii for new line & space
                    if (search(terminal, ""+(char)a))
                        fw.write(line + "\t\t\t\t" + (char)a + "\t\t\t\tTerminal\n");
                    else if (search(operator, ""+(char)a))
                        fw.write(line + "\t\t\t\t" +  (char)a + "\t\t\t\tOperator\n");                
            } 
            else
                token += (char) a;
            if (a == '\n')
                line++;
        }
        System.out.println("Process completed");
        fw.flush();
    }

    static boolean search(String[] a, String b) {
        for (int i=0;i<a.length;i++)
            if (b.equals(a[i]))
                return true;
        return false;
    }
}
