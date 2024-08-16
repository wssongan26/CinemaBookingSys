/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

/**
 *
 * @author ganws
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private JTextField userText;
    private JPasswordField passwordText;
    private Connection connection;

    public Login(Connection connection) {
        this.connection = connection;

        setTitle("Login Account");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel userLabel = new JLabel("User:");
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userText = new JTextField(20);
        userText.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordText = new JPasswordField(20);
        passwordText.setHorizontalAlignment(SwingConstants.CENTER);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            Registration registration = new Registration(connection);
            registration.setVisible(true);
        });

        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText().trim();
        String password = new String(passwordText.getPassword());

        if (authenticate(user, password)) {
            JOptionPane.showMessageDialog(null, "You are successfully logged in.");

            // Open the next window (e.g., Movie)
            Movie next = new Movie();
            next.setVisible(true);
            dispose(); // Close the current login window
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");
            userText.setText("");
            passwordText.setText("");
        }
    }

    private boolean authenticate(String username, String password) {
    try {
        String query = "SELECT * FROM users WHERE username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String encryptedPassword = resultSet.getString("password");
            String decryptedPassword = CryptoUtils.decrypt(encryptedPassword);
            return password.equals(decryptedPassword);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to read user data.");
    }
    return false; // Authentication failed
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3307/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "1234");

                Login login = new Login(connection);
                login.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
