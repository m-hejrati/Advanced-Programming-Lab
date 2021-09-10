/**
 * in this class we holds information of calculator.
 *
 * @author Mahdi Hejarti 9723100
 * @since 2020.05.04
 */

public class Model {

    private String displayText;
    private float num1;
    private float num2;
    private String operator;

    /**
     * constructor of View class
     */
    public Model (){
        num1 = 0;
        num2 = 0;
        operator = "+";
    }

    /**
     * getter for text
     * @return text
     */
    public String getDisplayText() {
        return displayText;
    }

    /**
     * setter for text
     * @param displayText text
     */
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    /**
     * setter for first number
     * @param num1 number
     */
    public void setNum1(float num1) {
        this.num1 = num1;
    }

    /**
     * setter for second number
     * @param num2 number
     */
    public void setNum2(float num2) {
        this.num2 = num2;
    }

    /**
     * setter for operator
     * @param operator operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * getter for first number
     * @return number
     */
    public float getNum1() {
        return num1;
    }

    /**
     * getter for second number
     * @return number
     */
    public float getNum2() {
        return num2;
    }

    /**
     * getter for operator
     * @return operator
     */
    public String getOperator() {
        return operator;
    }
}
