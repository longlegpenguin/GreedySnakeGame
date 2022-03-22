package model;

import model.objects.Food;
import model.objects.Snake;
import model.objects.utils.SnakeTerritory;
import model.utils.GameState;
import static model.utils.GameState.*;

/*
 This class contains the basics of how a greedy snake game behaves in a single cycle
 (For a snake to move one tile forward, according to whether it will eat or will die or simply will move)
 */
public class GreedySnake {

    SnakeTerritory territory = new SnakeTerritory(0, 15, 0, 15);
    GameState gs = TOBESTARTED;
    Snake snake = new Snake(territory);
    Food food = Food.generateFood(territory);
    int score;

    public void setGs(GameState gs) {
        this.gs = gs;
    }

    public Food getFood() {
        return food;
    }

    public Snake getSnake() {
        return snake;
    }

    public SnakeTerritory getTerritory() {
        return territory;
    }

    public int getScore() {
        return score;
    }

    public void doIt() {
        switch (gs) {
            case NEWGAME -> {
                score = 0;
                gs = STARTED;
            }
            case STARTED -> play();
            case GAMEOVER, TOBESTARTED -> startingPrompt();
            case PAUSED -> pause();
        }
    }

    private void pause() {
        System.out.println("Paused!");
    }

    public GameState getGs() {
        return gs;
    }

    public void startOver(String key) {

        if (key.equals("ENTER") && gs != STARTED) {
            snake = new Snake(territory);
            gs = NEWGAME;
            System.out.println("NEW GAME!");
        }
    }

    public void startingPrompt() {
    }



    public void play() {
//        try {
//            Thread.sleep(200 - snake.getBody().size());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        snake.move();
        if (snake.touchedFood(food)) {
            if (snake.eat(food)) {
                score++;
                food = Food.generateFood(territory);
            }
        }

        if (snake.hasCrossedBorder(territory) || snake.isEatingItself()) {
            gs = GAMEOVER;
        }
    }

}
