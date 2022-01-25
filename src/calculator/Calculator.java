package calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class Calculator extends JFrame {

    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 460);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JLabel ResultLabel = new JLabel();
        ResultLabel.setName("ResultLabel");
        ResultLabel.setBounds(10, 0, 270, 50);
        ResultLabel.setText("0");
        ResultLabel.setFont(new Font("Roboto", Font.BOLD, 50));
        ResultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(ResultLabel);
        JLabel EquationLabel = new JLabel();
        EquationLabel.setName("EquationLabel");
        EquationLabel.setBounds(10, 60, 260, 20);
        EquationLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        EquationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        EquationLabel.setForeground(Color.GREEN);
        add(EquationLabel);

        JButton Parentheses = new JButton("()");
        Parentheses.setName("Parentheses");
        Parentheses.setBounds(10, 120, 60, 40);
        Parentheses.addActionListener(e -> checkAndInsert(EquationLabel));
        add(Parentheses);
        JButton CE = new JButton("CE");
        CE.setName("CE");
        CE.setBounds(80, 120, 60, 40);
        CE.addActionListener(e -> System.out.println());
        add(CE);
        JButton Clear = new JButton("C");
        Clear.setName("Clear");
        Clear.setBounds(150, 120, 60, 40);
        Clear.addActionListener(e -> EquationLabel.setText(""));
        add(Clear);
        JButton Delete = new JButton("Del");
        Delete.setName("Delete");
        Delete.setBounds(220, 120, 60, 40);
        Delete.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str.substring(0, str.length()-1));
        });
        add(Delete);

        JButton PowerTwo = new JButton("X\u00B2");
        PowerTwo.setName("PowerTwo");
        PowerTwo.setBounds(10, 170, 60, 40);
        PowerTwo.addActionListener(e -> EquationLabel.setText(EquationLabel.getText() + "^(2)"));
        add(PowerTwo);
        JButton PowerY = new JButton("X\u02B8");
        PowerY.setName("PowerY");
        PowerY.setBounds(80, 170, 60, 40);
        PowerY.addActionListener(e -> EquationLabel.setText(EquationLabel.getText() + "^("));
        add(PowerY);
        JButton SquareRoot = new JButton("\u221A");
        SquareRoot.setName("SquareRoot");
        SquareRoot.setBounds(150, 170, 60, 40);
        SquareRoot.addActionListener(e -> {
            String str = EquationLabel.getText();
            if (checkCurrentEquation(str) == 1 || str.length() == 0) {
                EquationLabel.setText(str + "\u221A(");
            } else if (checkCurrentEquation(str) == 2) {
                EquationLabel.setText(str.substring(0, str.length() - 1) + "\u221A(");
            } else if (checkCurrentEquation(str) == 3) {
                EquationLabel.setText(str + "0" + "\u221A(");
            }
        });
        add(SquareRoot);
        JButton Divide = new JButton("\u00F7");
        Divide.setName("Divide");
        Divide.setBounds(220, 170, 60, 40);
        Divide.addActionListener(e -> insertOperator(EquationLabel, "\u00F7"));
        add(Divide);

        JButton seven = new JButton("7");
        seven.setName("Seven");
        seven.setBounds(10, 220, 60, 40);
        seven.addActionListener(e -> {
            String str = EquationLabel.getText();
            if (str.equals(".")) {
                EquationLabel.setText("0" + str + "7");
            } else {
                EquationLabel.setText(str + "7");
            }
        });
        add(seven);
        JButton eight = new JButton("8");
        eight.setName("Eight");
        eight.setBounds(80, 220, 60, 40);
        eight.addActionListener(e -> {
            String str = EquationLabel.getText();if (str.equals(".")) {
                EquationLabel.setText("0" + str + "8");
            } else {
                EquationLabel.setText(str + "8");
            }
        });
        add(eight);
        JButton nine = new JButton("9");
        nine.setName("Nine");
        nine.setBounds(150, 220, 60, 40);
        nine.addActionListener(e -> {
            String str = EquationLabel.getText();
            if (str.equals(".")) {
                EquationLabel.setText("0" + str + "9");
            } else {
                EquationLabel.setText(str + "9");
            }
        });
        add(nine);
        JButton Multiply = new JButton("\u00D7");
        Multiply.setName("Multiply");
        Multiply.setBounds(220, 220, 60, 40);
        Multiply.addActionListener(e -> insertOperator(EquationLabel, "\u00D7"));
        add(Multiply);

        JButton four = new JButton("4");
        four.setName("Four");
        four.setBounds(10, 270, 60, 40);
        four.addActionListener(e -> {
            String str = EquationLabel.getText();
            if (str.equals(".")) {
                EquationLabel.setText("0" + str + "4");
            } else {
                EquationLabel.setText(str + "4");
            }
        });
        add(four);
        JButton five = new JButton("5");
        five.setName("Five");
        five.setBounds(80, 270, 60, 40);
        five.addActionListener(e -> {
            String str = EquationLabel.getText();
            if (str.equals(".")) {
                EquationLabel.setText("0" + str + "5");
            } else {
                EquationLabel.setText(str + "5");
            }
        });
        add(five);
        JButton six = new JButton("6");
        six.setName("Six");
        six.setBounds(150, 270, 60, 40);
        six.addActionListener(e -> {
            String str = EquationLabel.getText();
            if (str.equals(".")) {
                EquationLabel.setText("0" + str + "6");
            } else {
                EquationLabel.setText(str + "6");
            }
        });
        add(six);
        JButton subtract = new JButton("\u2212");
        subtract.setName("Subtract");
        subtract.setBounds(220, 270, 60, 40);
        subtract.addActionListener(e -> insertOperator(EquationLabel, "-"));
        add(subtract);

        JButton one = new JButton("1");
        one.setName("One");
        one.setBounds(10, 320, 60, 40);
        one.addActionListener(e -> {
            String str = EquationLabel.getText();
            if (str.equals(".")) {
                EquationLabel.setText("0" + str + "1");
            } else {
                EquationLabel.setText(str + "1");
            }
        });
        add(one);
        JButton two = new JButton("2");
        two.setName("Two");
        two.setBounds(80, 320, 60, 40);
        two.addActionListener(e -> {
            String str = EquationLabel.getText();
            if (str.equals(".")) {
                EquationLabel.setText("0" + str + "2");
            } else {
                EquationLabel.setText(str + "2");
            }
        });
        add(two);
        JButton three = new JButton("3");
        three.setName("Three");
        three.setBounds(150, 320, 60, 40);
        three.addActionListener(e -> {
            String str = EquationLabel.getText();
            if (str.equals(".")) {
                EquationLabel.setText("0" + str + "3");
            } else {
                EquationLabel.setText(str + "3");
            }
        });
        add(three);
        JButton Add = new JButton("\u002B");
        Add.setName("Add");
        Add.setBounds(220, 320, 60, 40);
        Add.addActionListener(e -> insertOperator(EquationLabel, "\u002B"));
        add(Add);

        JButton PlusMinus = new JButton("\u00B1");
        PlusMinus.setName("PlusMinus");
        PlusMinus.setBounds(10, 370, 60, 40);
        PlusMinus.addActionListener(e -> negate(EquationLabel));
        add(PlusMinus);
        JButton zero = new JButton("0");
        zero.setName("Zero");
        zero.setBounds(80, 370, 60, 40);
        zero.addActionListener(e -> {
            String str = EquationLabel.getText();
            if (str.equals(".")) {
                EquationLabel.setText("0" + str + "0");
            } else {
                EquationLabel.setText(str + "0");
            }
        });
        add(zero);
        JButton Dot = new JButton(".");
        Dot.setName("Dot");
        Dot.setBounds(150, 370, 60, 40);
        Dot.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + ".");
        });
        add(Dot);
        JButton Solve = new JButton("=");
        Solve.setName("Equals");
        Solve.setBounds(220, 370, 60, 40);
        Solve.addActionListener(e -> Solve(ResultLabel, EquationLabel));
        add(Solve);
    }

    private void negate(JLabel equationLabel) {
        String str = equationLabel.getText();
        if (str.length() == 0) {
            equationLabel.setText("(\u002D");
            return;
        }
        if (str.startsWith("(\u002D") && !notContainsOperator(str)) {
            equationLabel.setText(str.substring(2));
            return;
        }
        if (notContainsOperator(str)) {
            equationLabel.setText("(\u002D" + str);
            return;
        }
        if (str.equals("(\u002D")) {
            equationLabel.setText("");
            return;
        }
        if (!str.startsWith("(\u002D")) {
            equationLabel.setText("(\u002D(" + str + "))");
        } else {
            equationLabel.setText(str.substring(3, str.length()-2));
        }
    }

    private boolean notContainsOperator(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (isOperator(str.charAt(i))) return false;
        }
        return true;
    }

    private void insertOperator(JLabel equationLabel, String operator) {
        String str = equationLabel.getText();
        if (str.charAt(str.length()-1) == ')') {
            equationLabel.setText(str + operator);
            return;
        }
        if (checkCurrentEquation(str) == 1) {
            equationLabel.setText(str + operator);
        } else if (checkCurrentEquation(str) == 2) {
            equationLabel.setText(str.substring(0, str.length() - 1) + operator);
        } else if (checkCurrentEquation(str) == 3) {
            equationLabel.setText(str + "0" + operator);
        }
    }

    private void checkAndInsert(JLabel equationLabel) {
        String str = equationLabel.getText();
        if (str.length() == 0 || str.charAt(str.length()-1) == '(' || isOperator(str.charAt(str.length()-1))) {
            equationLabel.setText(str+"(");
            return;
        }
        int cntStart = 0;
        int cntEnd = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' /*&& !str.substring(i).startsWith("(\u002D")*/) {
                cntStart++;
            }
            else if (str.charAt(i) == ')'){
                cntEnd++;
            }
        }
        if (cntStart == cntEnd) {
            equationLabel.setText(str + "(");
        } else {
            equationLabel.setText(str + ")");
        }
    }

    private void Solve(JLabel resultLabel, JLabel equationLabel) {
        String str = equationLabel.getText();
        if (checkEquation(str)) {
            str = infixToPostfix(str);
            double ans = getAnswerFromPostfix(str);
            if ((int)ans == ans) {
                resultLabel.setText(String.valueOf((int)ans));
            } else {
                resultLabel.setText(String.valueOf(ans));
            }
        } else {
            equationLabel.setForeground(Color.RED.darker());
        }
    }

    private int checkCurrentEquation(String str) {
        if (str.length() == 0) return -1;
        if (str.charAt(str.length()-1) == '.') {
            return 3;
        } else if (getPrecedence(str.charAt(0)) == -1 && getPrecedence(str.charAt(str.length()-1)) == -1) {
            return 1;
        } else if (getPrecedence(str.charAt(str.length()-1)) != -1) {
            return 2;
        }
        return -1;
    }

    private boolean checkEquation(String str) {
        if (getPrecedence(str.charAt(str.length()-1)) != -1) return false;
        for (int i = 0; i < str.length(); i++) {
            if ("divide".equals(getOperator(str.charAt(i))) && str.charAt(i+1) == '0') return false;
        }
        return true;
    }

    private double getAnswerFromPostfix(String str) {
        String[] strArray = str.split("\\s+");
        Stack<String> st = new Stack<>();
        for (String s : strArray) {
            if (s.length() == 0) {
                continue;
            }
            if (s.length() > 1 || !isOperator(s.charAt(0))) {
                st.push(s);
            } else {
                String operator = getOperator(s.charAt(0));
                double ans = 0;
                if ("add".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    double num2 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = num2 + num1;
                } else if ("subtract".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    double num2 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = num2 - num1;
                } else if ("multiply".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    double num2 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = num2 * num1;
                } else if ("divide".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    double num2 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = num2 / num1;
                } else if ("sqrt".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = Math.sqrt(num1);
                } else if ("power".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    double num2 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = Math.pow(num2, num1);
                }
                st.push(String.valueOf(ans));
            }
        }
        return Double.parseDouble(st.peek());
    }

    private String infixToPostfix(String str) {
        Stack<Character> stack =new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!isOperator(str.charAt(i)) && !isParenthesis(str.charAt(i)) || str.charAt(i) == '\u002D' && str.charAt(i - 1) == '(') {
                ans.append(str.charAt(i));
            } else {
                char currentCh = str.charAt(i);
                if (i!= 0 && currentCh == '\u221A' && !isOperator(str.charAt(i-1))) {
                    char ch = '\u00D7';
                    if (stack.empty() || getPrecedence(stack.peek()) < getPrecedence(ch)) {
                        ans.append(" ");
                        stack.push(ch);
                    } else {
                        while (!stack.empty() && getPrecedence(stack.peek()) >= getPrecedence(ch)) {
                            ans.append(" ").append(stack.peek()).append(" ");
                            stack.pop();
                        }
                        stack.push(ch);
                    }
                }
                if (currentCh == '(') {
                    stack.push('(');
                } else if (currentCh == ')') {
                    while (stack.peek() != '(') {
                        ans.append(" ").append(stack.peek()).append(" ");
                        stack.pop();
                    }
                    stack.pop();
                } else if (stack.empty() || getPrecedence(stack.peek()) < getPrecedence(currentCh)) {
                    ans.append(" ");
                    stack.push(str.charAt(i));
                } else {
                    while (!stack.empty() && getPrecedence(stack.peek()) >= getPrecedence(currentCh)) {
                        ans.append(" ").append(stack.peek()).append(" ");
                        stack.pop();
                    }
                    stack.push(currentCh);
                }
            }
        }
        while (!stack.empty()) {
            ans.append(" ").append(stack.peek());
            stack.pop();
        }
        return ans.toString();
    }

    private boolean isParenthesis(char ch) {
        return ch == '(' || ch == ')';
    }

    private int getPrecedence(char ch) {
        if (ch == '^' || ch == '\u221A') {
            return 3;
        } else if (ch == '\u00F7' || ch == '\u00D7') {
            return 2;
        } else if (ch == '\u002B' || ch == '-') {
            return 1;
        }
        return -1;
    }

    boolean isOperator(char ch) {
        return ch == '\u00F7' || ch == '^' || ch == '\u221A' || ch == '\u00D7' || ch == '\u002B' || ch == '-';
    }

    private String getOperator(char ch) {
        if (ch == '^') {
            return "power";
        } else if (ch == '\u00F7') {
            return "divide";
        } else if (ch == '\u00D7') {
            return "multiply";
        } else if (ch == '\u002B') {
            return "add";
        } else if (ch == '-') {
            return "subtract";
        } else if (ch == '\u221A') {
            return "sqrt";
        }
        return null;
    }
}
