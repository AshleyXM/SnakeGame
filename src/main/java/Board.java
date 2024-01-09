/**
 * Description: Represents the snake game board.
 * Dependencies: PennDraw.java Snake.java Food.java BonusFood.java
 */
public class Board {

    private int numRows, numCols;
    private double width, height;
    private double cellWidth, cellHeight;
    private Snake snake;
    private Food food;
    private BonusFood bonusFood;
    private int score;

    /**
     * Initialize xxx
     * @param width the width of the board
     * @param height
     */
    public Board(double width, double height) {
        this.width = width;
        this.height = height;
        this.numRows = 30;
        this.numCols = 30;
        cellWidth = width/numCols;
        cellHeight = height/numRows;
        snake = new Snake(numRows/2, numCols/2, cellWidth, cellHeight);
        food = new Food(numRows, numCols, cellWidth, cellHeight);
        bonusFood = new BonusFood(numRows, numCols, cellWidth, cellHeight);
        score = 0;
    }

    public int getScore() {
        return score;
    }

    /**
     * Determine whether the snake is out of bound
     * @return true if xxx, false otherwise
     */
    public boolean isOutOfBoundary() {
        int headRow = snake.getHeadRow();
        int headCol = snake.getHeadCol();
        if(headRow == -1 || headRow == numRows || headCol == -1 || headCol == numCols) {
            return true;
        }
        return false;
    }

    /**
     * Determine whether the game is over
     * @return true if the game is over, false otherwise
     */
    public boolean gameOver() {
        if(isOutOfBoundary() || snake.biteSelf()) {
            return true;
        }
        return false;
    }

    /**
     * Reset snake, food, bonusFood and score to the initial state
     * when the user press R to restart the game
     */
    public void reset() {
        snake = new Snake(numRows/2, numCols/2, cellWidth, cellHeight);
        food = new Food(numRows, numCols, cellWidth, cellHeight);
        bonusFood = new BonusFood(numRows, numCols, cellWidth, cellHeight);
        score = 0;
    }

    /**
     * Change the snake direction based on what the user inputs
     * @param typed the key the user inputs
     */
    public void changeDirection(char typed){
        if(!snake.isReverseDirection(typed)) {
            if(typed == 'w') {
                snake.changeDirection(0, 1);
            } else if(typed == 'a') {
                snake.changeDirection(-1, 0);
            } else if(typed == 's') {
                snake.changeDirection(0, -1);
            } else if(typed == 'd') {
                snake.changeDirection(1, 0);
            }
        }
    }

    /**
     * Update the snake, food and score
     */
    public void update() {
        snake.update();
        if(snake.getxVel()!= 0 || snake.getyVel() != 0) {
            bonusFood.reduceInterval();
        }
        if(snake.getHeadRow() == food.getRow() && snake.getHeadCol() == food.getCol()) {
            food.update();
            snake.addSegment();
            score += 10;
        }
        if(snake.getHeadRow() == bonusFood.getRow() && snake.getHeadCol() == bonusFood.getCol()) {
            bonusFood.update();
            snake.addSegment();
            score += 20;
        }
    }

    public void draw() {
        snake.draw();
        food.draw();
        if(bonusFood.getInterval() == 0) {
            bonusFood.draw();
        }
        PennDraw.setPenColor(PennDraw.GREEN);
        PennDraw.text((numCols - 3) * cellWidth, (numRows - 1) * cellHeight,"Score: " + score);
    }
}
