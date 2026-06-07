package PSTDSA.Day8;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOut {
    static File file = new File("Logs.doc");

     public static void writeToFile() throws IOException {
        DataInputStream dis = new DataInputStream(System.in);
        FileOutputStream fos = new FileOutputStream(file);
        String each = "";
        while (!(each = dis.readLine()).equals("EOF")) {
            fos.write(each.getBytes());
        }
        fos.close();
        dis.close();

    }

    public static String readFromFile() throws IOException {
        FileInputStream fis = new FileInputStream(file);
        String line = "";
        int size = fis.available();
        byte[] temp = new byte[size];
        fis.read(temp);
        line = new String(temp);
        fis.close();
        return line;

    }

    public static void main(String[] args) throws IOException {
        // writeToFile();
       String content= readFromFile();
       System.out.println(content);
    }
}
