package Project3;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save extends JFrame {
    private JLabel score;
    private JLabel timelab;
    private JFrame main;
    Save(JLabel score, JLabel timelab , JFrame main) {
        this.main = main;
        this.score = score;
        this.timelab = timelab;
        this.setLayout(new FlowLayout());
        JTextField txt = new JTextField(20);
        JButton set = new JButton("Save");
        if(Integer.valueOf(score.getText())>=99){
            this.setTitle("WINNER");
            this.getContentPane().setBackground(Color.GREEN);
        }else{
            this.setTitle("LOOSER");
            this.getContentPane().setBackground(Color.RED);
        }
        this.setSize(300, 100);
        this.setLocationRelativeTo(null);
        this.add(txt);
        this.add(set);
        this.setVisible(true);
        set.addActionListener(e1 -> {
            try {
                FileWriter fw = new FileWriter("scores.txt", true);
                BufferedWriter out = new BufferedWriter(fw);
                if(Integer.valueOf(score.getText())>=100){
                    out.write("\n"+txt.getText()+" "+score.getText()+" "+timelab.getText());
                    out.close();
                }else if (Integer.valueOf(score.getText()) < 10) {
                    out.write("\n" + txt.getText() + " " + "00" + score.getText() + " " + timelab.getText());
                    out.close();
                } else {
                    out.write("\n" + txt.getText() + " " + "0" + score.getText() + " " + timelab.getText());
                    out.close();
                }
                this.dispose();
                main.dispose();
            } catch (IOException e) {

            }
        });
    }
}
