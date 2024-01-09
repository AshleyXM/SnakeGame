/**
 * Description: Represents the snake game, including the initialization
 * of the board, monitoring the keystroke and the game status and updating
 * the game
 * Execution: java SnakeGame [width height]
 * Dependencies: PennDraw.java Board.java
 */

public class SnakeGame {
    public static void main(String[] args) {
        int width = 600;
        int height = 600;

        PennDraw.setCanvasSize(width, height);
        // Set the scale in terms of width and height;
        // hopefully gives "rounder" numbers for sizes & speeds than
        // using the default scale of 0-1.
        PennDraw.setXscale(0, width);
        PennDraw.setYscale(0, height);
        int frameRate = 5;
        PennDraw.enableAnimation(frameRate);

        Board board = new Board(width, height);
        boolean hasShow = false;
        while (true) {
            if(PennDraw.hasNextKeyTyped()) {
                char typed = Character.toLowerCase(PennDraw.nextKeyTyped());
                board.changeDirection(typed);
                if(typed == 'r') {
                    board.reset();
                    PennDraw.enableAnimation(frameRate);
                    hasShow = false;
                }
                if(typed == 'f') {
                    if(frameRate == 5) {
                        frameRate = 15;
                    } else { // 10
                        frameRate = 5;
                    }
                    PennDraw.enableAnimation(frameRate);
                }
            }

            if(board.gameOver()) {
                System.out.println("game over");
                if(!hasShow) {
                    System.out.println("has show is false");
                    PennDraw.disableAnimation();
                    PennDraw.clear(PennDraw.GREEN);
                    PennDraw.setPenColor(PennDraw.BLACK);
                    PennDraw.text(width/2,height/2,"You Lost! Your score was " + board.getScore());
                    PennDraw.text(width/2,height/2 - 20,"Press R to restart.");
                    hasShow = true;
                }
            } else {
                PennDraw.clear(PennDraw.BLACK);
                board.update();
                board.draw();
                PennDraw.advance();
            }
        }
    }
}