package model.objects.utils;

import model.objects.Snake;

import static view.utils.Constants.TILESIZE;
import static view.utils.Constants.VIEWSIZE;

// this module contains a method to deal with over board without the snake die
// Because I want it to die I never use this method.
// Save it here in case I change my mind.
public class snakeUtils {

    public static void handleBorderCross(Snake snake) {
        Fragment head = snake.getHead();
        int border = VIEWSIZE - TILESIZE;
        int headX = head.getX();
        int headY = head.getY();
        if (headX < 0) {
            head.setX(border);
        } else if (headX > border) {
            head.setX(0);
        } else if (headY < TILESIZE) {
            head.setY(border);
        } else if (headY > border) {
            head.setY(TILESIZE);
        }
    }
}
