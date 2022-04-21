package Project3;

import javax.swing.*;
import java.awt.*;


public class T4 implements Runnable{
    private String name;
    private JLabel lab;
    private JLabel diver;
    private JLabel score;
    private JLabel timelab;
    JFrame main;
    Save save;

    private long n = 0;
    private int X = 270;
    private int Y = 190;
    private int Width = 20;
    private int Height = 20;
    private int i;
    private Thread t;
    private javax.swing.Timer timer;
    T4(String threadname, JLabel lab,javax.swing.Timer timer,JLabel diver,JLabel score, JLabel timelab,JFrame main){
        this.main = main;

        this.diver = diver;
        this.timelab= timelab;
        this.score = score;
        this.timer = timer;
        name = threadname;
        this.lab = lab;
        t = new Thread(this,name);
        t.start();


    }
    @Override
    public void run() {
        try{

            Thread.sleep(6000);
            while (true) {
                // Thread.sleep(1000);
                while(i<70) {

                    System.out.println(n);
                    Thread.sleep(5000-n);
                    i+=20;
                    lab.setBounds(X,Y,Width,Height+i);
                    lab.repaint();
                    lab.revalidate();
                    if(intersects(lab,diver)){
                        diver.setBounds(0,0,50,50);
                        diver.setVisible(false);
                        timer.stop();
                        System.out.println(score.getText());
                        save = new Save(score,timelab,main);

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
