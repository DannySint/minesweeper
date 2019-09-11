package minesweeper;

public class TextDisplay
{
    private Minefield minefield;
    
    public TextDisplay(Minefield minefield) 
    {
        this.minefield = minefield;
    }
    
    public void textDisplay()
    {
        System.out.println();
        for (int i = 0; i < minefield.getLength(); i++)
        {
            for (int j = 0; j < minefield.getHeight(); j++)
            {
                if (minefield.getMinebox()[i][j].isVisible())
                {
                    //visible route
                    if (minefield.getMinebox()[i][j].isBomb()) //is bomb
                    {
                        System.out.print("X");
                    }
                    else if (minefield.getNumber(i, j) == 0) //no bombs adjacent
                    {
                        System.out.print("0");
                    }
                    else //has a number
                    {
                        System.out.print(Integer.toString(minefield.getNumber(i, j)));
                    }
                }
                else //invisible route
                {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

}
