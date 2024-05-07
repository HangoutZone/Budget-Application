import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;


public class Driver {   //extends JFrame
    public static void main(String[] args) {
        //Window
        JFrame jFrame = new JFrame("Budget Tracking Application");
        jFrame.setTitle("Budget Application");
        jFrame.setSize(500, 500);
//        jFrame.setLayout(new BorderLayout());
        jFrame.setLayout(null);
        jFrame.setLocationRelativeTo(null);

        //Panel initial setup
        GridLayout gridLayout = new GridLayout(3,2);
        JPanel jPanel = new JPanel(gridLayout);
        jPanel.setBackground(Color.GRAY);
        jPanel.setPreferredSize(new Dimension(300, 100));


        //MenuBar Container
        JMenuBar menuBar = new JMenuBar();
        //MenuBar options
        JMenu options = new JMenu("Options");
        //MenuBar items for your options
        JMenuItem load = new JMenuItem("Load");
        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");

        //add to JMenuBar
        menuBar.add(options);

        //perform Menu Actions
        load.addActionListener(e -> {
            System.out.println("Work in progress to load files.");
        });
        save.addActionListener(e -> {
            System.out.println("Work in progress to save files.");
        });
        reset.addActionListener(e -> {
            System.out.println("Work in progress to clear data from the application.");
        });
        exit.addActionListener(e -> {
            System.out.println("Add a popup to make sure you really want to exit the program");
            System.exit(0);
        });

        //add to JMenu
        options.add(load);
        options.add(save);
        options.add(reset);
        options.add(exit);

        //Fonts
        Font timesNewRomanLabel = new Font("Times New Roman", Font.BOLD, 20);
        Font timesNewRomanText = new Font("Times New Roman", Font.PLAIN, 14);
        Font arialLabel =  new Font("Arial", Font.BOLD, 20);
        Font arialText = new Font("Arial", Font.PLAIN, 14);

        //top label
        Border border = BorderFactory.createLineBorder(Color.RED, 3);
        JLabel label = new JLabel("Budget Data");
        label.setBorder(border);
        label.setFont(timesNewRomanLabel);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(50,50,100,100);

        //name (label and text field)
        Border nameBorder = BorderFactory.createLineBorder(Color.GREEN, 3);
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBorder(nameBorder);
        nameLabel.setFont(timesNewRomanLabel);
        nameLabel.setHorizontalAlignment(JLabel.RIGHT);

        JTextField nameTextField = new JTextField();
        nameTextField.setBorder(border);
        nameTextField.setFont(arialText);
        nameTextField.setBackground(Color.ORANGE);

        //cost (label and text field)
        Border costBorder = BorderFactory.createLineBorder(Color.CYAN, 3);
        JLabel costLabel = new JLabel("Cost: ");
        costLabel.setBorder(costBorder);
        costLabel.setFont(timesNewRomanLabel);
        costLabel.setHorizontalAlignment(JLabel.RIGHT);

        JTextField costTextField = new JTextField();
        costTextField.setBorder(border);
        costTextField.setFont(arialText);
        costTextField.setBackground(Color.PINK);

        //income (label and text field)
        Border incomeBorder = BorderFactory.createLineBorder(Color.PINK, 3);
        JLabel incomeLabel = new JLabel("Income: ");
        incomeLabel.setBorder(incomeBorder);
        incomeLabel.setFont(timesNewRomanLabel);
        incomeLabel.setHorizontalAlignment(JLabel.RIGHT);

        JTextField incomeTextField = new JTextField();
        incomeTextField.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        incomeTextField.setFont(arialText);
        incomeTextField.setBackground(Color.PINK);


        //add to menu panel
        JPanel menu = new JPanel(new GridLayout());
        menu.add(menuBar);

        //income
        jPanel.add(incomeLabel);
        jPanel.add(incomeTextField);

        //name
        jPanel.add(nameLabel);
        jPanel.add(nameTextField);

        //cost
        jPanel.add(costLabel);
        jPanel.add(costTextField);

        //Top
        JPanel title = new JPanel(new GridLayout(1,2));
        title.add(menu);
        title.add(label);

        JPanel bottom = new JPanel();
        bottom.setPreferredSize(new Dimension(500, 200));
        bottom.setLayout(null);

        JButton append = new JButton("add");
        append.setBounds(400, 50, 75, 30);
        bottom.add(append);

        JButton submit = new JButton("submit"); // recalculate data based on the chart, clear textboxes
        submit.setBounds(400, 130, 75, 30);
        bottom.add(submit);

        //Center
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.add(jPanel);
        center.add(bottom);

//        JPanel dragPanel = new JPanel(new BorderLayout());
//        dragPanel.setPreferredSize(new Dimension(500, 500));
//        dragPanel.add(title, BorderLayout.NORTH);
//        dragPanel.add(center, BorderLayout.CENTER);

        //things for second panel in the layered panel

        JPanel bHalfPopup = new JPanel();
        bHalfPopup.setPreferredSize(new Dimension(500, 200));
        bHalfPopup.setLayout(null);
        JButton done = new JButton("Done"); //go to the other page
        done.setBounds(400, 130, 75, 30);

        //add to bottom
        bHalfPopup.add(done);

        //Put panel together
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBounds(0,0,500,500);
        bottomPanel.add(bHalfPopup, BorderLayout.SOUTH);


        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.NORTH);
        topPanel.add(center, BorderLayout.CENTER);
        topPanel.setBounds(0,0, 500,400);


        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0, 500, 500);
        layeredPane.add(topPanel, Integer.valueOf(1));
        layeredPane.add(bottomPanel, Integer.valueOf(0));

        //define buttons
        submit.addActionListener(e -> {
            layeredPane.setLayer(topPanel, 0, 1);
        });
        done.addActionListener(e -> {
            layeredPane.setLayer(topPanel, 1, 0);
        });

        //add to frame
        jFrame.add(layeredPane);

        //frame setup
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}

