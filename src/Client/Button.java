/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author Dastyruck
 */
public class Button
{
    private double yPos;
    private double xPos;
    private double width;
    private double height;
    private double type;
    private Rectangle area;
    private String name;
    private boolean visible = true;

    public static Button getByName(String n, ArrayList<Button> button)
    {
        for(Button b : button)
        {
            if(b.getName().equals(n))return b;
        }
        return null;
    }

    public Button()
    {
        xPos = 0;
        yPos = 0;
        width = 0;
        height = 0;
        name = "";
        area = new Rectangle((int)(xPos-width/2), (int)(yPos-height/2), (int)(width), (int)(height));
    }

    public Button(double x, double y, double w, double h, String n, double t)
    {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        name = n;
        area = new Rectangle((int)(xPos), (int)(yPos), (int)(width), (int)(height));
        type = t;
    }

    public void draw(Graphics g)
    {
        Font font = new Font("Cooper Black",Font.PLAIN,12);
        area = new Rectangle((int)(xPos), (int)(yPos), (int)(width), (int)(height));
        //Draws the background.
        g.setColor(Color.ORANGE);
        g.fillRect((int)(xPos), (int)(yPos), (int)(width), (int)(height));
        //Draws the border.
        g.setColor(Color.BLACK);
        g.drawRect((int)(xPos), (int)(yPos), (int)(width), (int)(height));
        //Draws the text.
        g.setFont(font);
        g.drawString(name, (int)(xPos-name.length()*3.5+width/2), (int)(yPos+height/1.6));
        //Draws the image if it has one.
    }

    public double getX()
    {
        return xPos;
    }

    public double getY()
    {
        return yPos;
    }

    public void setX(double x)
    {
        xPos = x;
    }

    public void setY(double y)
    {
        yPos = y;
    }

    public double getType()
    {
        return type;
    }

    public void setType(double t)
    {
        type = t;
    }

    public void setWidth(double w)
    {
        width = w;
    }

    public void setHeight(double h)
    {
        height = h;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setVisible(boolean v)
    {
        visible = v;
    }

    public boolean contains(double x, double y)
    {
        return area.contains(x,y);
    }
    
    public void actionPerformed()
    {
        System.out.println("This button doesn't do anything!");
    }




}
