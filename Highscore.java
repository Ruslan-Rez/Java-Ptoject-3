package Project3;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class Highscore extends AbstractTableModel {
    Vector data;
    Vector columns;

    public Highscore() {
        String line;
        data = new Vector();
        columns = new Vector();
        try {
            FileInputStream fis = new FileInputStream("scores.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            while (st1.hasMoreTokens())
                columns.addElement(st1.nextToken());
            while ((line = br.readLine()) != null) {
                StringTokenizer st2 = new StringTokenizer(line, " ");
                while (st2.hasMoreTokens())
                    data.addElement(st2.nextToken());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        return data.size() / getColumnCount();
    }

    public int getColumnCount() {
        return columns.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return (String) data.elementAt((rowIndex * getColumnCount())
                + columnIndex);
    }

}