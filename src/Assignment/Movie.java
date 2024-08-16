/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

/**
 *
 * @author ganws
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Movie extends JFrame implements ActionListener {

    JButton button1;
    JLabel typelbl;
    Dimension imageSize = new Dimension(200, 280); // Adjust the size as needed
    
    // Titles for each image
    String[] titles = {
        "One Piece: Stampede",
        "Saw II",
        "Love The Way You Are",
        "Land of the Dead",
        "Despicable Me 2"
    };

    public Movie() {
        setTitle("WOGT Movie ShowTime");
        setSize(1100, 550);
        setLocationRelativeTo(null); // Center the window on the screen
        setResizable(false);
        setBackground(new Color(128, 128, 128));

        typelbl = new JLabel(" WELCOME TO WOGT CIMEMA BOOKING SYSTEM ");
        typelbl.setFont(new Font("Verdana", Font.BOLD, 35));
               
        // Add space below the label
        typelbl.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(0, 0, 20, 0), // Add 20 pixels of space at the bottom
            BorderFactory.createLineBorder(Color.BLACK) // Add a black line border to separate the label from the rest of the content
        ));
        
        JPanel imagesPanel = new JPanel();
        imagesPanel.setLayout(new GridLayout(0, 3, 20, 20)); // 3 images per row with 20 pixels horizontal and vertical gap

        // Image labels
        for (int i = 1; i <= 5; i++) {
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\ganws\\Documents\\NetBeansProjects\\Assignment SEM\\img\\i" + i + ".png");
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(imageSize.width, imageSize.height, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
            
            JLabel imgLabel = new JLabel(scaledImageIcon);
            imgLabel.setName("Image " + i);
            imgLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the image within its box
            
            // Add mouse listener to handle image click events
            imgLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Set border to indicate selection
                    Border border = BorderFactory.createLineBorder(Color.yellow, 3);
                    imgLabel.setBorder(border);
     
                }
                
                 @Override
                public void mouseExited(MouseEvent e) {
                    // Remove border when released
                    imgLabel.setBorder(null);
                
                }
                
                @Override
                public void mousePressed(MouseEvent e) {
                    // Set border to indicate selection
                    Border border = BorderFactory.createLineBorder(Color.GRAY, 3);
                    imgLabel.setBorder(border);
     
                }
                
                @Override
                public void mouseReleased(MouseEvent e) {
                    // Remove border when released
                    imgLabel.setBorder(null);
                    
                    // Retrieve the index of the clicked image
                    String imageName = imgLabel.getName();
                    int index = Integer.parseInt(imageName.substring(imageName.indexOf(" ") + 1));
                                       
                    // Get the corresponding MovieDetails object
                    MovieDetails movieDetails = MovieDetails.createMovieDetailsList().get(index - 1);

                    // Show details of the clicked movie
                    showDetails(movieDetails);
                }
                
                
            });

            JLabel titleLabel = new JLabel(titles[i - 1]); // Replace with actual title
            titleLabel.setFont(new Font("Verdana", Font.BOLD, 14));
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER); 

            JPanel titlePanel = new JPanel();
            titlePanel.add(titleLabel);

            JPanel imageAndTitlePanel = new JPanel(new BorderLayout());
            imageAndTitlePanel.add(imgLabel, BorderLayout.CENTER);
            imageAndTitlePanel.add(titlePanel, BorderLayout.SOUTH);

            imagesPanel.add(imageAndTitlePanel);
        }

        button1 = new JButton("Book Now!!");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button1.setBackground(Color.YELLOW); // Change background color to yellow when mouse enters
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button1.setBackground(UIManager.getColor("control")); // Restore default background color when mouse exits
            }
        });
        button1.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane(imagesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(button1);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(typelbl);
        mainPanel.add(scrollPane);
        mainPanel.add(buttonPanel);

        getContentPane().add(mainPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Open Booking module
        new Booking().setVisible(true);
        dispose(); // Close the current window
    }

    private void showDetails(String details) {
        JOptionPane.showMessageDialog(this, details, "Movie Details", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showDetails(MovieDetails movieDetails) {
        // Format the movie details with HTML to allow text wrapping
        String details = "<html>"
                + "<b>Title:</b> " + movieDetails.getTitle() + "<br>"
                + "<b>Description:</b> <br>" + "<div style='width: 250px;'>" + movieDetails.getDescription() + "</div>" + "<br>"
                + "<b>Duration:</b> " + movieDetails.getDuration() + "<br>"
                + "<b>Genre:</b> " + movieDetails.getGenre() + "<br>"
                + "<b>Language:</b> " + movieDetails.getLanguage() + "<br>"
                + "<b>Subtitle:</b> " + movieDetails.getSubtitle() + "<br>"
                + "<b>Classification:</b> " + movieDetails.getClassification() + "<br>"
                + "</html>";

        JOptionPane.showMessageDialog(this, details, "Movie Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new Movie().setVisible(true);
    }
}










