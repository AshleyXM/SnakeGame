import java.util.ArrayList;

/**
 * Description: Represents the snake.
 */
public class Snake {
    private double cellWidth, cellHeight;
    private int headRow, headCol;
    private int xVel, yVel;

    private ArrayList<SnakeSegment> body;

    public Snake(int headRow, int headCol, double cellWidth, double cellHeight) {
        this.headRow = headRow;
        this.headCol= headCol;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        xVel = 0;
        yVel = 0;
        body = new ArrayList<>();
        body.add(new SnakeSegment(headRow, headCol));
    }

    public int getxVel() {
        return xVel;
    }

    public int getyVel() {
        return yVel;
    }

    /**
     * Determine whether the snake has bit itself.
     * @return true if the snake has bit itself, false otherwise
     */
    public boolean biteSelf() {
        for(int i = 1; i < body.size(); i++) {
            int row = body.get(i).getRow();
            int col = body.get(i).getCol();
            if(row == headRow && col == headCol) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add one body segment
     */
    public void addSegment() {
        SnakeSegment tail = body.get(body.size() - 1);
        body.add(new SnakeSegment(tail.getRow(), tail.getCol()));
    }

    public int getHeadRow() {
        return headRow;
    }

    public int getHeadCol() {
        return headCol;
    }

    /**
     * Determine whether the user is trying to move the snake into the
     * reverse direction
     * @param typed the key the user entered
     * @return true if the user is trying to change into the reverse
     * direction, false otherwise
     */
    public boolean isReverseDirection(char typed) {
        if(typed == 'w') {
            if(xVel == 0 && yVel == -1) {
                return true;
            }
        } else if(typed == 'a') {
            if(xVel == 1 && yVel == 0) {
                return true;
            }
        } else if(typed == 's') {
            if(xVel == 0 && yVel == 1) {
                return true;
            }
        } else if(typed == 'd') {
            if(xVel == -1 && yVel == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Change the direction of the snake
     * @param xVel the new horizontal direction (if -1, left; 1, right)
     * @param yVel the new vertical direction (if -1, down; 1, up)
     */
    public void changeDirection(int xVel, int yVel) {
        this.xVel = xVel;
        this.yVel = yVel;
    }

    /**
     * Update the snake to the new position
     */
    public void update() {
        body.set(0, new SnakeSegment(headRow, headCol));
        for(int i = body.size() - 1; i > 0; i--) {
            body.set(i, body.get(i - 1));
        }
        headRow = headRow + yVel;
        headCol = headCol + xVel;
    }

    /**
     * Draw the snake
     */
    public void draw() {
        PennDraw.setPenColor(PennDraw.WHITE);
        PennDraw.filledSquare(headCol * cellWidth + cellWidth / 2, headRow * cellHeight + cellHeight/2, cellWidth/2);
        PennDraw.setPenColor(PennDraw.GRAY);
        for(int i = 1; i < body.size(); i++) {
            int segmentCol = body.get(i).getCol();
            int segmentRow = body.get(i).getRow();
            PennDraw.filledSquare(segmentCol * cellWidth + cellWidth / 2, segmentRow * cellHeight + cellHeight/2, cellWidth/2);
        }

    }
}
