/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.net.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class TestFrame extends JFrame implements ActionListener {

    static UserCredentialsDialog dialog;
    static JButton button1;
    static JButton button2;
    static JTextField txtField;

    public TestFrame() {
        super("Test Frame");

        //JFrame frame = new JFrame();
        setLayout(null);
        setVisible(true);
        setSize(600, 400);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setSize(600,400);
        //panel.setLocation();
        add(panel);

        button1 = new JButton("OK");
        panel.add(button1);
        button1.setSize(30, 30);
        button1.setLocation(100, 100);
        button1.addActionListener(this);

        txtField = new JTextField();
        txtField.setSize(50, 50);
        txtField.setLocation(50, 150);
        panel.add(txtField);

        button2 = new JButton("Click Here");
        button2.setSize(50,50);
        button2.setLocation(100,200);
        panel.add(button2);
        button2.addActionListener(this);

        //frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        //dialog.setVisible(true);
        //frame.add(dialog);
    }

    public static void main(String[] args) {
        TestFrame test = new TestFrame();

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            dialog = new UserCredentialsDialog(this);
            dialog.setVisible(true);
        } else if (e.getSource() == button2) {

            JOptionPane.showMessageDialog(null, "Entered text is: " + txtField.getText(), "TEXT", JOptionPane.PLAIN_MESSAGE);
        }
    }

}
