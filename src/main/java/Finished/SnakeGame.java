//package Finished;
//
//public class SnakeGame {
//    public static void main(String[] args) {
//        if (args.length != 0) { // otherwise, print usage and exit
//            System.out.println("Usage: java Finished.SnakeGame [width height]");
//            return;
//        }
//        int width = 600;
//        int height = 600;
//
//        PennDraw.setCanvasSize(width, height);
//        PennDraw.clear(PennDraw.BLACK);
//        // Set the scale in terms of width and height;
//        // hopefully gives "rounder" numbers for sizes & speeds than
//        // using the default scale of 0-1.
//        PennDraw.setXscale(0, width);
//        PennDraw.setYscale(0, height);
//        int frameRate = 5;
//        PennDraw.enableAnimation(frameRate);
//
//        boolean showEnd = false;
//
//        Board board = new Board(width, height);
//        while (true) {
//            if(board.gameOver()) {
//                PennDraw.disableAnimation();
//                if(!showEnd) {
//                    PennDraw.clear(PennDraw.GREEN);
//                    PennDraw.setPenColor(PennDraw.BLACK);
//                    PennDraw.text(width/2,height/2,"You Lost! Your score was " + board.getScore());
//                    PennDraw.text(width/2,height/2 - 20,"Press R to restart.");
//                    showEnd = true;
//                }
//
//                if(PennDraw.hasNextKeyTyped() && Character.toLowerCase(PennDraw.nextKeyTyped()) == 'r'){
//                    board.reset();
//                    PennDraw.enableAnimation(frameRate);
//                    showEnd = false;
//                }
//            } else {
//                PennDraw.clear(PennDraw.BLACK);
//                board.update();
//                board.draw();
//                PennDraw.advance();
//                if(PennDraw.hasNextKeyTyped()){
//                    char typedKey = Character.toLowerCase(PennDraw.nextKeyTyped()); // in case the users turn on caps lock
//                    if(typedKey == 'k') {
//                        if(frameRate == 5) {
//                            frameRate = 10;
//                        } else {
//                            frameRate = 5;
//                        }
//                        PennDraw.enableAnimation(frameRate);
//                    }
//                    if(!board.isReverseDirection(typedKey)) {
//                        if(typedKey == 'w') {
//                            board.setSnakeDirection(0, 1);
//                        } else if(typedKey == 'a') {
//                            board.setSnakeDirection(-1, 0);
//                        } else if(typedKey == 's') {
//                            board.setSnakeDirection(0, -1);
//                        } else if(typedKey == 'd') {
//                            board.setSnakeDirection(1, 0);
//                        }
//                    }
//                }
//            }
//        }
//    }
//}