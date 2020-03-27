package org.andestech.learning.sber2020.io;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class IOTest {


    public static void main(String[] args) {
          String f1 = "c:\\data\\file1.txt";

             File file = new File (f1);
         try {
             //file.createNewFile();
             //File dir = new File("c:\\data\\d2\\d3\\d4");
             //dir.mkdirs();
             Files.write(Paths.get(f1),"САЛЮТ!!!\r\n".getBytes(),
                     StandardOpenOption.APPEND);
             Files.copy(Paths.get(f1), Paths.get("c:\\data\\file2.txt"),
                     StandardCopyOption.REPLACE_EXISTING);

             for (String line:
             Files.readAllLines(Paths.get(f1), Charset.defaultCharset()) ) {
                 System.out.println(line);
             }

         }catch (IOException ex){
             System.out.println(ex);
         }

    }
}
