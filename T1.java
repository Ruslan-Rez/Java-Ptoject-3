package Project3;

import javax.swing.*;
import java.awt.*;
public class T1 implements Runnable{
    private String name;
    private JLabel lab;
    private JLabel diver;
    private JLabel score;
    private JLabel timelab;
    JFrame main;
    Save save;
    private long n = 0;
    private int X = 140;
    private int Y = 136;
    private int Width = 20;
    private int Height = 20;
    private int i;
    private Thread t;
    private javax.swing.Timer timer;
    T1(String threadname, JLabel lab, javax.swing.Timer timer,JLabel diver,JLabel score,JLabel timelab,JFrame main){
        this.main = main;
        this.timelab = timelab;
        this.score = score;
        this.diver = diver;
        this.timer = timer;
        name = threadname;
        this.lab = lab;
        t = new Thread(this,name);
        t.start();


    }
    @Override
    public void run() {
        try{

            Thread.sleep(1000);
            while (true) {
                while(i<100) {
                    Thread.sleep(3000-n);
                    i+=20;
                    lab.setBounds(X-i,Y,Width+i,Height);
                    lab.repaint();
                    lab.revalidate();
                    if(intersects(lab,diver)){
                        timer.stop();
                        save = new Save(score,timelab,main);
                        diver.setBounds(0,0,50,50);
                        diver.setVisible(false);
                    }
                }
                i=-10;
                lab.setBounds(X-i,Y,Width+i,Height);
                lab.repaint();
                lab.revalidate();


            }
        } catch (InterruptedException |IllegalMonitorStateException e) {
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
