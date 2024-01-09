/**
 * Description: Represents the snake segment.
 */
public class SnakeSegment {
    private int row, col;

    public SnakeSegment(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     *
     * @return
     */
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
