package Project3;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame  {
    ImageIcon backgroundimg;
    ImageIcon good;
    ImageIcon bad;
    JLabel label;
    JLabel back;
    JLabel score;
    JLabel o1;
    JLabel o2;
    JLabel o3;
    JLabel o4;
    JLabel timeLabel = new JLabel();
    Highscore model = new Highscore();
    int elapsedTime = 0;
    int seconds =0;
    int minutes =0;

    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);


    javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {

        elapsedTime=elapsedTime+1000;

        minutes = (elapsedTime/60000) % 60;
        seconds = (elapsedTime/1000) % 60;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);

        timeLabel.setText(minutes_string+":"+seconds_string);

    });

    public static void main(String[]args){
        SwingUtilities.invokeLater(
                ()->new Main());



    }
    Main(){
        JTable table = new JTable();
        table.setModel(model);
        JFrame x = this;
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollpane = new JScrollPane(table);
        TableColumnModel col = table.getColumnModel();
        col.getColumn(0).setPreferredWidth(100);
        scrollpane.setPreferredSize(new Dimension(386,360));
        timeLabel.setText(minutes_string+":"+seconds_string);
        timeLabel.setBounds(190,65,100,50);
       timeLabel.setFont(new Font("Verdana",Font.PLAIN,14));

        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        this.setTitle("Ocean Explorers");


        label = new JLabel();
        back = new JLabel();
        score = new JLabel();

        o1 = new JLabel();
        o2 = new JLabel();
        o3 = new JLabel();
        o4 = new JLabel();




        //counter = gamescore.getCounter() ;
        backgroundimg = new ImageIcon("back.JPG");
        back.setIcon( backgroundimg);
        good = new ImageIcon("good.JPG");
        bad = new ImageIcon("bad.JPG");
        back.setBounds(0,0,386,360);
        label.setBackground(Color.red);
        //label.setOpaque(true);
        label.setIcon(bad);
        label.setBounds(60, 70, 50, 50);

        o1.setBackground(new Color(48,44,44));
        o1.setOpaque(true);
        o1.setBounds(140,136,20,20);

        o2.setBackground(new Color(48,44,44));
        o2.setOpaque(true);
        o2.setBounds(160,165,20,20);

        o3.setBackground(new Color(48,44,44));
        o3.setOpaque(true);
        o3.setBounds(200,185,20,20);

        o4.setBackground(new Color(48,44,44));
        o4.setOpaque(true);
        o4.setBounds(270,190,20,20);

        JLabel word = new JLabel("Score: ");
        word.setBounds(290,40,100,100);
        score.setBounds(330,40,100,100);
       JPanel begin = new JPanel();
        begin.setBounds(100,0,386,360);
        begin.add(scrollpane);
        JPanel center = new JPanel(null);
        center.setBackground(Color.WHITE);
        center.setBounds(100,0,386,360);
        center.setBackground(new Color(205,201,174));
        center.add(label);
        center.add(word);
        center.add(score);
        center.add(timeLabel);
        center.add(o1);
        center.add(o2);
        center.add(o3);
        center.add(o4);
        center.add(back);


        JPanel left = new JPanel(new BorderLayout());
        ImageIcon lt = new ImageIcon("left.png");
        JButton l = new JButton();
        l.setText("left");
        l.setIcon(lt);
        l.setHorizontalTextPosition(JButton.CENTER);
        l.setVerticalTextPosition(JButton.BOTTOM);
        l.setBackground(new Color(205,201,174));
        l.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Left");
        Action action = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (label.getX() < 70) {
                    label.setLocation(label.getX() , label.getY() - 30);
                } else if (label.getX() >= 70) {
                    label.setLocation(label.getX() - 30, label.getY());
                }

                if(label.getY()<40){
                    label.setLocation(label.getX(),label.getY()+30);
                }
                System.out.println("x " + label.getX());
                System.out.println("y " + label.getY());

            }
        };
        l.getActionMap().put("Left", action);
        l.addActionListener(action);
        left.add(l,BorderLayout.PAGE_END);
        left.setBounds(0,0,100,360);
        left.setBackground(new Color(205,201,174));

        ImageIcon rt = new ImageIcon("right.png");
        JPanel right = new JPanel(new BorderLayout());
        JButton r = new JButton();
        r.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Right");
        r.setText("right");
        r.setIcon(rt);
        r.setHorizontalTextPosition(JButton.CENTER);
        r.setVerticalTextPosition(JButton.BOTTOM);
        Action action1 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (label.getY() < 250) {
                    label.setLocation(label.getX(), label.getY() + 30);
                } else if (label.getY() > 200) {
                    label.setLocation(label.getX() + 30, label.getY());
                }
                if(label.getX() > 270) {
                    label.setLocation(label.getX() - 30, label.getY());
                }

                System.out.println("x " + label.getX());
                System.out.println("y " + label.getY());
            }
        };
        r.getActionMap().put("Right", action1);
        r.addActionListener(action1);
        r.setBackground(new Color(205,201,174));
        JButton start = new JButton("start");
        start.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                0), "Space");
        Action action3 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                begin.setVisible(false);
                timer.start();
                T1 t1 = new T1("t1",o1,timer,label,score,timeLabel,x);
                T2 t2 = new T2("t2",o2,timer,label,score,timeLabel,x);
                T3 t3 = new T3("t3",o3,timer,label,score,timeLabel,x);
                T4 t4 = new T4("t4",o4,timer,label,score,timeLabel,x);
                Score gamescore = new Score("score",score,label,timer,timeLabel,t4,t1,t2,t3,x);
                right.remove(start);
                right.repaint();
                right.revalidate();
            }
            };
        start.getActionMap().put("Space", action3);
        start.addActionListener(action3);
        right.add(r,BorderLayout.PAGE_END);
        right.add(start,BorderLayout.PAGE_START);
        right.setBounds(486,0,100,360);
        right.setBackground(new Color(205,201,174));
        this.setLayout(null);

        this.setSize(600,400);
        this.add(left);
        this.add(right);

        this.add(begin);

        this.add(center);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }


}