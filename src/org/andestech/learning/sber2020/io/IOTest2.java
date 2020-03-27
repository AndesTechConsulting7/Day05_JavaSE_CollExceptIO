package org.andestech.learning.sber2020.io;

import org.andestech.learning.sber2020.Book;

import static org.andestech.learning.sber2020.utils.ABSUtils.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
//import  java.io.


public class IOTest2 {


    public static void main(String[] args) {
          String f1 = "c:\\data\\file3.txt";

          try(FileWriter fw = new FileWriter(f1))
          {
              fw.write("Hi! Привет!\r\n");
          }
          catch (IOException ex)
          {
              System.out.println(ex);
          }
// reader
        try(FileReader fr = new FileReader(f1))
        {
            int ch;
            while((ch = fr.read())!= -1){
                System.out.print((char)ch);
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }

// Streams
        String f4 = "c:\\data\\file4.txt";

        try(FileOutputStream fos = new FileOutputStream(f4))
        {
           byte[] barr = "Hello!\r\nПривет!\r\nСалют!".getBytes("UTF-8");
           fos.write(barr);
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }

        // reader
        try(FileInputStream fis = new FileInputStream(f4))
        {
            byte[] barr = new byte[fis.available()];
            fis.read(barr);
            // decode to text (if file is text!!)
            String content = new String(barr, "UTF-8");
            echo();
            System.out.println(content);
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }

     //-------------------------------------------

        String f5 = "c:\\data\\file5.bin";

        try( DataOutputStream dos = new DataOutputStream(new FileOutputStream(f5)))
        {
            dos.writeDouble(12.21111111555);
            dos.writeByte(12);
            dos.writeInt(-477777);
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }

        try( DataInputStream dis = new DataInputStream(new FileInputStream(f5)))
        {
            echo();
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readByte());

        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }

       // Object stream
        Book book1 = new Book(1287987, "Джек Лондон", "Белое Безмолвие",
                "978-3-16-148410-0", 1921);
        Book book2=   new Book(5409680, "Лев Толстой", "Крейцерова Соната",
                "4553-0-14-144444-2", 1901);
        Book book3=  new Book(54213421, "Лев Толстой",
                "Отец Сергий", "4452-1-12-984544-7", 1909);

        List<Book> library = new ArrayList<>();
        library.add(book1);
        library.add(book2);
        library.add(book3);
        for (Book b: library) System.out.println(b);

        String flib = "c:\\data\\library.bin";
        try( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(flib)))
        {
         oos.writeObject(library);
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }

        // Object reader








    }
}
