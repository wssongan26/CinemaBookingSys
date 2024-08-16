/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Assignment;

/**
 *
 * @author ganws
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.io.*;
import java.sql.*;

public class Booking extends JFrame implements ActionListener {

    JTextField seat, totalcost;
    Choice type, block, time, movie; // Choices for the GUI
    JLabel typelbl, blocklbl, timelbl, lblbl, inputseatlbl, totallbl, title, movielbl;
    JButton submitbut, showbut, paybut, close;
    String selectedtime, selectedseat, selectedblock, tickettype, selectedmovietype;
    int timechoice, convertedseat1, convertedseat2, totalprice;
    int totaltickets = 0;

    Seat leftside1[][] = new Seat[6][6];
    Seat midside1[][] = new Seat[6][6];
    Seat rightside1[][] = new Seat[6][6]; // Each one of these creates an array for each block

    Seat leftside3[][] = new Seat[6][6];
    Seat midside3[][] = new Seat[6][6];
    Seat rightside3[][] = new Seat[6][6];

    Seat leftside5[][] = new Seat[6][6];
    Seat midside5[][] = new Seat[6][6];
    Seat rightside5[][] = new Seat[6][6];

    Seat leftside7[][] = new Seat[6][6];
    Seat midside7[][] = new Seat[6][6];
    Seat rightside7[][] = new Seat[6][6];

    Seat leftside9[][] = new Seat[6][6];
    Seat midside9[][] = new Seat[6][6];
    Seat rightside9[][] = new Seat[6][6];

    Ticket tickets[] = new Ticket[40]; //Array for storing the tickets booked

    public Booking() {

        setTitle("WOGT Cinema Ticket System");
        setSize(1200, 550);
        setLocation(50, 100);
        setResizable(false);
        setLayout(new FlowLayout());
        ImageIcon imgtitle = new ImageIcon("");
        title = new JLabel(imgtitle);
        movielbl = new JLabel("Movie Name: ");
        movielbl.setFont(new Font("Verdana", Font.BOLD, 15));
        movie = new Choice();
        movie.add("One Pierced (Hall 1)");
        movie.add("The Saw (Hall 2)");
        movie.add("When Young Got You (Hall 3)");
        movie.add("Land of the Dead (Hall 4)");
        movie.add("Despicable me 2 (Hall 5)");
        typelbl = new JLabel("Ticket Type: ");
        typelbl.setFont(new Font("Verdana", Font.BOLD, 15));
        type = new Choice();
        type.add("Adult");
        type.add("Child");
        type.add("OKU");
        blocklbl = new JLabel("Block:");
        blocklbl.setFont(new Font("Verdana", Font.BOLD, 15));
        block = new Choice();
        block.add("Left Block");
        block.add("Middle Block");
        block.add("Right Block");
        timelbl = new JLabel("Time: ");
        timelbl.setFont(new Font("Verdana", Font.BOLD, 15));
        time = new Choice();
        time.add("13:00");
        time.add("15:00");
        time.add("17:00");
        time.add("19:00");
        time.add("21:00");
        paybut = new JButton("Pay");
        paybut.setBackground(Color.YELLOW);
        ImageIcon lbimg = new ImageIcon("c:\\Users\\ganws\\Documents\\NetBeansProjects\\Assignment SEM\\img\\img2.jpg");
        lblbl = new JLabel(lbimg);
        inputseatlbl = new JLabel("Enter Seat Num: ");
        inputseatlbl.setFont(new Font("Verdana", Font.BOLD, 15));
        seat = new JTextField(2);
        seat.setFont(new Font("Verdana", Font.BOLD, 20));
        seat.setHorizontalAlignment(seat.CENTER);
        totallbl = new JLabel("Total Price: ");
        totallbl.setFont(new Font("Verdana", Font.BOLD, 15));
        totalcost = new JTextField(7);
        totalcost.setFont(new Font("Verdana", Font.BOLD, 15));
        totalcost.setHorizontalAlignment(totalcost.CENTER);
        totalcost.setEditable(false);
        submitbut = new JButton("Submit");
        submitbut.setBackground(Color.white);
        showbut = new JButton("Show");
        showbut.setBackground(Color.white);
        close = new JButton("Close");
        close.setBackground(Color.white);


        /* The following delcarations
		initialise the variables for
		the positions of the blocks */
        int xleft = 0;
        int yleft = 0;
        int xmid = 0;
        int ymid = 0;
        int xright = 0;
        int yright = 0;

        xleft = 50;
        yleft = 310; //Initial positions
        int totalleftside1 = 0; //'Total' is the total and is used to label the seats

        for (int i = 0; i < leftside1.length; i++) {
            for (int j = 0; j < 6; j++) {
                leftside1[i][j] = new Seat(totalleftside1, 0, xleft, yleft);
                xleft += 50; //Moving the next seat along the x position by 50
                totalleftside1++; //Adding one to the total for the next seat
            }
            xleft = 50; //Moving back to the left for the next row
            yleft += 30; //Moving down for the next row
        }

        xmid = 400;
        ymid = 310; //Initial positions
        int totalmidside1 = 0; //'Total' is the total and is used to label the seats
        for (int i = 0; i < midside1.length; i++) {
            for (int j = 0; j < 6; j++) {
                midside1[i][j] = new Seat(totalmidside1, 0, xmid, ymid);
                xmid += 50; //Moving the next seat along the x position by 50
                totalmidside1++; //Adding one to the total for the next seat
            }
            xmid = 400; //Moving back to the left for the next row
            ymid += 30;  //Moving down for the next row
        }

        xright = 750;
        yright = 310; //Initial positions
        int totalrightside1 = 0; //'Total' is the total and is used to label the seats
        for (int i = 0; i < rightside1.length; i++) {
            for (int j = 0; j < 6; j++) {
                rightside1[i][j] = new Seat(totalrightside1, 0, xright, yright);
                xright += 50; //Moving the next seat along the x position by 50
                totalrightside1++; //Adding one to the total for the next seat
            }
            xright = 750; //Moving back to the left for the next row
            yright += 30; //Moving down for the next row
        }

        /* The next lines of code perform the same processes as the ones before such as positions for each block */
        xleft = 50;
        yleft = 310;
        int totalleftside3 = 0;
        for (int i = 0; i < leftside3.length; i++) {
            for (int j = 0; j < 6; j++) {
                leftside3[i][j] = new Seat(totalleftside3, 0, xleft, yleft);
                xleft += 50;
                totalleftside3++;
            }
            xleft = 50;
            yleft += 30;
        }

        xmid = 400;
        ymid = 310;
        int totalmidside3 = 0;
        for (int i = 0; i < midside3.length; i++) {
            for (int j = 0; j < 6; j++) {
                midside3[i][j] = new Seat(totalmidside3, 0, xmid, ymid);
                xmid += 50;
                totalmidside3++;
            }
            xmid = 400;
            ymid += 30;
        }

        xright = 750;
        yright = 310;
        int totalrightside3 = 0;
        for (int i = 0; i < rightside3.length; i++) {
            for (int j = 0; j < 6; j++) {
                rightside3[i][j] = new Seat(totalrightside3, 0, xright, yright);
                xright += 50;
                totalrightside3++;
            }
            xright = 750;
            yright += 30;
        }

        xleft = 50;
        yleft = 310;
        int totalleftside5 = 0;

        for (int i = 0; i < leftside5.length; i++) {
            for (int j = 0; j < 6; j++) {
                leftside5[i][j] = new Seat(totalleftside5, 0, xleft, yleft);
                xleft += 50;
                totalleftside5++;
            }
            xleft = 50;
            yleft += 30;
        }

        xmid = 400;
        ymid = 310;
        int totalmidside5 = 0;
        for (int i = 0; i < midside5.length; i++) {
            for (int j = 0; j < 6; j++) {
                midside5[i][j] = new Seat(totalmidside5, 0, xmid, ymid);
                xmid += 50;
                totalmidside5++;
            }
            xmid = 400;
            ymid += 30;
        }

        xright = 750;
        yright = 310;
        int totalrightside5 = 0;
        for (int i = 0; i < rightside5.length; i++) {
            for (int j = 0; j < 6; j++) {
                rightside5[i][j] = new Seat(totalrightside5, 0, xright, yright);
                xright += 50;
                totalrightside5++;
            }
            xright = 750;
            yright += 30;
        }

        xleft = 50;
        yleft = 310;
        int totalleftside7 = 0;

        for (int i = 0; i < leftside7.length; i++) {
            for (int j = 0; j < 6; j++) {
                leftside7[i][j] = new Seat(totalleftside7, 0, xleft, yleft);
                xleft += 50;
                totalleftside7++;
            }
            xleft = 50;
            yleft += 30;
        }

        xmid = 400;
        ymid = 310;
        int totalmidside7 = 0;
        for (int i = 0; i < midside7.length; i++) {
            for (int j = 0; j < 6; j++) {
                midside7[i][j] = new Seat(totalmidside7, 0, xmid, ymid);
                xmid += 50;
                totalmidside7++;
            }
            xmid = 400;
            ymid += 30;
        }

        xright = 750;
        yright = 310;
        int totalrightside7 = 0;
        for (int i = 0; i < rightside7.length; i++) {
            for (int j = 0; j < 6; j++) {
                rightside7[i][j] = new Seat(totalrightside7, 0, xright, yright);
                xright += 50;
                totalrightside7++;
            }
            xright = 750;
            yright += 30;
        }

        xleft = 50;
        yleft = 310;
        int totalleftside9 = 0;

        for (int i = 0; i < leftside9.length; i++) {
            for (int j = 0; j < 6; j++) {
                leftside9[i][j] = new Seat(totalleftside9, 0, xleft, yleft);
                xleft += 50;
                totalleftside9++;
            }
            xleft = 50;
            yleft += 30;
        }

        xmid = 400;
        ymid = 310;
        int totalmidside9 = 0;
        for (int i = 0; i < midside9.length; i++) {
            for (int j = 0; j < 6; j++) {
                midside9[i][j] = new Seat(totalmidside9, 0, xmid, ymid);
                xmid += 50;
                totalmidside9++;
            }
            xmid = 400;
            ymid += 30;
        }
        xright = 750;
        yright = 310;
        int totalrightside9 = 0;
        for (int i = 0; i < rightside9.length; i++) {
            for (int j = 0; j < 6; j++) {
                rightside9[i][j] = new Seat(totalrightside9, 0, xright, yright);
                xright += 50;
                totalrightside9++;
            }
            xright = 750;
            yright += 30;
        }

        /* Adding the labels and text boxes to the screen */
        getContentPane().add(title);
        getContentPane().add(movielbl);
        getContentPane().add(movie);
        getContentPane().add(typelbl);
        getContentPane().add(type);
        getContentPane().add(blocklbl);
        getContentPane().add(block);
        getContentPane().add(timelbl);
        getContentPane().add(time);
        getContentPane().add(showbut);
        getContentPane().add(inputseatlbl);
        getContentPane().add(seat);
        getContentPane().add(submitbut);
        getContentPane().add(totallbl);
        getContentPane().add(totalcost);
        getContentPane().add(paybut);
        getContentPane().add(lblbl);
        getContentPane().add(close);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Color mycolor = new Color(255, 255, 255);
        getContentPane().setBackground(mycolor);

        submitbut.addActionListener(this);
        showbut.addActionListener(this); //Action listener for each individual button
        paybut.addActionListener(this);
        close.addActionListener(new CloseListener());
        
        
        
    }

    public void paint(Graphics graf) {
        super.paint(graf);

        switch (timechoice) {
            case 1:
                for (int i = 0; i < leftside1.length; i++) //Looping throw the leftside at 1 block - gives initial size
                {
                    for (int j = 0; j < 6; j++) //Looping through each row fully
                    {
                        leftside1[i][j].display(graf); //Displaying the left side @ 1
                        midside1[i][j].display(graf); //Displaying the mid side @ 1
                        rightside1[i][j].display(graf); //Displaying the right side @ 1
                    }
                }
                break;
            case 3:
                for (int i = 0; i < leftside3.length; i++) //Looping through the leftside at 3 block - gives initial size
                {
                    for (int j = 0; j < 6; j++) //Looping through each row fully
                    {
                        leftside3[i][j].display(graf); //Displaying the left side @ 3
                        midside3[i][j].display(graf); //Displaying the mid side @ 3
                        rightside3[i][j].display(graf); //Displaying the right side @ 3
                    }
                }
                break;
            case 5:
                for (int i = 0; i < leftside5.length; i++) //Looping through the leftside at 5 block - gives initial size
                {
                    for (int j = 0; j < 6; j++) //Looping through each row fully
                    {
                        leftside5[i][j].display(graf); //Displaying the left side @ 5
                        midside5[i][j].display(graf); //Displaying the mid side @ 5
                        rightside5[i][j].display(graf); //Displaying the right side @ 5
                    }
                }
                break;
            case 7:
                for (int i = 0; i < leftside7.length; i++) //Looping through the leftside at 7 block - gives initial size
                {
                    for (int j = 0; j < 6; j++) //Looping through each row fully
                    {
                        leftside7[i][j].display(graf); //Displaying the left side @ 7
                        midside7[i][j].display(graf); //Displaying the mid side @ 7
                        rightside7[i][j].display(graf); //Displaying the right side @ 7
                    }
                }
                break;
            case 9:
                for (int i = 0; i < leftside9.length; i++) //Looping through the leftside at 7 block - gives initial size
                {
                    for (int j = 0; j < 6; j++) //Looping through each row fully
                    {
                        leftside9[i][j].display(graf); //Displaying the left side @ 7
                        midside9[i][j].display(graf); //Displaying the mid side @ 7
                        rightside9[i][j].display(graf); //Displaying the right side @ 7
                    }
                }
                break;

            default:
                /* Used as what appears when the program starts */
                for (int i = 0; i < leftside1.length; i++) //Looping through the leftside at 1 block - gives initial size
                {
                    for (int j = 0; j < 6; j++) //Looping through each row fully
                    {
                        leftside1[i][j].display(graf); //Displaying the left side @ 1
                        midside1[i][j].display(graf); //Displaying the mid side @ 1
                        rightside1[i][j].display(graf); //Displaying the right side @ 1
                    }
                }
                break;
        }
    }

    public void actionPerformed(ActionEvent ev) {
        selectedblock = block.getSelectedItem(); //The values neeeded to book seats and check for availability taken from text boxes
        selectedtime = time.getSelectedItem();
        tickettype = type.getSelectedItem();
        selectedmovietype = movie.getSelectedItem();

        if (ev.getSource() == submitbut) {
            selectedseat = seat.getText();
            int selectseat = Integer.parseInt(selectedseat); //Getting the seat number and converting it to an integer

            /* The following set of if statements checks for seat number and converts it
			to an X, Y position which can be used for booking */
            if (selectseat == 0) {
                convertedseat1 = 0;
                convertedseat2 = 0;
            }
            if (selectseat == 1) {
                convertedseat1 = 0;
                convertedseat2 = 1;
            }
            if (selectseat == 2) {
                convertedseat1 = 0;
                convertedseat2 = 2;
            }
            if (selectseat == 3) {
                convertedseat1 = 0;
                convertedseat2 = 3;
            }
            if (selectseat == 4) {
                convertedseat1 = 0;
                convertedseat2 = 4;
            }
            if (selectseat == 5) {
                convertedseat1 = 0;
                convertedseat2 = 5;
            }
            if (selectseat == 6) {
                convertedseat1 = 1;
                convertedseat2 = 0;
            }
            if (selectseat == 7) {
                convertedseat1 = 1;
                convertedseat2 = 1;
            }
            if (selectseat == 8) {
                convertedseat1 = 1;
                convertedseat2 = 2;
            }
            if (selectseat == 9) {
                convertedseat1 = 1;
                convertedseat2 = 3;
            }
            if (selectseat == 10) {
                convertedseat1 = 1;
                convertedseat2 = 4;
            }
            if (selectseat == 11) {
                convertedseat1 = 1;
                convertedseat2 = 5;
            }
            if (selectseat == 12) {
                convertedseat1 = 2;
                convertedseat2 = 0;
            }
            if (selectseat == 13) {
                convertedseat1 = 2;
                convertedseat2 = 1;
            }
            if (selectseat == 14) {
                convertedseat1 = 2;
                convertedseat2 = 2;
            }
            if (selectseat == 15) {
                convertedseat1 = 2;
                convertedseat2 = 3;
            }
            if (selectseat == 16) {
                convertedseat1 = 2;
                convertedseat2 = 4;
            }
            if (selectseat == 17) {
                convertedseat1 = 2;
                convertedseat2 = 5;
            }
            if (selectseat == 18) {
                convertedseat1 = 3;
                convertedseat2 = 0;
            }
            if (selectseat == 19) {
                convertedseat1 = 3;
                convertedseat2 = 1;
            }
            if (selectseat == 20) {
                convertedseat1 = 3;
                convertedseat2 = 2;
            }
            if (selectseat == 21) {
                convertedseat1 = 3;
                convertedseat2 = 3;
            }
            if (selectseat == 22) {
                convertedseat1 = 3;
                convertedseat2 = 4;
            }
            if (selectseat == 23) {
                convertedseat1 = 3;
                convertedseat2 = 5;
            }
            if (selectseat == 24) {
                convertedseat1 = 4;
                convertedseat2 = 0;
            }
            if (selectseat == 25) {
                convertedseat1 = 4;
                convertedseat2 = 1;
            }
            if (selectseat == 26) {
                convertedseat1 = 4;
                convertedseat2 = 2;
            }
            if (selectseat == 27) {
                convertedseat1 = 4;
                convertedseat2 = 3;
            }
            if (selectseat == 28) {
                convertedseat1 = 4;
                convertedseat2 = 4;
            }
            if (selectseat == 29) {
                convertedseat1 = 4;
                convertedseat2 = 5;
            }
            if (selectseat == 30) {
                convertedseat1 = 5;
                convertedseat2 = 0;
            }
            if (selectseat == 31) {
                convertedseat1 = 5;
                convertedseat2 = 1;
            }
            if (selectseat == 32) {
                convertedseat1 = 5;
                convertedseat2 = 2;
            }
            if (selectseat == 33) {
                convertedseat1 = 5;
                convertedseat2 = 3;
            }
            if (selectseat == 34) {
                convertedseat1 = 5;
                convertedseat2 = 4;
            }
            if (selectseat == 35) {
                convertedseat1 = 5;
                convertedseat2 = 5;
            }

            if (selectedtime == "13:00") //If they are trying to book a ticket a 1 o'clock
            {
                timechoice = 1;
                repaint();
                if (selectedblock == "Left Block") // If they are trying to book a seat in the left block
                {
                    int iftaken = leftside1[convertedseat1][convertedseat2].isTaken(); //Uses the istaken() method to see if it is taken
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked"); //Seat is taken and outputs an error message
                    } else if (iftaken == 0) {
                        leftside1[convertedseat1][convertedseat2].setSeat(); //Sets the seat to booked
                        repaint(); //Re-displays it
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype); //Creates a new ticket objects in the tickets array
                        int tempprice = tickets[totaltickets].getSeatPrice(); //Gets the seat price using the getSeatPrice() method
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice)); //Updates and adds to the text box
                        totaltickets += 1; //Updates the total amount of tickets booked
                        seat.setText("");
                    }
                }
                if (selectedblock == "Middle Block") // If they are trying to book a seat in the middle block
                {
                    int iftaken = midside1[convertedseat1][convertedseat2].isTaken(); //Uses the istaken() method to see if it is taken
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked"); //Seat is taken and outputs an error message
                    } else if (iftaken == 0) {
                        midside1[convertedseat1][convertedseat2].setSeat(); //Sets the seat to booked
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype); //Creates a new ticket objects in the tickets array
                        int tempprice = tickets[totaltickets].getSeatPrice();  //Gets the seat price using the getSeatPrice() method
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice)); //Updates and adds to the text box
                        totaltickets += 1; //Updates the total amount of tickets booked
                        seat.setText("");
                    }
                }
                if (selectedblock == "Right Block") // If they are trying to book a seat in the right block
                {
                    int iftaken = rightside1[convertedseat1][convertedseat2].isTaken(); //Uses the istaken() method to see if it is taken
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");  //Seat is taken and outputs an error message
                    } else if (iftaken == 0) {
                        rightside1[convertedseat1][convertedseat2].setSeat(); //Sets the seat to booked
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);  //Creates a new ticket objects in the tickets array
                        int tempprice = tickets[totaltickets].getSeatPrice(); //Gets the seat price using the getSeatPrice() method
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice)); //Updates and adds to the text box
                        totaltickets += 1; //Updates the total amount of tickets booked
                        seat.setText("");
                    }
                }
            }

            /* Code is replicated for each of the times the user wants to book*/
            if (selectedtime == "15:00") {
                timechoice = 3;
                repaint();

                if (selectedblock == "Left Block") {
                    int iftaken = leftside3[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        leftside3[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedblock == "Middle Block") {
                    int iftaken = midside3[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        midside3[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedblock == "Right Block") {
                    int iftaken = rightside3[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        rightside3[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }

            }
            if (selectedtime == "17:00") {
                timechoice = 5;
                repaint();

                if (selectedblock == "Left Block") {
                    int iftaken = leftside5[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        leftside5[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedblock == "Middle Block") {
                    int iftaken = midside5[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        midside5[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedblock == "Right Block") {
                    int iftaken = rightside5[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        rightside5[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
            }
            if (selectedtime == "19:00") {
                timechoice = 7;
                repaint();

                if (selectedblock == "Left Block") {
                    int iftaken = leftside7[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        leftside7[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedblock == "Middle Block") {
                    int iftaken = midside7[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        midside7[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedblock == "Right Block") {
                    int iftaken = rightside7[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        rightside7[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
            }
            if (selectedtime == "21:00") {
                timechoice = 9;
                repaint();

                if (selectedblock == "Left Block") {
                    int iftaken = leftside9[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        leftside9[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedblock == "Middle Block") {
                    int iftaken = midside9[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        midside9[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedblock == "Right Block") {
                    int iftaken = rightside9[convertedseat1][convertedseat2].isTaken();
                    if (iftaken == 1) {
                        JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
                    } else if (iftaken == 0) {
                        rightside9[convertedseat1][convertedseat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime, selectedmovietype);
                        int tempprice = tickets[totaltickets].getSeatPrice();
                        totalprice = totalprice + tempprice;
                        totalcost.setText("RM" + Integer.toString(totalprice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
            }
        }

        if (ev.getSource() == showbut) {
            /* If the user has clicked the show button it sets a variable and then repaints the desired time */

            if ("13:00".equals(selectedtime)) {
                timechoice = 1;
                repaint();
            } else if ("15:00".equals(selectedtime)) {
                timechoice = 3;
                repaint();
            } else if ("17:00".equals(selectedtime)) {
                timechoice = 5;
                repaint();
            } else if (!"19:00".equals(selectedtime)) {
                timechoice = 9;
                repaint();
            } else {
                timechoice = 7;
                repaint();
            }

        }
        
        if (ev.getSource() == paybut) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3307/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", 
            "root", 
            "1234"
        );

        String sql = "INSERT INTO booking (movie_name, seat_num, seat_price, ticket_type, ticket_time, ticket_block) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < totaltickets; i++) {
            String movie1 = tickets[i].getMovieName();
            int ticketnum = tickets[i].getSeatNum();
            int ticketprice = tickets[i].getSeatPrice();
            String Tickettype = tickets[i].getType();
            String tickettime = tickets[i].getTime();
            String ticketblock = tickets[i].getBlock();

            statement.setString(1, movie1);
            statement.setInt(2, ticketnum);
            statement.setInt(3, ticketprice);
            statement.setString(4, Tickettype);
            statement.setString(5, tickettime);
            statement.setString(6, ticketblock);
            statement.executeUpdate();
        }

        statement.close();

        JOptionPane.showMessageDialog(null, "Booking details inserted into database successfully.");
        dispose();  // Close the current frame

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error inserting booking details into database: " + e.getMessage());
    }
}
        if (ev.getSource() == paybut) //Pay button to generate tickets
        {

            try {
                FileWriter stream = new FileWriter("tickets.txt"); //Opening the tickets.txt file
                BufferedWriter output = new BufferedWriter(stream);

                for (int i = 0; i < totaltickets; i++) //Looping through the number of tickets booked
                {
                    /* Getting the variables needed from methods related to the object */

                    String movie1 = tickets[i].getMovieName();
                    int ticketnum = tickets[i].getSeatNum();
                    int ticketprice = tickets[i].getSeatPrice();
                    String Tickettype = tickets[i].getType();
                    String tickettime = tickets[i].getTime();
                    String ticketblock = tickets[i].getBlock();
                    String newline = System.getProperty("line.separator"); // new line

                    output.write(newline);
                    output.write("------------------------------------------------------------------------------------");
                    output.write(newline);
                    output.write("                                         Ticket Details                   ");
                    output.write(newline);
                    output.write(newline);
                    output.write("Ticket Number: " + ticketnum); //Writing ticketnum
                    output.write(newline);
                    output.write("Ticket Price: " + ticketprice);
                    output.write(newline);
                    output.write("Ticket Type: " + Tickettype);
                    output.write(newline);
                    output.write("Ticket Time: " + tickettime);
                    output.write(newline);
                    output.write("Ticket Block: " + ticketblock);
                    output.write(newline);
                    output.write("Movie: " + movie1);
                    output.write(newline);
                    output.write("Thank you For Choosing WOGT Cinema Ticketing System! ");
                    output.write(newline);
                    output.write("____________________________________________________________________________________");
                    output.write(newline);
                }
                output.close();
            } catch (Exception e) {//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }

            JOptionPane.showMessageDialog(null, "These tickets have been printed out to the file 'tickets.txt'"); //Success message

            paybut.addActionListener(new Payment(totalprice));
            dispose(); // Close the First.java window

            for (int i = 0; i < tickets.length; i++) {
                tickets[i] = null; //Setting the tickets array values to null so new tickets can be booked
            }
            totaltickets = 0; //Resets totaltickets to 0
            totalprice = 0; //Resets totalprice to 0
            totalcost.setText(""); //Sets totalcost to an empty text field
            seat.setText(""); //Wipes seat number text field
        }
        
       

    }
    

}
