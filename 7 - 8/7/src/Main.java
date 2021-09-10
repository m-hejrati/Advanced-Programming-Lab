import javax.swing.*;

/**
 * this is the main class. we run our code here.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.23
 */

public class Main {
    public static void main(String[] args) throws Exception {

        View view = new View();
        view.setVisible();

        // change lookAndFeel
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
}