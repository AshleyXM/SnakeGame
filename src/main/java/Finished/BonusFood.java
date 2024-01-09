//package Finished;
//
//public class BonusFood {
//    private double numRows, numCols;
//    private double cellWidth, cellHeight;
//    private int row, col;
//    private int interval;
//
//    public int getRow() {
//        return row;
//    }
//
//    public int getCol() {
//        return col;
//    }
//
//    public BonusFood(double numRows, double numCols, double cellWidth, double cellHeight) {
//        this.numRows = numRows;
//        this.numCols = numCols;
//        this.cellWidth = cellWidth;
//        this.cellHeight = cellHeight;
//        update();
//    }
//
//    public void reduceInterval() {
//        if(interval > 0) {
//            interval -= 1;
//        }
//        System.out.println(interval);
//    }
//
//    public void update() {
//        interval = (int) (Math.random() * 5 * 20);
//        row = (int) (Math.random() * numRows);
//        col = (int) (Math.random() * numCols);
//    }
//
//    public void draw() {
//        if(interval == 0) {
//            PennDraw.setPenColor(PennDraw.BLUE);
//            PennDraw.filledSquare(row * cellHeight + cellHeight/2, col * cellWidth + cellWidth/2, cellHeight/2);
//        }
//    }
//}
