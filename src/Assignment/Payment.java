
package Assignment;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton cashbut, qrbut, ewalletbut;
    private ImageIcon qrIcon;
    private int seatPrice;

    public Payment(int seatPrice) {
        this.seatPrice = seatPrice;
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Confirm Payment");

        qrIcon = new ImageIcon("c:\\Users\\ganws\\Documents\\NetBeansProjects\\Assignment SEM\\img\\QR.jpeg");
        Image scaledImage = qrIcon.getImage().getScaledInstance(300, -1, Image.SCALE_SMOOTH); // Resize image
        qrIcon = new ImageIcon(scaledImage);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel label = new JLabel("Payment Method:\n" + "Seat Price: $" + seatPrice);
        label.setFont(new Font("Verdana", Font.BOLD, 22));

        cashbut = new JButton("Cash");
        qrbut = new JButton("QRPay");
        ewalletbut = new JButton("Ewallet");

        // Set preferred size for buttons
        cashbut.setPreferredSize(new Dimension(120, 40));
        qrbut.setPreferredSize(new Dimension(120, 40));
        ewalletbut.setPreferredSize(new Dimension(120, 40));

        cashbut.addActionListener(this);
        qrbut.addActionListener(this);
        ewalletbut.addActionListener(this);

        cashbut.setActionCommand("actionName");
        qrbut.setActionCommand("actionName2");
        ewalletbut.setActionCommand("actionName3");

        panel.add(label, BorderLayout.NORTH);
        panel.add(cashbut, BorderLayout.WEST);
        panel.add(qrbut, BorderLayout.CENTER);
        panel.add(ewalletbut, BorderLayout.EAST);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(200, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = ((JButton) e.getSource()).getActionCommand();

        switch (actionCommand) {
            case "actionName":
                 JOptionPane.showMessageDialog(null, "Thank you for Choosing Us!! You can make a payment and redeem your ticket at the Counter.");
                Review next = new Review();
                next.setVisible(true);
                frame.dispose();
                break;

            case "actionName2":
                JPanel qrPanel = new JPanel(new BorderLayout());
                JLabel qrLabel = new JLabel(qrIcon);
                qrPanel.add(qrLabel, BorderLayout.CENTER);
                JOptionPane.showMessageDialog(null, qrPanel, "Ewallet Payment", JOptionPane.PLAIN_MESSAGE);
 JOptionPane.showMessageDialog(null, qrPanel, "Ewallet Payment", JOptionPane.PLAIN_MESSAGE);
                Review halo = new Review();
                halo.setVisible(true);
                frame.dispose();                break;

            case "actionName3":
                TestAccountMenu ew = new TestAccountMenu();
                Review halo1 = new Review();
                halo1.setVisible(true);
                frame.dispose();
                break;
        }
    }
}
