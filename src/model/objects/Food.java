package model.objects;

import model.objects.utils.Fragment;
import model.objects.utils.SnakeTerritory;

import java.util.Random;


public class Food extends Fragment {

    // A private constructor just for generate food.
    private Food(int x, int y) {
        super(x, y);
    }

    public static Food generateFood(SnakeTerritory territory) {
        Random random = new Random();
        return new Food(random.nextInt(territory.getRightBorder()),
                        (random.nextInt(territory.getLowerBorder() - 1)+1)
        );
    }
}
