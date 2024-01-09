/**
 * Dependencies: PennDraw.java Math.java
 */
public class Food {
    private int row, col;
    private int numRows, numCols;
    private double cellWidth, cellHeight;

    /**
     * Initialize the instance variables of Food
     * with the numRow, numCols and cellWidth, cellHeight passed from Board
     * @param numRows the number of total rows on the board
     * @param numCols
     * @param cellWidth
     * @param cellHeight
     */
    public Food(int numRows, int numCols, double cellWidth, double cellHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        row = (int)(Math.random() * numRows);
        col = (int)(Math.random() * numCols);
    }

    /**
     * Get the row position of the food
     * @return the row position of the food
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the column position of the food
     * @return the column position of the food
     */
    public int getCol() {
        return col;
    }

    /**
     * Update the position of food
     */
    public void update() {
        row = (int)(Math.random() * numRows);
        col = (int)(Math.random() * numCols);
    }

    /**
     * Draw the food
     */
    public void draw() {
        PennDraw.setPenColor(PennDraw.RED);
        PennDraw.filledCircle(col * cellWidth + cellWidth/2, row * cellHeight + cellHeight/2, cellHeight/2);
    }
}
