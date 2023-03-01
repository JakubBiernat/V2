import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MatSearch {

    ArrayList<Steel> steellist = new ArrayList<>();

    MatSearch() {

        dataReader();
        new FrameA(steellist);
    }

    public void dataReader() {

        String line;
        String path1 = null;
        String path2 = null;

        //Ferritic steel data 
        try {
            File p = new File("FerriticStainlessSteel.txt");
            path1 = p.getAbsolutePath();
            FileReader readerF = new FileReader(p);
            BufferedReader reader = new BufferedReader(readerF);

            while ((line = reader.readLine()) != null) {

                String[] lista = line.split("//");

                FerriticStainlessSteel ss = new FerriticStainlessSteel(lista[0], lista[1], lista[2], lista[3]);

                steellist.add(ss);

            }
            reader.close();
            readerF.close();

        } catch (Exception e) {
            System.out.println("Not all data has been loaded, please check input file:");
            //System.out.println("Each line should consist of 4 records");
            System.out.println(path1);
            System.out.println("Details:");
            e.printStackTrace();
        }
        //Austenitic steel data 
        try {
            File p = new File("AusteniticStainlessSteel.txt");
            path2 = p.getAbsolutePath();
            FileReader readerF = new FileReader(p);
            BufferedReader reader = new BufferedReader(readerF);

            while ((line = reader.readLine()) != null) {

                String[] lista = line.split("//");

                AusteniticStainlessSteel as = new AusteniticStainlessSteel(lista[0], lista[1], lista[2], lista[3]);

                steellist.add(as);

            }
            reader.close();
            readerF.close();

        } catch (Exception e) {
            System.out.println("Not all data has been loaded, please check input file:");
            //System.out.println("Each line should consist of 4 records");
            System.out.println(path2);
            System.out.println("Details:");
            e.printStackTrace();
        }
    }
}

