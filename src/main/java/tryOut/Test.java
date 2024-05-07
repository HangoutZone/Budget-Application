package tryOut;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Budget Tracking Application");
        jFrame.setTitle("Budget Application");
        jFrame.setSize(500, 500);
        jFrame.setBackground(Color.BLUE);

//        ArrayList<String> k = new ArrayList<>();
//        for(int i = 0; i < 40; i++){
//            k.add(String.valueOf(i));
//        }
//
//        JList<String> jList = new JList(k.toArray());
//
//
//        JScrollPane scrollPane = new JScrollPane(jList);
//        jList.setBounds(100,100, 200, 200);

//        JLabel label = new JLabel("Awesome");
//        label.setForeground(Color.RED);
//        label.setFont(label.getFont().deriveFont(20f));
//        label.setBounds(150, 250, 150, 150);
////        label.setBackground(new Color(133,2,7));
////        label.setOpaque(true);
//        label.setVisible(false);
//
//        JButton b1 = new JButton("ONE");
//        b1.addActionListener(e -> {
//                    System.out.println("Hello");
//                    label.setVisible(true);
//        });
//        b1.setFocusable(false);
//        b1.setForeground(Color.WHITE);
//        b1.setBackground(Color.BLACK);
//        b1.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
////        b1.setEnabled(false);
//        b1.setBounds(200, 100,100, 50);
//
//
//        jFrame.add(b1);
//        jFrame.add(label);
//        jFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        jFrame.getContentPane().setBackground(Color.BLUE);
//        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

}
//        JLabel label = new JLabel();
//        label.setText("Hello");
//        label.setForeground(Color.WHITE);
//
//        label.setVerticalAlignment(JLabel.TOP);
//        label.setHorizontalAlignment(JLabel.RIGHT);
//
//        JPanel redPanel = new JPanel();
//        redPanel.setBackground(Color.RED);
//        redPanel.setBounds(0,0, 250,250);
//
//        JPanel bluePanel = new JPanel();
//        bluePanel.setBackground(Color.BLUE);
//        bluePanel.setBounds(250, 0, 100, 100);
//
//        JPanel greenPanel = new JPanel();
//        greenPanel.setBackground(Color.GREEN);
//        greenPanel.setBounds(250, 100, 100, 150);
//
//        redPanel.setLayout(new BorderLayout());
//
//        redPanel.add(label);
//
//        jFrame.add(greenPanel);
//        jFrame.add(bluePanel);
//        jFrame.add(redPanel);


