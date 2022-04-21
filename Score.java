package Project3;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Score implements Runnable{
    private String name;
    private AtomicInteger counter = new AtomicInteger(0);
    JLabel score;
    JLabel diver;
    JLabel timelab;
    JFrame main;
    Save save;
    ImageIcon good;
    ImageIcon bad;
    private Thread t;
    private javax.swing.Timer timer;
    T4 t4;
    T1 t1;
    T2 t2;
    T3 t3;
    Ecol ecol = Ecol.Empty;

    Score(String threadname, JLabel score,JLabel diver,javax.swing.Timer timer,JLabel timelab,T4 t4,T1 t1,T2 t2, T3 t3,JFrame main){
        this.main = main;
        this.t2 = t2;
        this.t3 = t3;
        this.t1 = t1;
        this.t4 = t4;
        this.score = score;
        this.diver = diver;
        this.timer = timer;
        this.timelab = timelab;
        name = threadname;
        t = new Thread(this,name);
        t.start();

    }
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    score.setText(String.valueOf(counter));
                    good = new ImageIcon("good.JPG");
                    bad = new ImageIcon("bad.JPG");
                    if(diver.getY()<=60){
                        diver.setLocation(diver.getX(), diver.getY()+30);
                        if(ecol == Ecol.Full) {
                            counter.getAndAdd(2);
                            score.repaint();
                            score.revalidate();
                            System.out.println("Score:" + counter);
                            ecol = Ecol.Empty;
                            diver.setIcon(bad);
                        }

                    }
                    if(diver.getX() == 270){
                        diver.setLocation(diver.getX()-30, diver.getY());

                        counter.getAndIncrement();
                        score.repaint();
                        score.revalidate();
                        System.out.println("Score:"+counter);
                        ecol = Ecol.Full;
                        diver.setIcon(good);
                    }
                    if(counter.get()>=30 && counter.get()<60){
                        t1.setn(1000);
                        t4.setn(2000);
                        t2.setn(1000);
                        t3.setn(1500);
                    }
                    if(counter.get()>=60 && counter.get()<80){
                        t1.setn(2000);
                        t4.setn(4000);
                        t2.setn(2000);
                        t3.setn(3000);
                    }
                    if(counter.get()>=80){
                        t1.setn(2500);
                        t4.setn(4500);
                        t2.setn(2500);
                        t3.setn(3500);
                    }
                    if(counter.get()>=99){
                        timer.stop();
                        if(counter.get()==99){
                            score.setText("99");
                        }else if(counter.get()==100){
                            score.setText("100");
                        }

                        diver.setBounds(0,0,50,50);
                        diver.setVisible(false);
                        System.out.println("winner");
                        System.out.println("Time: "+timelab.getText());
                        save = new Save(score,timelab,main);

                        wait();


                    }

                }
                Thread.sleep(10);
            }
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }
    }
    AtomicInteger getCounter(){
        return counter;
    }
}
