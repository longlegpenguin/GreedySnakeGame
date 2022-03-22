package view.utils;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.GreedySnake;
import model.objects.Food;
import model.objects.utils.Fragment;
import model.objects.Snake;
import static model.utils.GameState.*;


public class drawingUtils {

    public static void drawBackground(GraphicsContext gc, GreedySnake gp) {

        int left = gp.getTerritory().getLeftBorder() * 30;
        int right = (gp.getTerritory().getRightBorder()+1) * 30;
        int up = gp.getTerritory().getUpperBorder() * 30;
        int low = (gp.getTerritory().getLowerBorder()+1 )* 30;
        int num = gp.getTerritory().getRightBorder();
//         grey background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, (num+1)*30 , (num+1)*30);
        for (int i = 0; i <= num+1; i++) {
            // starting coordinate -> end coordinate
            gc.setStroke(Color.DARKBLUE);
            gc.strokeLine(left, i*30, right, i*30);
            gc.strokeLine(i*30, up, i*30, low);
        }
    }
//    }

    public static void drawGameModel(GraphicsContext gc, GreedySnake gp) {
        if (gp.getGs() == STARTED || gp.getGs() == PAUSED) {
            drawSnake(gp.getSnake(), gc);
            drawFood(gp.getFood(), gc);
        } else if (gp.getGs() == GAMEOVER) {
            drawSnake(gp.getSnake(), gc);
//            drawWord(gc, "GAME OVER", Color.BLACK, 50, 150, 250);
//            drawWord(gc, " PRESS SPACE TO START OVER", Color.BLUE, 25, 100, 350);
        } else if (gp.getGs() == TOBESTARTED) {
            drawSnake(gp.getSnake(), gc);
//            drawWord(gc, "HELLO 🐛", Color.BLACK, 50, 200, 250);
//            drawWord(gc, " PRESS SPACE TO START OVER", Color.BLUE, 25, 100, 350);
        }
    }
    private static void drawFood(Food food, GraphicsContext g) {
        drawFragment(food, g, Constants.FOODCOLOR);
    }

    private static void drawSnake(Snake snake, GraphicsContext g) {
        drawBody(snake, g);
        drawHead(snake, g);
    }

    private static void drawBody(Snake snake, GraphicsContext gc) {
        for (Fragment frag: snake.getBody()) {
            drawFragment(frag, gc, Constants.BODYCOLOR);
        }
    }

    private static void drawHead(Snake snake, GraphicsContext gc) {
        drawFragment(snake.getHead(), gc, Constants.HEADCOLOR);
    }

    private static void drawFragment(Fragment fragment, GraphicsContext gc, Color color) {
        int oneStep = 30 /*Constants.TILESIZE*/;
        gc.setFill(color);
        gc.fillRect(
                fragment.getX() * oneStep,
                fragment.getY() * oneStep,
                oneStep,
                oneStep
        );
    }

//    private static void drawWord(Graphics g, String str, Color color, int fontSize, int xCoordinate, int yCoordinate) {
//        g.setColor(color);
//        g.setFont(new Font("仿宋", Font.BOLD, fontSize));
//        g.drawString(str, xCoordinate, yCoordinate);
//    }

}