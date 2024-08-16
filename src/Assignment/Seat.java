/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

import java.awt.Graphics;

/**
 *
 * @author ganws
 */
public class Seat {

    private final int boxheight = 30; //Height of the drawn text box
    private final int boxwidth = 50; //Width of the drawn text box
    private int seatnumber;
    private int seattaken;
    private int x;
    private int y;

    public Seat(int number, int taken, int xstart, int ystart) {
        seatnumber = number; //Setting the seatnumber
        seattaken = taken; //Setting whether it is taken
        x = xstart; //Display position
        y = ystart;
    }

    public void display(Graphics graf) {
        int xdraw, ydraw;
        switch (seattaken) {
            case 0:
                xdraw = x + boxwidth;
                ydraw = y + boxheight;
                graf.drawRect(x, y, boxwidth, boxheight);
                graf.drawString(Integer.toString(seatnumber), x + 20, y + boxheight * 3 / 6); //Painting the seat with the seat number printed inside
                break;
            case 1:
                xdraw = x + boxwidth;
                ydraw = y + boxheight;
                graf.drawRect(x, y, boxwidth, boxheight);
                String msg = "N/A";
                graf.drawString(msg, x + 20, y + boxheight * 3 / 6); //Painting the seat with N/A printed inside
                break;
            default:
                break;
        }

    }

    public int isTaken() {
        return seattaken;
    }

    public void setSeat() {
        seattaken = 1;
    }

}
