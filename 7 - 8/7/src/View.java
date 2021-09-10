import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * in this class we design the interface of our calculator.
 *
 * @author Mahdi Hejarti 9723100
 * @since 2020.04.23
 */

public class View {

    private JFrame calFrame;
    private JPanel standardMode;
    private JPanel scientificMode;
    private JButton[] buttons1;
    private JButton[] buttons2;
    private JTextArea display1;
    private JTextArea display2;

    private Controller controller;

    /**
     * constructor of View class
     */
    public View() {

        Handler handler = new Handler();
        controller = new Controller();

        // create main frame
        calFrame = new JFrame();
        designCalculatorFrame();

        // add a tab to frame to change mode
        JTabbedPane modeTabbedPane = new JTabbedPane();
        calFrame.setContentPane(modeTabbedPane);

        // add a panel to tabbedPane for standard mode
        standardMode = new JPanel();
        standardMode.setLayout(new BorderLayout(5, 5));
        modeTabbedPane.add("Standard View", standardMode);

        // add a panel to tabbedPane for scientific mode
        scientificMode = new JPanel();
        scientificMode.setLayout(new BorderLayout(5, 5));
        modeTabbedPane.add("Scientific View", scientificMode);

        // create keys and add them to panels
        buttons1 = new JButton[20];
        AddStandardKey(buttons1);
        buttons2 = new JButton[30];
        AddScientificKey(buttons2);
        // add action listener to buttons
        for (JButton button : buttons2) {
            button.addActionListener(handler);
            button.addKeyListener(new KeyLis());
        }

        // add display part to panels
        addFirstDisplay();
        addSecondDisplay();

        // create menu bar
        JMenuBar menuBar = new JMenuBar();
        // create file menu
        JMenu mainMenu = new JMenu("Menu");
        mainMenu.setMnemonic('N');

        // create exit item
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });

        // create copy item
        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                controller.setCopiedText(display2, display1);
            }
        });

        // create about item
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JOptionPane.showMessageDialog(null,
                        "Mahdi Hejrati \n9723100 \n",
                        "About",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // add menu
        mainMenu.add(exitItem);
        mainMenu.add(copyItem);
        mainMenu.add(aboutItem);
        menuBar.add(mainMenu);
        calFrame.setJMenuBar(menuBar);

        calFrame.addKeyListener(new KeyLis());
        calFrame.requestFocusInWindow();
        calFrame.setFocusable(true);
    }

    /**
     * design the main frame
     */
    public void designCalculatorFrame() {
        calFrame.setTitle("My Calculator");
        calFrame.setSize(430, 550);
        calFrame.setLocation(600, 230);
        calFrame.setMinimumSize(new Dimension(380, 350));
        calFrame.setResizable(true);
        calFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * create keys and add them to the center part of standardMode panel
     */
    public void AddStandardKey(JButton[] buttons) {
        JPanel standardKeyboardPanel = new JPanel();
        standardKeyboardPanel.setLayout(new GridLayout(5, 4));
        standardMode.add(standardKeyboardPanel, BorderLayout.CENTER);

        String[] buttonText = {"%", "CE", "C", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "( )", "0", ".", "="};

        // add properties to buttons
        for (int i = 0; i < 20; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(buttonText[i]);
            buttons[i].setBackground(new Color(50, 50, 50));
            buttons[i].setForeground(Color.white);
            buttons[i].setOpaque(true);
            buttons[i].setToolTipText(buttonText[i]);
            buttons[i].setFont(buttons[i].getFont().deriveFont(16f));
            standardKeyboardPanel.add(buttons[i]);
        }
    }

    /**
     * create keys and add them to the center part of scientificMode panel
     */
    public void AddScientificKey(JButton[] buttons) {
        JPanel scientificKeyboardPanel = new JPanel();
        scientificKeyboardPanel.setLayout(new GridLayout(5, 6));
        scientificMode.add(scientificKeyboardPanel, BorderLayout.CENTER);

        String[] buttonText = {"PI", "%", "CE", "C", "/", "sin", "e", "7", "8", "9", "*", "tan", "^", "4", "5", "6", "-", "log", "!", "1", "2", "3", "+", "exp", "(", ")", "0", ".", "=", "shift"};

        // add properties to buttons
        for (int i = 0; i < 30; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(buttonText[i]);
            buttons[i].setBackground(new Color(50, 50, 50));
            buttons[i].setForeground(Color.white);
            buttons[i].setOpaque(true);
            buttons[i].setToolTipText(buttonText[i]);
            buttons[i].setFont(buttons[i].getFont().deriveFont(16f));
            scientificKeyboardPanel.add(buttons[i]);
        }
    }

    /**
     * creat display part and add it to north part of standardMode panel
     */
    public void addFirstDisplay() {
        display1 = new JTextArea();

        makeDisplay(display1);

        JScrollPane scrollPane = new JScrollPane(display1);
        scrollPane.setPreferredSize(new Dimension(100, 90));

        standardMode.add(scrollPane, BorderLayout.NORTH);
    }

    /**
     * creat display part and add it to north part of scientificMode panel
     */
    public void addSecondDisplay() {
        display2 = new JTextArea();

        makeDisplay(display2);

        JScrollPane scrollPane = new JScrollPane(display2);
        scrollPane.setPreferredSize(new Dimension(100, 90));

        scientificMode.add(scrollPane, BorderLayout.NORTH);
    }

    /**
     * add properties to display
     * @param display
     */
    void makeDisplay(JTextArea display) {
        display.setEditable(false);
        display.setForeground(Color.white);
        display.setBackground(new Color(100, 100, 100));
        display.setFont(display.getFont().deriveFont(19f));
        display.setToolTipText("text area to show operations");
    }

    /**
     * set the frame visible to show
     */
    public void setVisible() {
        calFrame.setVisible(true);
    }

    /**
     * inner class of button handler
     */
    private class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < 29; i++)
                if (e.getSource().equals(buttons2[i])) {
                    controller.clickButton(buttons2[i], i, display2);
                }

            if (e.getSource().equals(buttons2[29])) {
                controller.shift(buttons2);
            }
        }
    }

    /**
     * inner class of key handler
     */
    private class KeyLis extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_7:
                case KeyEvent.VK_NUMPAD7:
                    controller.clickButton(buttons2[7], 7, display2);
                    break;
                case KeyEvent.VK_8:
                case KeyEvent.VK_NUMPAD8:
                    controller.clickButton(buttons2[8], 8, display2);
                    break;
                case KeyEvent.VK_9:
                case KeyEvent.VK_NUMPAD9:
                    controller.clickButton(buttons2[9], 9, display2);
                    break;
                case KeyEvent.VK_4:
                case KeyEvent.VK_NUMPAD4:
                    controller.clickButton(buttons2[13], 13, display2);
                    break;
                case KeyEvent.VK_5:
                case KeyEvent.VK_NUMPAD5:
                    controller.clickButton(buttons2[14], 14, display2);
                    break;
                case KeyEvent.VK_6:
                case KeyEvent.VK_NUMPAD6:
                    controller.clickButton(buttons2[15], 15, display2);
                    break;
                case KeyEvent.VK_1:
                case KeyEvent.VK_NUMPAD1:
                    controller.clickButton(buttons2[19], 19, display2);
                    break;
                case KeyEvent.VK_2:
                case KeyEvent.VK_NUMPAD2:
                    controller.clickButton(buttons2[20], 20, display2);
                    break;
                case KeyEvent.VK_3:
                case KeyEvent.VK_NUMPAD3:
                    controller.clickButton(buttons2[21], 21, display2);
                    break;
                case KeyEvent.VK_0:
                case KeyEvent.VK_NUMPAD0:
                    controller.clickButton(buttons2[26], 26, display2);
                    break;
                case KeyEvent.VK_R:
                    controller.clickButton(buttons2[1], 1, display2);
                    break;
                case KeyEvent.VK_D:
                    controller.clickButton(buttons2[4], 4, display2);
                    break;
                case KeyEvent.VK_M:
                    controller.clickButton(buttons2[10], 10, display2);
                    break;
                case KeyEvent.VK_S:
                    controller.clickButton(buttons2[16], 16, display2);
                    break;
                case KeyEvent.VK_P:
                    controller.clickButton(buttons2[22], 22, display2);
                    break;
                case KeyEvent.VK_ENTER:
                    controller.clickButton(buttons2[28], 28, display2);
                    break;
                case KeyEvent.VK_BACK_SPACE:
                    controller.clickButton(buttons2[3], 3, display2);
                    break;
                case KeyEvent.VK_I:
                    controller.clickButton(buttons2[5], 5, display2);
                    break;
                case KeyEvent.VK_T:
                    controller.clickButton(buttons2[11], 11, display2);
                    break;
                case KeyEvent.VK_H:
                    controller.shift(buttons2);
                    break;
            }
        }
    }
}