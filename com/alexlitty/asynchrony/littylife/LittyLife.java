package com.alexlitty.asynchrony.littylife;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

public class LittyLife extends BasicGame
{
    // Size of the game window
    protected static int windowWidth = 600;
    protected static int windowHeight = 600;
    
    // Number of rows and columns on the cell grid
    protected int gridColumns;
    protected int gridRows;

    // Collection of boolean values representing cells. Dead if false.
    public boolean[] cells;
    
    // Information to visually represent cells
    protected int cellWidth;
    protected int cellHeight;
    protected Image cellImageAlive;
    protected Image cellImageDead;
    
    /**
     * Game constructor. Initializes the class, not the game.
     *
     * Calls the parent class constructor.
     */
    public LittyLife(String gamename) {
        super(gamename);
    }

    /**
     * Initializes critical game components.
     *
     * Prepares a grid of cells and their visual representations.
     */
    @Override
    public void init(GameContainer gc) throws SlickException {
        gridColumns = gridRows = 60;
        cellWidth = windowWidth / gridColumns;
        cellHeight = windowHeight / gridRows;

        // Create a grid of cells    
        cells = new boolean[gridColumns * gridRows];
        for (boolean c : cells) {
            c = false;
        }
        cells[22] = true;
        
        // Prepare images of cells
        cellImageAlive = new Image(cellWidth, cellHeight);
        cellImageAlive.setImageColor(255, 255, 255);
        cellImageDead = new Image(cellWidth, cellHeight);
        cellImageDead.setImageColor(0, 0, 0);
    }
    
    /**
     * Returns true if a particular cell is alive, false otherwise.
     *
     * Parameters are x and y coordinates where the cell should lie visually,
     * starting at (0, 0).
     */
    public boolean isAlive(int x, int y) {
        return cells[x + (y * gridColumns)];
    }

    /**
     * Perform an update on the current game logic.
     */
    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        
    }

    /**
     * Graphically render the current state of the game.
     */
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        for (int i = 0; i < gridColumns; i++) {
            for (int j = 0; j < gridColumns; j++) {
                g.drawImage(
                    isAlive(i, j) ? cellImageAlive : cellImageDead,
                    i * cellWidth,
                    j * cellHeight
                );
            }
        }
    }

    /**
     * Litty's Game of Life entry function.
     */    
    public static void main(String[] args)
    {
       try {
            AppGameContainer app;
            app = new AppGameContainer(new LittyLife("Litty's Game of Life"));
            app.setDisplayMode(windowWidth, windowHeight, false);
            app.start();
        }
        catch (SlickException e) {
            System.out.println("Slick2D Exception: " + e.getMessage());
        }
    }
}
