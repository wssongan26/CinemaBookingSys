/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

/**
 *
 * @author ganws
 */
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame implements ActionListener {

    private JTextField userText;
    private JPasswordField passwordText, confirmPasswordText;
    private Connection connection;

    public Registration(Connection connection) {
        this.connection = connection;

        setTitle("Register New Account");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(50, 30, 80, 20);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(140, 30, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 70, 80, 20);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(140, 70, 165, 25);
        panel.add(passwordText);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(10, 110, 120, 20);
        panel.add(confirmPasswordLabel);

        confirmPasswordText = new JPasswordField();
        confirmPasswordText.setBounds(140, 110, 165, 25);
        panel.add(confirmPasswordText);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(120, 160, 100, 30);
        registerButton.addActionListener(this);
        panel.add(registerButton);

        add(panel);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    String user = userText.getText().trim();
    String password = new String(passwordText.getPassword());
    String encryptedPassword = CryptoUtils.encrypt(password);

    if (!password.equals(new String(confirmPasswordText.getPassword()))) {
        JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
        passwordText.setText("");
        confirmPasswordText.setText("");
        return;
    }

    // Save user registration with encrypted password to the database
    try {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, encryptedPassword);
        int executeUpdate = preparedStatement.executeUpdate();

        JOptionPane.showMessageDialog(null, "Registration Successful!");
        dispose();

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to save registration data.");
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3307/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "1234");

                Registration registration = new Registration(connection);
                registration.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
