package minesweeper;

import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Minefield
{
    public final int bombNumber = 9;
    public final double mineChance = 0.9;
    public int length;
    public int height;
    public Minebox[][] minebox;
    
    public int[][] minefield; //can be an object with its number/bomb, visibility

    public Minefield(int length, int height)
    {
        this.length = length;
        this.height = height;
        this.minebox = new Minebox[this.length][this.height];
        
        this.minefield = new int[this.length][this.height]; //legacy
    }
    
    public void bombDisperal()
    {
        for (int i = 0; i < this.getLength(); i++)
        {
            for (int j = 0; j < this.getHeight(); j++)
            {
                //bombs are designated 9
                if (Math.random() > mineChance) 
                {
                    System.out.println("(" + i + ", " + j + ")");
                    this.minebox[i][j] = new Minebox(true, true, new JButton());
                }
                else
                    {this.minebox[i][j] = new Minebox(false, false, new JButton());}
            }
        }
    }
    
    public void numberDisperal()
    {
        for (int x = 0; x < this.getLength() - 1; x++)
        {
            for (int y = 0; y < this.getHeight() - 1; y++)
            {
                //System.out.println("i: " + i + "\nj: " + j);
                if (this.minefield[x][y] == bombNumber) {}
                else 
                {
                    int count = 0;
                    
                    //search all around for bombs, loops all around the circle
                    for (int xOffset = -1; xOffset <= 1; xOffset++)
                    {
                        for (int yOffset = -1; yOffset <= 1; yOffset++)
                        {
                            if (!(x+xOffset < 0 || x+xOffset > getLength() || y+yOffset < 0 || y+yOffset > getHeight()))  //check if out of range
                            {
                                if (minefield[x+xOffset][y+yOffset] == bombNumber)
                                {
                                    count++;
                                }
                            }
                        }
                    }
                    minefield[x][y] = count;
                }
            }
        }
    }

    
    public void displayAllBombs()
    {
    }
    
    public void updateGUI()
    {
    }
    
    public int getLength() {return length;}
    public void setLength(int length) {this.length = length;}
    public int getHeight(){return height;}
    public void setHeight(int height){this.height = height;}
    public int[][] getMinefield(){return minefield;}
    public void setMinefield(int[][] minefield){this.minefield = minefield;}
    //public void setNumber(int x, int y, int number) {minefield[x][y] = number;}
    public int getNumber(int x, int y) 
    {
        if (this.getMinebox()[x][y].isBomb()) {return 9;}
        int count = 0;
        for (int xOffset = -1; xOffset <= 1; xOffset++)
        {
            for (int yOffset = -1; yOffset <= 1; yOffset++)
            {
                if (!(x+xOffset < 0 || x+xOffset > getLength() - 1|| y+yOffset < 0 || y+yOffset > getHeight() - 1))  //check if out of range
                {
                    if (this.minebox[x+xOffset][y+yOffset].isBomb())
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public Minebox[][] getMinebox() {return minebox;}
    public void setMinebox(Minebox[][] minebox) {this.minebox = minebox;}
    
    public static void main(String[] args)
    {
        Minefield minefield = new Minefield(10, 10);
        minefield.bombDisperal();
        minefield.numberDisperal();
        
        
        JFrame frame = new JFrame("Minesweeper");
        int rows = minefield.getHeight();
        int cols = minefield.getLength();
        TextDisplay textDisplay = new TextDisplay(minefield);
        textDisplay.textDisplay();
        GUI gui = new GUI(rows, cols, minefield);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Minesweeper");
        gui.pack();
        gui.setVisible(true);
        /*while (true)
        {   
            //gui.updateGUI();
        }*/
        //minefield.displayField();
    }
}
