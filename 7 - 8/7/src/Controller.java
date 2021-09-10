import javax.swing.*;
import java.awt.*;

/**
 * this class control the app and relation between view and model.
 *
 * @author Mahdi Hejarti 9723100
 * @since 2020.05.04
 */

public class Controller {

    private Model myModel;
    private boolean shift;

    /**
     * constructor of View class
     */
    public Controller() {
        myModel = new Model();
        shift = false;
    }

    /**
     * get clicked button and do operation
     *
     * @param button  button clicked
     * @param i       number of clocked button
     * @param display get text area
     */
    public void clickButton(JButton button, int i, JTextArea display) {
        String str = "";
        if (myModel.getDisplayText() != null)
            str += myModel.getDisplayText();

        switch (i) {
            case 5:
            case 11:
            case 1:
            case 4:
            case 10:
            case 16:
            case 22:
                str += " " + button.getText() + " ";
                myModel.setDisplayText(str);
                display.setText(myModel.getDisplayText());
                break;

            case 2:
            case 3:
                myModel.setDisplayText("");
                display.setText(myModel.getDisplayText());
                break;

            case 7:
            case 8:
            case 9:
            case 13:
            case 14:
            case 15:
            case 19:
            case 20:
            case 21:
            case 26:
                str += button.getText();
                myModel.setDisplayText(str);
                display.setText(myModel.getDisplayText());
                break;

            case 28:
                try {
                    str = myModel.getDisplayText();
                    String[] splitStr = str.trim().split("\\s+");
                    if (splitStr[0].equals("sin"))
                        str += " = " + Math.sin(Double.parseDouble(splitStr[1])) + " ";
                    else if (splitStr[0].equals("cos"))
                        str += " = " + Math.cos(Double.parseDouble(splitStr[1])) + " ";
                    else if (splitStr[0].equals("tan"))
                        str += " = " + Math.tan(Double.parseDouble(splitStr[1])) + " ";
                    else if (splitStr[0].equals("cot"))
                        str += " = " + 1.0 / Math.tan(Double.parseDouble(splitStr[1])) + " ";
                    else
                        str += " = " + calculate(splitStr) + " ";
                    myModel.setDisplayText(str);
                } catch (Exception e) {
                    myModel.setDisplayText("ERR");
                } finally {
                    display.setText(myModel.getDisplayText());
                }
        }
        System.out.println(myModel.getDisplayText());
    }

    /**
     * get input display and calculate
     *
     * @param strings display string
     * @return result of calculation
     */
    public float calculate(String[] strings) {
        myModel.setNum2(0);
        myModel.setOperator("+");
        myModel.setNum1(Integer.parseInt(strings[0]));
        for (int i = 0; i < strings.length - 2; ) {
            myModel.setNum1(oneCalculate(myModel.getNum1(), myModel.getNum2(), myModel.getOperator()));
            myModel.setOperator(strings[++i]);
            myModel.setNum2(Integer.parseInt(strings[++i]));
        }
        return oneCalculate(myModel.getNum1(), myModel.getNum2(), myModel.getOperator());
    }

    /**
     * get two number and operation and do calculation
     *
     * @param a first number
     * @param b second number
     * @param operator operation
     * @return result
     */
    public float oneCalculate(float a, float b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            case "*":
                return a * b;
            case "%":
                return a % b;
        }
        return 0;
    }

    /**
     * press shift button
     *
     * @param buttons all of buttons in the panel
     */
    public void shift(JButton[] buttons) {
        if (shift) {
            buttons[29].setFont(buttons[29].getFont().deriveFont(Font.BOLD));
            buttons[5].setText("sin");
            buttons[11].setText("tan");
            shift = false;
        } else {
            buttons[29].setFont(buttons[29].getFont().deriveFont(Font.ITALIC));
            buttons[5].setText("cos");
            buttons[11].setText("cot");
            shift = true;
        }
    }

    /**
     * copy text to the other display
     * @param display2 text area to copy text from
     * @param display1 text area to copy text to it
     */
    public void setCopiedText(JTextArea display2, JTextArea display1) {
        display1.setText(display2.getText());
    }
}