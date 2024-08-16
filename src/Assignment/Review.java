/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

/**
 *
 * @author ganws
 */
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Review extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel descLabel, rateLabel;
    private JTextField descText;
    private JButton submitButton;
    private Choice ratingChoice;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/reviews";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";

    public Review() {
        setTitle("Review");
        setSize(300, 200);
        setLocation(500, 200);

        panel = new JPanel();
        panel.setLayout(null);

        descLabel = new JLabel("Description: ");
        descLabel.setBounds(10, 20, 80, 20);
        panel.add(descLabel);

        descText = new JTextField(200);
        descText.setBounds(100, 20, 165, 25);
        panel.add(descText);

        rateLabel = new JLabel("Rating: ");
        rateLabel.setBounds(10, 50, 80, 25);
        panel.add(rateLabel);

        ratingChoice = new Choice();
        ratingChoice.setBounds(100, 50, 165, 25);
        ratingChoice.add("1");
        ratingChoice.add("2");
        ratingChoice.add("3");
        ratingChoice.add("4");
        ratingChoice.add("5");
        panel.add(ratingChoice);

        submitButton = new JButton("Submit");
        submitButton.setBounds(10, 80, 80, 25);
        submitButton.addActionListener(this);
        panel.add(submitButton);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String description = descText.getText();
        String rating = ratingChoice.getSelectedItem();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "1234")) {
            String sql = "INSERT INTO reviews (description, rating) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, description);
            statement.setInt(2, Integer.parseInt(rating));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Thank you for your review. It has been submitted.");
                descText.setText(""); // Clear text field after submission
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while submitting review.");
        }
    }

    public static void main(String[] args) {
        // Create and display the GUI on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            new Review();
        });
    }
}
