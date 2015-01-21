package Client;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.GroupLayout;
import javax.swing.JTextField;

/**
 *
 * @author Dastyruck
 */
public class Client
{
    private JFrame thisFrame;
    private Thread timer;
    private JPanel menuPanel;
    private JPanel gamePanel;
    private JPanel loginPanel;
    private JPanel accountPanel;
    private JPanel newAccPanel;
    private JPanel delAccPanel;
    private JPanel ipPanel;
    private JPanel creditPanel;
    private JPanel settingsPanel;
    private ArrayList<Button> button;
    static final int SLEEP = 10;

    private int[] keys = new int[]
    {
        KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT
    };

    private boolean[] keyPressed;

    private Rectangle bounds;
    
    private KeyListener keyboard;

    private MouseListener mouse;

    private ArrayList<JPanel> panels;

    private int state;

    private int prevState;

    public Client()
    {

        state = 0;
        panels = new ArrayList();
        thisFrame = new JFrame("Client");
        thisFrame.setSize(600, 450);
        button = new ArrayList<Button>();

        menuPanel = new JPanel()
        {
            public void paint(Graphics g)
            {
                if(state == 0)
                {
                    for(Button b : button)
                    {
                        if(b.getType() == state)
                        {
                            b.setVisible(true);
                            b.draw(g);
                        }
                        else
                        {
                            b.setVisible(false);
                        }
                    }
                    g.setColor(Color.black);
                    g.fillRect(148,91,426,221);
                }
            }
        };
        menuPanel.setSize(600, 450);

        button.add(new Button(16,91,120,32,"Login",0)
        {
            public void actionPerformed()
            {
                state = 2;
                thisFrame.setSize(400,400);
            }
        });
        button.add(new Button(16,136,120,32,"New Account",0)
        {
            public void actionPerformed()
            {
                System.out.println("Call New Account Screen");
            }
        });
        button.add(new Button(16,184,120,32,"Delete Account",0)
        {
            public void actionPerformed()
            {
                System.out.println("Call Delete Account Screen");
            }
        });
        button.add(new Button(16,232,120,32,"Credits",0)
        {
            public void actionPerformed()
            {
                System.out.println("Call Credits Screen");
            }
        });
        button.add(new Button(16,280,120,32,"IP Config",0)
        {
            public void actionPerformed()
            {
                System.out.println("Call IP Config Screen");
            }
        });
        button.add(new Button(16,328,120,56,"Quit",0)
        {
            public void actionPerformed()
            {
                System.exit(0);
            }
        });
        
        gamePanel = new JPanel()
        {
            public void paint(Graphics g)
            {
                if(state == 1)
                {
                    for(Button b : button)
                    {
                        if(b.getType() == state)
                        {
                            b.setVisible(true);
                            b.draw(g);
                        }
                        else
                        {
                            b.setVisible(false);
                        }
                    }
                    g.setColor(Color.black);
                    g.fillRect(148,91,426,221);
                }
            }
        };
        gamePanel.setSize(600, 450);
        
        loginPanel = new JPanel()
        {
            public void paint(Graphics g)
            {
                if(state == 2)
                {
                    for(Button b : button)
                    {
                        if(b.getType() == state)
                        {
                            b.setVisible(true);
                            b.draw(g);
                        }
                        else
                        {
                            b.setVisible(false);
                        }
                    }
                    g.setColor(Color.orange);
                    g.fillRect(16, 88, 164, 16);
                    g.setColor(Color.black);
                    g.drawRect(16, 88, 164, 16);
                    g.drawString("Account:", 74, 100);
                    g.setColor(Color.orange);
                    g.fillRect(16, 152, 164, 16);
                    g.setColor(Color.black);
                    g.drawRect(16, 152, 164, 16);
                    g.drawString("Password:", 74, 164);
                }
            }
        };
        loginPanel.setSize(400, 400);
        

        button.add(new Button(16,306,164,16,"Login",2)
        {
            public void actionPerformed()
            {
                state = 3;
            }
        });
        button.add(new Button(16,338,344,16,"Return to main menu",2)
        {
            public void actionPerformed()
            {
                state = 0;
                thisFrame.setSize(600,450);
            }
        });
        button.add(new Button(32,216,164,16,"Save Password",2)
        {
            public void actionPerformed()
            {
                System.out.println("Savethepasshere");
            }
        });
        
        accountPanel = new JPanel()
        {
            public void paint(Graphics g)
            {
                if(state == 3)
                {
                    for(Button b : button)
                    {
                        if(b.getType() == state)
                        {
                            b.setVisible(true);
                            b.draw(g);
                        }
                        else
                        {
                            b.setVisible(false);
                        }
                    }
                    g.setColor(Color.black);
                    g.fillRect(148,91,426,221);
                }
            }
        };
        accountPanel.setSize(600, 450);
        
        newAccPanel = new JPanel()
        {
            public void paint(Graphics g)
            {
                if(state == 4)
                {
                    for(Button b : button)
                    {
                        if(b.getType() == state)
                        {
                            b.setVisible(true);
                            b.draw(g);
                        }
                        else
                        {
                            b.setVisible(false);
                        }
                    }
                    g.setColor(Color.black);
                    g.fillRect(148,91,426,221);
                }
            }
        };
        newAccPanel.setSize(600, 450);
        
        delAccPanel = new JPanel()
        {
            public void paint(Graphics g)
            {
                if(state == 5)
                {
                    for(Button b : button)
                    {
                        if(b.getType() == state)
                        {
                            b.setVisible(true);
                            b.draw(g);
                        }
                        else
                        {
                            b.setVisible(false);
                        }
                    }
                    g.setColor(Color.black);
                    g.fillRect(148,91,426,221);
                }
            }
        };
        delAccPanel.setSize(600, 450);
        
        ipPanel = new JPanel()
        {
            public void paint(Graphics g)
            {
                if(state == 6)
                {
                    for(Button b : button)
                    {
                        if(b.getType() == state)
                        {
                            b.setVisible(true);
                            b.draw(g);
                        }
                        else
                        {
                            b.setVisible(false);
                        }
                    }
                    g.setColor(Color.black);
                    g.fillRect(148,91,426,221);
                }
            }
        };
        ipPanel.setSize(600, 450);
        
        creditPanel = new JPanel()
        {
            public void paint(Graphics g)
            {
                if(state == 7)
                {
                    for(Button b : button)
                    {
                        if(b.getType() == state)
                        {
                            b.setVisible(true);
                            b.draw(g);
                        }
                        else
                        {
                            b.setVisible(false);
                        }
                    }
                    g.setColor(Color.black);
                    g.fillRect(148,91,426,221);
                }
            }
        };
        creditPanel.setSize(600, 450);

        thisFrame.add(menuPanel);
        thisFrame.add(gamePanel);
        thisFrame.add(loginPanel);
        thisFrame.add(accountPanel);
        thisFrame.add(newAccPanel);
        thisFrame.add(delAccPanel);
        thisFrame.add(ipPanel);
        thisFrame.add(creditPanel);

        panels.add(menuPanel);
        panels.add(gamePanel);
        panels.add(loginPanel);
        panels.add(accountPanel);
        panels.add(newAccPanel);
        panels.add(delAccPanel);
        panels.add(ipPanel);
        panels.add(creditPanel);


        keyboard = new KeyListener()
        {
            public void keyTyped(KeyEvent e) {

            }
            public void keyPressed(KeyEvent e)
            {
                //Signifies that a particular key is turned on.
                if(e.getKeyCode()<128)keyPressed[e.getKeyCode()]=true;
            }
            public void keyReleased(KeyEvent e)
            {
                if(e.getKeyCode()<128){
                    //Signifies that a particular key has been turned off.
                    keyPressed[e.getKeyCode()]=false;

                }
            }
        };

        mouse = new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                //Unqueues all keys upon a click.
                //Forces the JFrame to the top if it is focused.
                if(thisFrame.getState()!=JFrame.ICONIFIED)thisFrame.setAlwaysOnTop(thisFrame.isAlwaysOnTop());
                    //Performs the proper action for any visible button clicked on.
                    for(Button b : button)
                    {
                        if(b.contains(e.getX(), e.getY()) && b.getType() == state)
                        {
                            b.actionPerformed();
                            break;
                        }
                    }

            }
        };



        menuPanel.addMouseListener(mouse);
        gamePanel.addMouseListener(mouse);
        loginPanel.addMouseListener(mouse);
        accountPanel.addMouseListener(mouse);
        newAccPanel.addMouseListener(mouse);
        delAccPanel.addMouseListener(mouse);
        ipPanel.addMouseListener(mouse);
        creditPanel.addMouseListener(mouse);

        gamePanel.addKeyListener(keyboard);

        timer = new Thread(){

            @Override
            public void run(){
                while(true){
                    //Actions for the Menu Panel.
                    if(menuPanel!=null){
                        //Updates the panel.
                        menuPanel.repaint();
                    }//End menu panel actions.

                    //Actions for the game panel.
                    if(gamePanel!=null&&thisFrame.getState()==JFrame.NORMAL){
                        //Updates the panel.
                        gamePanel.repaint();

                    }//End game actions.

                    //Settings menu actions
                    if(settingsPanel!=null){
                        //Updates the settings menu.
                        thisFrame.repaint();
                    }//End settings menu actions.

                    for(int i = 0;i < panels.size();i++)
                    {
                        if(state != prevState)
                        {
                            if(i == state)
                            {
                                panels.get(i).setVisible(true);
                                thisFrame.setVisible(false);
                                thisFrame.setVisible(true);
                                
                            }
                            else
                            {
                                panels.get(i).setVisible(false);
                            }
                        }
                    }
                    prevState = state;

                    


                    //Delays the actions by SLEEP miliseconds.
                    try
                    {
                        sleep(SLEEP);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }//End sleep try

                }
            }

        };

        timer.start();
        thisFrame.setDefaultCloseOperation(thisFrame.EXIT_ON_CLOSE);
        thisFrame.setVisible(true);
    }

    public static void main(String args[])
    {
        new Client();
    }
}
