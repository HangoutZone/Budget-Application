package application;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.stream.Collectors;


public class BudgetApp {
    public BudgetApp() {
        //Window
        JFrame jFrame = new JFrame("Budget Tracking Application");
        jFrame.setTitle("Budget Application");
        jFrame.setSize(500, 500);
        jFrame.setLocationRelativeTo(null);

        //Fonts
        Font timesNewRomanLabel = new Font("Times New Roman", Font.BOLD, 20);
        Font timesNewRomanText = new Font("Times New Roman", Font.PLAIN, 14);
        Font arialLabel = new Font("Arial", Font.BOLD, 20);
        Font arialText = new Font("Arial", Font.PLAIN, 14);

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

        exit.addActionListener(e -> {
            System.exit(0);
        });

        //add to JMenu
        options.add(load);
        options.add(save);
        options.add(reset);
        options.add(exit);

        options.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                options.setForeground(new Color(0xFCC508));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                options.setForeground(Color.BLACK);
            }
        });

        //title label
        JLabel label = new JLabel("Budget App");
        label.setBackground(Color.BLUE);
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setFont(timesNewRomanLabel);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(50, 50, 100, 100);

        //name
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(timesNewRomanLabel);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        JTextField nameTextField = new JTextField();
        nameTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nameTextField.setColumns(16);
        nameTextField.setFont(arialText);

        //cost
        JLabel costLabel = new JLabel("Cost: ");
        costLabel.setForeground(Color.WHITE);
        costLabel.setFont(timesNewRomanLabel);
        costLabel.setHorizontalAlignment(JLabel.CENTER);

        JTextField costTextField = new JTextField();
        costTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        costTextField.setColumns(16);
        costTextField.setFont(arialText);

        //income
        JLabel incomeLabel = new JLabel("Income: ");
        incomeLabel.setForeground(Color.WHITE);
        incomeLabel.setFont(timesNewRomanLabel);
        incomeLabel.setHorizontalAlignment(JLabel.LEFT);

        JTextField incomeTextField = new JTextField();
        incomeTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        incomeTextField.setColumns(16);
        incomeTextField.setFont(arialText);

        //add to menu panel
        JPanel menu = new JPanel(new BorderLayout());
        menu.add(menuBar);

        JPanel incomePanel = new JPanel(new FlowLayout());
        incomePanel.setBackground(Color.BLUE);
        incomePanel.setOpaque(true);
        incomePanel.add(incomeLabel);
        incomePanel.add(incomeTextField);
        JPanel namePanel = new JPanel(new FlowLayout());
        namePanel.setBackground(Color.BLUE);
        incomePanel.setOpaque(true);
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        JPanel costPanel = new JPanel(new FlowLayout());
        costPanel.setBackground(Color.BLUE);
        costPanel.setOpaque(true);
        costPanel.add(costLabel);
        costPanel.add(costTextField);

        //label panel
        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        infoPanel.setBackground(Color.BLUE);
        incomePanel.setOpaque(true);
        infoPanel.add(incomePanel);
        infoPanel.add(namePanel);
        infoPanel.add(costPanel);


        JPanel title = new JPanel(new BorderLayout());
        title.add(menu, BorderLayout.WEST);
        title.add(label, BorderLayout.CENTER);

        JPanel scrollPanel = new JPanel(new BorderLayout());
        scrollPanel.setBackground(Color.BLUE);
        scrollPanel.setOpaque(true);

        DefaultListModel<Item> data = new DefaultListModel<>();
        JList<Item> list = new JList<>(data);
        ListSelectionModel select = list.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.getViewport().getView().setBackground(new Color(0x161FD2));
        scrollPane.getViewport().getView().setFont(timesNewRomanLabel);
        scrollPane.getViewport().getView().setForeground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        scrollPane.setPreferredSize(new Dimension(350, 200));
        scrollPanel.add(scrollPane, BorderLayout.WEST);


        //top buttons
        JButton append = new JButton("Add");
        append.setBackground(Color.BLUE);
        append.setForeground(Color.WHITE);
        append.setFont(timesNewRomanLabel);
        JButton remove = new JButton("Remove");
        remove.setBackground(Color.BLUE);
        remove.setForeground(Color.WHITE);
        remove.setFont(timesNewRomanLabel);
        JButton submit = new JButton("Submit");
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setFont(timesNewRomanLabel);


        append.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                append.setForeground(new Color(0x06DEB8));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                append.setForeground(Color.WHITE);
            }
        });

        remove.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                remove.setForeground(new Color(0xE7495B));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                remove.setForeground(Color.WHITE);
            }
        });

        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                submit.setForeground(new Color(0x6CEC05));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                submit.setForeground(Color.WHITE);
            }
        });


        append.setFocusable(false);
        remove.setFocusable(false);
        submit.setFocusable(false);

        JPanel freeside = new JPanel();
        freeside.setBackground(Color.BLUE);
        freeside.setOpaque(true);

        JPanel freesideTwo = new JPanel(new GridLayout(3, 1));
        freesideTwo.setBackground(Color.BLUE);
        freesideTwo.setOpaque(true);
        freesideTwo.add(append);
        freesideTwo.add(remove);
        freesideTwo.add(submit);

        scrollPanel.add(freesideTwo, BorderLayout.CENTER);
        JLabel dataLabel = new JLabel("Budget Data");
        dataLabel.setForeground(Color.WHITE);
        dataLabel.setFont(timesNewRomanLabel);
        scrollPanel.add(dataLabel, BorderLayout.NORTH);


        JLabel spending = new JLabel();
        spending.setVisible(false);
        spending.setFont(timesNewRomanLabel);
        spending.setForeground(Color.WHITE);
        scrollPanel.add(spending, BorderLayout.SOUTH);

        //Top
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.NORTH);
        topPanel.add(freeside, BorderLayout.EAST);
        topPanel.add(infoPanel, BorderLayout.CENTER);
        topPanel.add(scrollPanel, BorderLayout.SOUTH);

        //top button actions
        append.addActionListener(e -> {
            try {
                Item a = new Item(nameTextField.getText(), Double.parseDouble(costTextField.getText()));
                if (a.getCost() < 0) {
                    throw new IllegalStateException("Cost can't be negative");
                }
                if (a.getName().isEmpty()) {
                    a.setName("Unknown");
                }
                data.addElement(a);
                nameTextField.setText("");
                costTextField.setText("");
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Make sure to enter a number for the cost.");
                costTextField.setText("");
                costTextField.setBackground(new Color(0xE7495B));
            } catch (IllegalStateException illegalStateException) {
                System.out.println(illegalStateException.getMessage());
                costTextField.setText("");
            }
        });

        costTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                costTextField.setBackground(Color.WHITE);
            }
        });

        incomeTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                incomeTextField.setBackground(Color.WHITE);
            }
        });

        remove.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if (index != -1) {
                data.remove(index);
            }
        });

        reset.addActionListener(e -> {
            data.removeAllElements();
            incomeTextField.setText("");
            incomeTextField.setBackground(Color.WHITE);
            nameTextField.setText("");
            costTextField.setText("");
            costTextField.setBackground(Color.WHITE);
            spending.setText("");
            spending.setVisible(false);
        });

        //perform Menu Actions
        load.addActionListener(e -> {
            if (e.getSource() == load) {

                JFileChooser chooser = new JFileChooser();
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.setCurrentDirectory(new File("."));
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("Text File", "txt"));
                int userSelection = chooser.showOpenDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    data.removeAllElements();
                    incomeTextField.setText("");
                    nameTextField.setText("");
                    costTextField.setText("");

                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                        String line;
                        String[] parse;
                        String name = null;
                        Double cost = null;
                        incomeTextField.setText(bufferedReader.readLine());
                        while ((line = bufferedReader.readLine()) != null) {
                            parse = line.split(":");
                            for (int i = 0; i < parse.length; i++) {
                                if (i % 2 == 0) {
                                    name = parse[i];
                                } else {
                                    cost = Double.parseDouble(parse[i]);
                                }
                            }
                            data.addElement(new Item(name, cost));
                        }

                        Double.parseDouble(incomeTextField.getText());
                    } catch (IOException ioException) {
                        System.out.println("file not found: " + ioException.getMessage());
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println("The number you entered is invalid");
                        incomeTextField.setBackground(new Color(0xE7495B));
                        incomeTextField.setText("");
                    }
                }
            }
        });

        submit.addActionListener(e -> {
            try {
                double income = Double.parseDouble(incomeTextField.getText());

                if (data.isEmpty()) {
                    System.out.println("There are no elements in the list");
                } else {
                    start(data.elements());

                    double spendingResult = Double.parseDouble(calculate(data.elements(), income));

                    if (spendingResult < 0) {
                        spending.setText("Spending vs Income: " + spendingResult);
                        spending.setForeground(new Color(0xE7495B));
                        spending.setVisible(true);
                    } else if (spendingResult == 0) {
                        spending.setText("Spending vs Income: " + spendingResult);
                        spending.setForeground(Color.YELLOW);
                        spending.setVisible(true);
                    } else {
                        spending.setText("Spending vs Income: " + spendingResult);
                        spending.setForeground(Color.GREEN);
                        spending.setVisible(true);
                    }

                }

            } catch (NumberFormatException numberFormatException) {
                System.out.println("The number you entered is invalid");
                incomeTextField.setBackground(new Color(0xE7495B));
                incomeTextField.setText("");
            }

        });

        save.addActionListener(e -> {
            if (incomeTextField.getText().equalsIgnoreCase("") || incomeTextField.getText().isEmpty()) {
                incomeTextField.setBackground(new Color(0xE7495B));
            } else {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("."));
                String defaultFileName = constructDefaultFileName();
                chooser.setSelectedFile(new File(defaultFileName));
                int userSelection = chooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    try (PrintWriter printWriter = new PrintWriter(chooser.getSelectedFile())) {
                        printWriter.println(incomeTextField.getText());
                        Enumeration<Item> items = data.elements();
                        while (items.hasMoreElements()) {
                            Item i = (items.nextElement());
                            printWriter.println(i.getName() + ":" + i.getCost());
                        }

                        printWriter.flush();
                    } catch (FileNotFoundException f) {
                        System.out.println("file not found: " + f.getMessage());
                    }
                }
            }
        });

        jFrame.add(topPanel);

        //frame setup
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setIconImage(new ImageIcon("moneybag.png").getImage());
        jFrame.setVisible(true);

    }

    private void start(Enumeration<Item> items) {
        SwingWorker<Void, JFrame> worker = new SwingWorker<Void, JFrame>() {
            @Override
            protected Void doInBackground() {
                ExampleChart<PieChart> t1 = new CustomPieChart();
                PieChart pieChart = t1.getChart();
                while (items.hasMoreElements()) {
                    Item i = (items.nextElement());
                    pieChart.addSeries(i.getName(), i.getCost());
                }

                SwingWrapper<PieChart> wrapper = new SwingWrapper<>(pieChart);
                JFrame displayChart = wrapper.displayChart();
                displayChart.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                return null;
            }
        };

        worker.execute();
    }

    private String calculate(Enumeration<Item> items, double income) {
        double spending = 0.0;
        while (items.hasMoreElements()) {
            Item i = (items.nextElement());
            spending += i.getCost();
        }

        return String.valueOf(income - spending);
    }

    private String constructDefaultFileName() {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String[]> parse = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();

        File file = new File(".");

        //get list of files in directory with default name
        for (String x : file.list()) {
            if (x.matches("[bB]udget\\d*.txt")) {
                names.add(x);
            }
        }

        for (String x : names) {
            parse.add(x.split("\\D+"));
        }

        for (String[] x : parse) {
            results.add(Integer.parseInt(x[1]));
        }

        results = (ArrayList<Integer>) results.stream().sorted().collect(Collectors.toList());

        int append = results.get(results.size() - 1) + 1;

        return "Budget" + append + ".txt";
    }
}

