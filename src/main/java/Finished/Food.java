//package Finished;
//
//public class Food {
//    private double numRows, numCols;
//    private double cellWidth, cellHeight;
//    private int row, col;
//
//    public int getRow() {
//        return row;
//    }
//
//    public int getCol() {
//        return col;
//    }
//
//    public Food(double numRows, double numCols, double cellWidth, double cellHeight) {
//        this.numRows = numRows;
//        this.numCols = numCols;
//        this.cellWidth = cellWidth;
//        this.cellHeight = cellHeight;
//        update();
//    }
//
//    public void update() {
//        row = (int) (Math.random() * numRows);
//        col = (int) (Math.random() * numCols);
//
//    }
//
//    public void draw() {
//        PennDraw.setPenColor(PennDraw.RED);
//        PennDraw.filledSquare(row * cellHeight + cellHeight/2, col * cellWidth + cellWidth/2, cellHeight/2);
//    }
//}
