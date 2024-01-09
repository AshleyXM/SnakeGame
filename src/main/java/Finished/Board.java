//package Finished;
//
//public class Board {
//
//    private int numRows, numCols;
//    private double width, height;
//    private double cellWidth, cellHeight;
//    private Snake snake;
//    private Food food;
//    private BonusFood bonusFood;
//    private int score;
//
//    public Board(double width, double height) {
//        this.width = width;
//        this.height = height;
//        numRows = 30;
//        numCols = 30;
//        cellHeight = height / numRows;
//        cellWidth = width / numCols;
//        snake = new Snake(numRows / 2, numCols / 2, cellWidth, cellHeight);
//        food = new Food(numRows, numCols, cellWidth, cellHeight);
//        bonusFood = new BonusFood(numRows, numCols, cellWidth, cellHeight);
//        score = 0;
//    }
//
//    public void setSnakeDirection(int xVel, int yVel) {
//        snake.setDirection(xVel, yVel);
//    }
//
//    public boolean isReverseDirection(char direction) {
//        if((direction == 'w' && snake.getxVel() == 0 && snake.getyVel() == -1) ||
//                (direction == 'a' && snake.getxVel() == 1 && snake.getyVel() == 0) ||
//                (direction == 's' && snake.getxVel() == 0 && snake.getyVel() == 1) ||
//                (direction == 'd' && snake.getxVel() == -1 && snake.getyVel() == 0)) {
//            return true;
//        }
//        return false;
//    }
//
//    public void update() {
//        snake.update();
//        bonusFood.reduceInterval();
//        if(snake.getHeadRow() == food.getRow() && snake.getHeadCol() == food.getCol()) {
//            food.update();
//            snake.addSegment();
//            score += 10;
//        }
//
//        if(snake.getHeadRow() == bonusFood.getRow() && snake.getHeadCol() == bonusFood.getCol()) {
//            bonusFood.update();
//            snake.addSegment();
//            score += 20;
//        }
//    }
//
//    public void draw() {
//        snake.draw();
//        food.draw();
//        bonusFood.draw();
//        PennDraw.setPenColor(PennDraw.GREEN);
//        PennDraw.text(cellWidth * (numCols - 3), cellHeight * (numRows - 1),"Score: " + score);
//    }
//
//    public boolean gameOver() {
//        if(snake.biteSelf() ||
//                snake.getHeadRow() == -1 || snake.getHeadRow() == numRows ||
//                snake.getHeadCol() == -1 || snake.getHeadCol() == numCols) {
//            return true;
//        }
//        return false;
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void reset() {
//        score = 0;
//        snake = new Snake(numRows / 2, numCols / 2, cellWidth, cellHeight);
//        bonusFood = new BonusFood(numRows, numCols, cellWidth, cellHeight);
//    }
//}
