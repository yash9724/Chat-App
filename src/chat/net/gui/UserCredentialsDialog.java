/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.net.gui;

import chat.net.pojo.ChatClients;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserCredentialsDialog extends JDialog implements ActionListener {

    private final JPanel panel;
    private final JButton btnCancel;
    private final JButton btnOK;
    private final JLabel lblUsername;
    private final JLabel lblPassword;
    private final JLabel lblLogin;
    private final JTextField txtUsername;
    private final JPasswordField txtPassword;
    private ChatClients newClient;

    public UserCredentialsDialog(JFrame parent) {
        super(parent, "LOGIN/SIGNUP Dialog", true);
        this.setSize(400, 220);
        Point dialogLoc = parent.getLocation();
        this.setLocation(dialogLoc.x + 80, dialogLoc.y + 80);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        panel = new JPanel();
        panel.setSize(400, 220);
        this.add(panel);
        panel.setLayout(null);

        btnOK = new JButton("OK");
        btnOK.setSize(80, 25);
        btnOK.addActionListener(this);
        btnOK.setLocation(170, 133);
        panel.add(btnOK);

        btnCancel = new JButton("Cancel");
        btnCancel.setSize(80, 25);
        btnCancel.addActionListener(this);
        btnCancel.setLocation(270, 133);
        panel.add(btnCancel);

        lblUsername = new JLabel("Username: ");
        panel.add(lblUsername);
        lblUsername.setSize(120, 30);
        lblUsername.setLocation(50, 50);

        lblPassword = new JLabel("Password: ");
        panel.add(lblPassword);
        lblPassword.setSize(120, 30);
        lblPassword.setLocation(50, 80);

        lblLogin = new JLabel("LOGIN/SIGNUP DIALOG");
        panel.add(lblLogin);
        lblLogin.setSize(200, 50);
        lblLogin.setLocation(145, 4);

        txtUsername = new JTextField();
        txtUsername.setSize(150, 27);
        txtUsername.setLocation(190, 50);
        panel.add(txtUsername);

        txtPassword = new JPasswordField();
        txtPassword.setSize(150, 27);
        txtPassword.setLocation(190, 80);
        panel.add(txtPassword);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnOK) {

            if (validateInput()) {
                JOptionPane.showMessageDialog(null, "Fields cannot be empty", "EMPTY FIELDS", JOptionPane.WARNING_MESSAGE);
                return;
            }
            newClient = new ChatClients();
            newClient.setUsername(txtUsername.getText());
            newClient.setPassword(new String(txtPassword.getPassword()));
            this.dispose();

        } else if (e.getSource() == btnCancel) {

            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave this chat?", "CONFIRM", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                this.dispose();
                return;
            }
        }
    }

    public ChatClients getClient() {
        return newClient;
    }

    public boolean validateInput() {
        return txtUsername.getText().isEmpty() || (new String(txtPassword.getPassword())).isEmpty();
    }
}
