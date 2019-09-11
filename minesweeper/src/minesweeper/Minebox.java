package minesweeper;

import javax.swing.JButton;

public class Minebox
{

    public boolean bomb = false;
    public boolean visible = false;
    public JButton button = null;
    
    public Minebox(boolean bomb, boolean visible, JButton button)
    {
        this.bomb = bomb;
        this.visible = visible;
        this.button = button;
    }
    
    public boolean isBomb() {return bomb;}
    public void setBomb(boolean bomb) {this.bomb = bomb;}
    public boolean isVisible() {return visible;}
    public void setVisible(boolean visible){this.visible = visible;}

    public JButton getButton() {return button;}
    public void setButton(JButton button) {this.button = button;}
}
