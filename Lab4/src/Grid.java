/**
 * Mike Cao
 * 10/10/18
 * Grid.java Lab 4
 */

public class Grid {
    /**
     * Creates the grid and sets the values to each spot in the grid.
     */
    private int[][] grid;

    public Grid(int dim) {
        this.grid = new int[dim][dim]; //creates a grid with rows of size dim and columns of size dim.
    }

    public void setVal(int row, int col, int val) {
        grid[row][col] = val; //sets the value at that specific row and column to val.
    }

    public int getVal(int row, int col) {
        return grid[row][col]; //return the value at row and col.
    }
}
