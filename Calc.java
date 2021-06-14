import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.lang.String;
import java.lang.Long;
import java.math.BigInteger;

/**
 * Created by Abazar Mohiti.
 */
public class Calc extends JFrame {
    public static void main(String[] args) {
        new Calc();


    }

    private JTextField textField;
    private JTextArea textArea;
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bDot, bDiv, bSta,
            bAdd, bMin, bMirr, bFuc, bEgu, bPow, bMS, bPi, bMR, bC, bInv, br;
    private JPanel show, number, operation;
    private double result, number1, number2, number0;
    private ActionListener numberAct, operationAct, equalAct, mAct, fourOpAc;
    private String memory = "0";
    private String mathAct = "";
    int n = 0;
    Math math;


    public Calc() {
        super(" Calculator");

        setSize(400, 280);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setLocation(500, 150);

      setResizable(false);

        actionKey();

        add(showPanel());
        add(numberPanel());
        add(operationPanel());
        setVisible(true);
    }

    private JPanel showPanel() {
        show = new JPanel(new FlowLayout(FlowLayout.CENTER));
        show.setPreferredSize(new Dimension(400, 80));
        textArea = new JTextArea("Abazar Mohiti");
        textArea.setPreferredSize(new Dimension(300, 30));
        textField = new JTextField(30);
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setText("0");
        show.add(textArea);
        show.add(textField);
        return show;
    }

    private JPanel numberPanel() {
        number = new JPanel(new FlowLayout());
        number.setPreferredSize(new Dimension(150, 150));
        Dimension butSiz = new Dimension(30, 30);
        b7 = new JButton("7");
        b7.addActionListener(numberAct);
        b7.setSize(butSiz);
        number.add(b7);
        b8 = new JButton("8");
        b8.setSize(butSiz);
        number.add(b8);
        b8.addActionListener(numberAct);
        b9 = new JButton("9");
        b9.setSize(butSiz);
        number.add(b9);
        b9.addActionListener(numberAct);
        b4 = new JButton("4");
        b4.setSize(butSiz);
        number.add(b4);
        b4.addActionListener(numberAct);
        b5 = new JButton("5");
        b5.setSize(butSiz);
        number.add(b5);
        b5.addActionListener(numberAct);
        b6 = new JButton("6");
        b6.setSize(butSiz);
        number.add(b6);
        b6.addActionListener(numberAct);
        b1 = new JButton("1");
        b1.setSize(butSiz);
        number.add(b1);
        b1.addActionListener(numberAct);
        b2 = new JButton("2");
        b2.setSize(butSiz);
        number.add(b2);
        b2.addActionListener(numberAct);
        b3 = new JButton("3");
        b3.setSize(butSiz);
        number.add(b3);
        b3.addActionListener(numberAct);
        b0 = new JButton("0");
        b0.setPreferredSize(new Dimension(90, 30));
        number.add(b0);
        b0.addActionListener(numberAct);
        bDot = new JButton(".");
        bDot.setSize(butSiz);
        number.add(bDot);
        bDot.addActionListener(numberAct);

        return number;
    }

    private JPanel operationPanel() {
        operation = new JPanel(new FlowLayout());
        operation.setPreferredSize(new Dimension(200, 150));
        Dimension butSiz = new Dimension(30, 30);
        Dimension butSiz2 = new Dimension(55, 30);

        bMS = new JButton("MS");
        bMS.setPreferredSize(butSiz2);
        operation.add(bMS);
        bMS.addActionListener(mAct);

        bMR = new JButton("MR");
        bMR.setPreferredSize(butSiz2);
        operation.add(bMR);
        bMR.addActionListener(mAct);


        bC = new JButton("C");
        bC.setPreferredSize(butSiz2);
        operation.add(bC);
        bC.addActionListener(mAct);

        br = new JButton("√");
        br.setSize(butSiz);
        operation.add(br);
        br.addActionListener(operationAct);

        bAdd = new JButton("+");
        bAdd.setSize(butSiz);
        operation.add(bAdd);
        bAdd.addActionListener(fourOpAc);

        bDiv = new JButton("/");
        bDiv.setSize(butSiz);
        operation.add(bDiv);
        bDiv.addActionListener(fourOpAc);

        bMin = new JButton("-");
        bMin.setSize(butSiz);
        operation.add(bMin);
        bMin.addActionListener(fourOpAc);

        bPi = new JButton("π");
        bPi.setSize(butSiz);
        operation.add(bPi);
        bPi.addActionListener(operationAct);

        bSta = new JButton("*");
        bSta.setSize(butSiz);
        operation.add(bSta);
        bSta.addActionListener(fourOpAc);


        bPow = new JButton("^");
        bPow.setSize(butSiz);
        operation.add(bPow);
        bPow.addActionListener(fourOpAc);


        bFuc = new JButton("!");
        bFuc.setSize(butSiz);
        operation.add(bFuc);
        bFuc.addActionListener(operationAct);



        bEgu = new JButton("=");
        bEgu.setPreferredSize(new Dimension(56, 30));
        operation.add(bEgu);
        bEgu.addActionListener(equalAct);


        bMirr = new JButton("+/-");
        bMirr.setPreferredSize(new Dimension(50, 30));
        operation.add(bMirr);
        bMirr.addActionListener(operationAct);

        bInv = new JButton("1/n");
        bInv.setPreferredSize(new Dimension(60, 30));
        operation.add(bInv);
        bInv.addActionListener(operationAct);

        return operation;

    }


    private void actionKey() {


        numberAct = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (n == 0) {
                    textField.setText(e.getActionCommand());
                    n++;
                } else textField.setText(textField.getText() + e.getActionCommand());
            }
        };
        fourOpAc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number1 = Float.parseFloat(textField.getText());
                mathAct = e.getActionCommand();
                textArea.setText(textField.getText() + mathAct);
                n = 0;
            }
        };
        mAct = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch (e.getActionCommand()) {
                    case "C":
                        number1 = 0;
                        textField.setText("0");
                        break;
                    case "MS":

                        memory = textField.getText();
                        break;
                    case "MR":
                        textField.setText(memory);
                }
                n = 0;
            }
        };

        operationAct = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number0 = Float.parseFloat(textField.getText());

                switch (e.getActionCommand()) {

                    case "√":
                        textArea.setText("√(" + textField.getText() + ")");
                        textField.setText(noDat0(math.sqrt(number0)));
                        break;
                    case "1/n":
                        textArea.setText("1/(" + textField.getText() + ")");
                        textField.setText(noDat0(1 / number0));
                        break;
                    case "+/-":
                        textField.setText(number0 + "");
                        break;
                    case "!":
                        textArea.setText(textField.getText() + "!");
                        textField.setText(fact((int) Math.floor(Math.abs(number0))) + "");
                        break;
                    case "π":
                        textField.setText("3.141592");


                }
                number1 = Double.parseDouble(textField.getText());

                n = 0;

            }
        };


        equalAct = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!mathAct.equals("")) {
                    number2 = Double.parseDouble(textField.getText());

                    switch (mathAct) {
                        case "+":
                            result = number1 + number2;
                            break;
                        case "-":
                            result = number1 - number2;
                            break;
                        case "*":
                            result = number1 * number2;
                            break;
                        case "/":
                            result = number1 / number2;
                            break;
                        case "^":
                            result =  math.pow(number1, number2);
                    }

                    textArea.setText(textArea.getText() +noDat0( number2));

                    textField.setText("" +noDat0(result) );
                } else {
                    textArea.setText(textField.getText());

                }

                number1 = 0;
                number2 = 0;
                mathAct = "";
                n = 0;
            }
        };

    }

    private Integer fact(int i) {
        if (i == 0)
            return 1;
        else if (i > 1) {
            i = i * fact(--i);
        }

        return i;
    }

    private String noDat0 (double i){
        long j = (long) i;
        if (j==i) return j+"";
        else return i+"";
    }
}
