package minesweeper;


import java.awt.Color;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI extends JFrame
{

    private int rows;
    private int cols;
    private Minefield minefield;
    private Container pane;
    private GridLayout gridLayout;
    
    public GUI(int rows, int cols, Minefield minefield)
    {
        this.rows = rows;
        this.cols = cols;
        this.minefield = minefield;
        this.pane = getContentPane();
        this.gridLayout = new GridLayout(rows, cols);
        this.pane.setLayout(this.gridLayout);
    /*}
    
    public void updateGUI()
    {*/
        for (int i = 0; i < minefield.getLength(); i++)
        {
            for (int j = 0; j < minefield.getHeight(); j++)
            {
                int tempI = i; int tempJ = j;
                JButton button = new JButton(" ");
                button.setBackground(Color.WHITE);
                if (minefield.getMinebox()[i][j].isVisible())
                {
                    //visible route
                    if (minefield.getMinebox()[i][j].isBomb()) //is bomb
                    {
                        button = new JButton("X");
                        button.setBackground(Color.RED);
                        this.pane.add(button);
                    }
                    else if (minefield.getNumber(i, j) == 0) //no bombs adjacent
                    {
                        button = new JButton(" ");
                    }
                    else //has a number
                    {
                        button = new JButton(Integer.toString(minefield.getNumber(i, j)));
                    }
                }
                else //invisible route
                {
                    this.pane.add(button);
                    button.addActionListener(new ActionListener() 
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            minefield.getMinebox()[tempI][tempJ].setVisible(true);
                            
                            if (minefield.getMinebox()[tempI][tempJ].isBomb())
                            {
                                minefield.displayAllBombs();
                                System.out.println("You hit a bomb! Game over");
                            }
                            System.out.println(minefield.getNumber(tempI, tempJ));
                        }
                    });
                }
            }
        }
    }
    
    public class ActionListenerEx implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            //System.out.println(arg0.paramString());
            //System.out.println(arg0.);
            //System.out.println(arg0.getActionCommand());
            /*
            switch (arg0.getActionCommand())
            {
                case "X" : 
            }*/
            //System.out.println(arg0.getActionCommand());
            //System.out.println(arg0.);
        }
            
    }
}
