public class BonusFood {
    private int row, col;
    private int numRows, numCols;
    private double cellWidth, cellHeight;

    private int interval;

    public BonusFood(int numRows, int numCols, double cellWidth, double cellHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        row = (int)(Math.random() * numRows);
        col = (int)(Math.random() * numCols);
        interval = (int)(Math.random() * 5 * 10);
    }

    /**
     * decrement interval when interval is greater than 0
     */
    public void reduceInterval() {
        if(interval > 0) {
            interval -= 1;
        }
    }

    public int getInterval() {
        return interval;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void update() {
        row = (int)(Math.random() * numRows);
        col = (int)(Math.random() * numCols);
        interval = (int)(Math.random() * 5 * 10);
    }

    public void draw() {
        PennDraw.setPenColor(PennDraw.MAGENTA);
        PennDraw.filledCircle(col * cellWidth + cellWidth/2, row * cellHeight + cellHeight/2, cellHeight/2);
    }
}