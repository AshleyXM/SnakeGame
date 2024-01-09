//package Finished;
//
//import java.awt.*;
//import java.util.ArrayList;
//
//public class Snake {
//    private double cellWidth, cellHeight;
//    private int headRow;
//    private int headCol;
//    private int xVel, yVel;
//    private ArrayList<SnakeSegment> body;
//
//    public int getxVel() {
//        return xVel;
//    }
//
//    public int getyVel() {
//        return yVel;
//    }
//
//    public int getHeadRow() {
//        return headRow;
//    }
//
//    public int getHeadCol() {
//        return headCol;
//    }
//
//    public Snake(int headRow, int headCol, double cellWidth, double cellHeight) {
//        this.headRow = headRow;
//        this.headCol = headCol;
//        this.cellWidth = cellWidth;
//        this.cellHeight = cellHeight;
//        xVel = 0;
//        yVel = 0;
//        body = new ArrayList<>();
//        body.add(new SnakeSegment(headRow, headCol));
//    }
//
//    public boolean biteSelf() {
//        for(int i = 1; i < body.size(); i++) {
//            if(body.get(i).getRow() == headRow && body.get(i).getCol() == headCol) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void update() {
//        body.set(0, new SnakeSegment(headRow, headCol));
//        for(int i = body.size() - 1; i > 0; i--) {
//            body.set(i, body.get(i - 1));
//        }
//        headRow += xVel;
//        headCol += yVel;
//    }
//
//    public void addSegment() {
//        SnakeSegment tail = body.get(body.size() - 1);
//        body.add(tail);
//    }
//
//    public void setDirection(int xVel, int yVel) {
//        this.xVel = xVel;
//        this.yVel = yVel;
//    }
//
//    public void draw() {
//        // draw snake head
//        PennDraw.setPenColor(Color.white);
//        PennDraw.filledSquare(headRow * cellWidth + cellWidth/2, headCol * cellHeight + cellHeight/2, cellWidth/2);
//        // draw snake body
//        PennDraw.setPenColor(Color.gray);
//        for(int i = 1; i < body.size(); i++) {
//            PennDraw.filledSquare(body.get(i).getRow() * cellWidth + cellWidth/2,
//                    body.get(i).getCol() * cellHeight + cellHeight/2, cellWidth/2);
//        }
//    }
//}
