package Project3;

import javax.swing.*;
import java.awt.*;

public class T2 implements Runnable{
    private String name;
    private JLabel lab;
    private JLabel diver;
    private JLabel score;
    private JLabel timelab;
    JFrame main;
    Save save;
    private int X = 160;
    private int Y = 165;
    private int Width = 20;
    private int Height = 20;
    private int i;
    private long n;
    private Thread t;
    private javax.swing.Timer timer;
    T2(String threadname, JLabel lab,javax.swing.Timer timer,JLabel diver, JLabel score, JLabel timelab,JFrame main){
        this.main = main;
        this.diver = diver;
        this.score = score;
        this.timelab = timelab;
        this.timer = timer;
        name = threadname;
        this.lab = lab;
        t = new Thread(this,name);
        t.start();


    }
    @Override
    public void run() {
        try{

            Thread.sleep(2000);
            while (true) {
               // Thread.sleep(1000);
                while(i<140) {
                    Thread.sleep(3000-n);
                    i+=20;
                    lab.setBounds(X,Y,Width,Height+i);
                    lab.repaint();
                    lab.revalidate();
                    if(intersects(lab,diver)){
                        diver.setBounds(0,0,50,50);
                        diver.setVisible(false);
                        timer.stop();
                        save = new Save(score,timelab,main);
                        System.out.println(score.getText());
                    }
                }
                i=-10;
                lab.setBounds(X,Y,Width,Height+i);
                lab.repaint();
                lab.revalidate();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public boolean intersects (JLabel a , JLabel b){
        Rectangle rectb = b.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(a.getX(),a.getY(),a.getWidth(),a.getHeight(),rectb);
        return (result.getWidth() >0 && result.getHeight() >0);
    }
    public void setn(long n){
        this.n = n;
    }
}


