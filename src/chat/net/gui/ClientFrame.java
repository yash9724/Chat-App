package chat.net.gui;

import chat.net.pojo.ChatClients;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ClientFrame extends javax.swing.JFrame {

    Socket socks;
    PrintWriter pw;
    Scanner scanner;
    ChatClients client;
    ObjectOutputStream oos;

    public ClientFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblClientFrame = new javax.swing.JLabel();
        txtChatField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        btnConnectToServer = new javax.swing.JButton();
        btnSendMessage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("CHAT MODIFIED");

        lblClientFrame.setText("CLIENT FRAME");

        txtChatField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChatFieldActionPerformed(evt);
            }
        });

        txtChat.setColumns(20);
        txtChat.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtChat.setRows(5);
        jScrollPane1.setViewportView(txtChat);

        btnConnectToServer.setText("CONNECT TO SERVER");
        btnConnectToServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectToServerActionPerformed(evt);
            }
        });

        btnSendMessage.setText("SEND MESSAGE");
        btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnConnectToServer, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addComponent(txtChatField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblClientFrame))
                        .addGap(0, 336, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnConnectToServer, btnSendMessage});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClientFrame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtChatField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnectToServer)
                    .addComponent(btnSendMessage))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectToServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectToServerActionPerformed

        try {
            socks = new Socket("localhost", 9724);
            txtChat.append("Connected to Server\n");

            btnConnectToServer.setEnabled(false);
            scanner = new Scanner(socks.getInputStream());
            pw = new PrintWriter(socks.getOutputStream(), true);
            oos = new ObjectOutputStream(socks.getOutputStream());
            ChatThread chatThread = new ChatThread();
            chatThread.start();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "This Server does not exists.", "Error in Connection", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (ConnectException e) {
            JOptionPane.showMessageDialog(null, "Server not available currently.\nTry Again after some time ", "Error in Connection", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Server not available currently.\nTry Again after some time ", "Error in Connection", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }


    }//GEN-LAST:event_btnConnectToServerActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        pw.println("quit");
        pw.close();
        scanner.close();
    }//GEN-LAST:event_formWindowClosing

    private void btnSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMessageActionPerformed
        String message = txtChatField.getText();
        if (!message.equalsIgnoreCase("")) {
            pw.println(message);
            txtChat.append("\n" + client.getUsername() + ":" + message);
            txtChatField.setText("");
            if (message.equalsIgnoreCase("quit")) {
                this.dispose();
                System.exit(0);
            }
        }
    }//GEN-LAST:event_btnSendMessageActionPerformed

    private void txtChatFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChatFieldActionPerformed
        btnSendMessageActionPerformed(evt);
    }//GEN-LAST:event_txtChatFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnectToServer;
    private javax.swing.JButton btnSendMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClientFrame;
    private javax.swing.JTextArea txtChat;
    private javax.swing.JTextField txtChatField;
    // End of variables declaration//GEN-END:variables

    class ChatThread extends Thread {

        @Override
        public void run() {
            while (scanner.hasNextLine()) {
                String serverMessage = scanner.nextLine();

                if (serverMessage.equals("LOGIN/SIGNUP DIALOG")) {
                    login();
                } else if (serverMessage.equals("NAME ALREADY EXITS")) {
                    JOptionPane.showMessageDialog(null, "This name already exists. Try another name.", "Name Already Exists", JOptionPane.PLAIN_MESSAGE);
                    login();
                } else if (serverMessage.equals("NAME ACCEPTED")) {
                    JOptionPane.showMessageDialog(null, "Client details accepted.\nYou can now start chatting in chat window.", "Client Accepted", JOptionPane.PLAIN_MESSAGE);
                    txtChat.append("Type your message in the field below and click Send Message button\n");
                    btnSendMessage.setEnabled(true);
                    txtChatField.setEnabled(true);
                    lblClientFrame.setText("You are logged in as: " + client.getUsername());
                } else if (serverMessage.equals("CLIENT REGISTERED SUCCESSFULLY")) {
                    JOptionPane.showMessageDialog(null, "You have been registered and logged in successfully", "Client Registered", JOptionPane.PLAIN_MESSAGE);
                    txtChat.append("Type your message in the field below and click Send Message button\n");
                    btnSendMessage.setEnabled(true);
                    txtChatField.setEnabled(true);
                    lblClientFrame.setText("You are logged in as: " + client.getUsername());
                } else if (serverMessage.equals("PROBLEM OCCURED WHILE ADDING CLIENT")) {
                    JOptionPane.showMessageDialog(null, "Problem occurred while logging.\nTry Again.", "Could Not Log In", JOptionPane.ERROR_MESSAGE);
                    System.exit(-1);
                } else {
                    String othersMessage = serverMessage;
                    txtChat.append("\n" + othersMessage);
                }
            }
        }
    }

    public void login() {
        UserCredentialsDialog newUser = new UserCredentialsDialog(ClientFrame.this);
        newUser.setVisible(true);
        client = newUser.getClient();
        if (client != null) {
            try {
                oos.writeObject(client);
                oos.flush();
            } catch(IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Problem occurred while logging.\nTry Again.", "Could Not Log In", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
            }
        } else {
            System.exit(0);
        }
    }

}
