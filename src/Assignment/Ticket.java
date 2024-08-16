/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

/**
 *
 * @author ganws
 */
public class Ticket {

    private int price;
    private String tickettype;
    private int seatnum;
    private String timeticket;
    private String blockticket;
    private String MovieName;

    public Ticket(String type, int seatnumber, String block, String time, String movie) {

        seatnum = seatnumber; //Setting tickets seat number
        tickettype = type; //Setting ticket type
        blockticket = block; //Setting block
        timeticket = time; //Setting time

        MovieName = movie;
        if (blockticket == "Left Block") {

            if (type == "Adult") {
                price = 5; //Setting adult price
            }
            if (type == "OAP") {
                price = 3; //Setting OAP price
            }
            if (type == "Child") {
                price = 2;  //Setting child price
            }
        }

        if (blockticket == "Middle Block") {

            if (type == "Adult") {
                price = 10; //Setting adult price
            }
            if (type == "OAP") {
                price = 3; //Setting OAP price
            }
            if (type == "Child") {
                price = 5;  //Setting child price
            }
        }

        if (blockticket == "Right Block") {

            if (type == "Adult") {
                price = 5; //Setting adult price
            }
            if (type == "OAP") {
                price = 3; //Setting OAP price
            }
            if (type == "Child") {
                price = 2;  //Setting child price
            }
        }

    }

    public Ticket() {

    }

    /* The following get methods are used to print tickets */
    public int getSeatPrice() {
        return price;
    }

    public String getMovieName() {
        return MovieName;
    }

    public String getTime() {
        return timeticket;
    }

    public String getBlock() {
        return blockticket;
    }

    public String getType() {
        return tickettype;
    }

    public int getSeatNum() {
        return seatnum;
    }
}
