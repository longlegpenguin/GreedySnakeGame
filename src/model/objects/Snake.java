package model.objects;

import model.objects.utils.Fragment;

import model.objects.utils.Direction;
import model.objects.utils.SnakeTerritory;

import static model.objects.utils.Direction.*;

import java.util.LinkedList;
import java.util.List;

/*
 This module describes a snake.
 How it will move or how it behaves when it eats.
 Does it hit the wall or does it eat itself?
 In which direction should it moves?
 */
public class Snake {

    Fragment head;
    List<Fragment> body = new LinkedList<>();
    Direction direction;

    // Constructor
    public Snake(SnakeTerritory territory) {
        head = new Fragment(territory.getLeftBorder() + 2, territory.getLowerBorder());
        body.add(new Fragment(territory.getLeftBorder() + 1, territory.getLowerBorder()));
        body.add(new Fragment(territory.getLeftBorder(), territory.getLowerBorder()));
        direction = RIGHT;
//        this.territory = territory;
    }

    public Fragment getHead() {
        return head;
    }

    public List<Fragment> getBody() {
        return body;
    }

    //methods

    public void move() {
        // body move
        // Where used to be the head becomes body.
        // The tail of the snake is deleted.
        body.add(0, new Fragment(head.getX(), head.getY()));
        body.remove(body.size()-1);

        // head move
        head.shiftBy(direction.getXIncrement(), direction.getYIncrement());

//        handleBorderCross();
    }

    // Later bomb food, shorten food with special effects maybe added.
    public Boolean eat(Food food) {
        // At any place add a fragment, cancel out the deletion of tail in move()
        body.add(new Fragment(-1,-1));
        return true;
    }

    public boolean touchedFood(Food food) {
        return head.equals(food);
    }

    public boolean hasCrossedBorder(SnakeTerritory territory) {
        return head.isOutOfTerritory(
                territory.getLeftBorder(),
                territory.getRightBorder(),
                territory.getUpperBorder(),
                territory.getLowerBorder()
        );
    }

    public boolean isEatingItself() {
        for (Fragment bodyPart: body) {
            if (head.equals(bodyPart)) {
                return true;
            }
        }
        return false;
    }

    public void changeDirection(char key) {
        switch (key) {
            case 'a':
                if (!(direction == RIGHT)) {
                    direction = LEFT;
                    System.out.println("to LEFT");
                }
                break;
            case 'd':
                if (!(direction == LEFT)) {
                    direction = RIGHT;
                }
                break;
            case 'w':
                if (!(direction == DOWN)) {
                    direction = UP;
                    System.out.println("to Up");
                }
                break;
            case 's':
                if (!(direction == UP)) {
                    direction = DOWN;
                }
                break;
            default:
                break;
        }
    }
}
