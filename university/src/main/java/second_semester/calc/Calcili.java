package second_semester.calc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JTextField;


public class Calcili {

        public JFrame calcWindow = new JFrame("КАКУлятор");
        public JTextField input = new JTextField();

        public Calcili() {
            calcWindow.setSize(290, 420);
            calcWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            calcWindow.getContentPane().setBackground(Color.white);
            calcWindow.setLayout(null);
            calcWindow.setResizable(false);
            calcWindow.setLocationRelativeTo(null);

            enter();
            u_btn();

            calcWindow.setVisible(true);
        }

        private void enter()
        {
            input.setFont(new Font("Arial", Font.BOLD, 24));
            input.setBounds(16, 10, 248, 36);
            input.setBackground(Color.white);
            input.setHorizontalAlignment(JTextField.RIGHT);

            calcWindow.add(input);

            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.addKeyEventDispatcher((KeyEventDispatcher) new KeyDispatcher());
        }


        class KeyDispatcher implements KeyEventDispatcher {
            public boolean dispatchKeyEvent(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    result();
                }

                if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    input.setText("");
                }

                return false;
            }
        }


        private void u_btn() {
            int num = 0;
            String[] arr = {"1","2","3","<--","4","5","6","С","7","8","9","*","0","-",".","+","/","(",")","="};
            JButton[] jb = new JButton[arr.length];

            for (int e=0; e<5; e++) {
                for (int r=0; r<4; r++) {
                    jb[num] = new JButton();
                    jb[num].setFont(new Font("Arial", Font.PLAIN, 36));
                    jb[num].setText(arr[num]);
                    jb[num].setMargin(new Insets(0,0,0,0));
                    jb[num].setBounds(16+r*62, 55+e*62, 60, 60);
                    jb[num].setFocusable(false);

                    calcWindow.add(jb[num]);

                    ActionListener num_button = new GoNumListener();
                    jb[num].addActionListener(num_button);

                    if (num < arr.length - 1) {
                        num++;
                    }
                    else {
                        break;
                    }
                }
            }
        }


        public class GoNumListener implements ActionListener {
            public void actionPerformed(ActionEvent e){
                String name = ((JButton)e.getSource()).getText();
                if (name.equals("=") || name.equals("С")) {
                }
                else {
                    input.setText(input.getText()+name);
                }


                if (name.equals("=")) {
                    result();
                }


                if (name.equals("С"))  {
                    input.setText("");
                }

                if (name.equals("<--"))  {
                    String s = input.getText();

                    s = s.replaceAll("<--","");

                    if (input.getText().contains("<--")){
                        input.setText("");
                    }

                    if (s.length() > 0){
                        s = s.substring(0, s.length()-1);
                        input.setText(s);
                    }

                }


                calcWindow.repaint();
            }
        }


        private void result() {
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            try {
                input.setText("" + engine.eval(input.getText()));
            }
            catch (ScriptException ignored){   }
        }






}
