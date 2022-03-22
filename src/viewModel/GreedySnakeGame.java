package viewModel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.GreedySnake;

import static model.utils.GameState.*;


public class GreedySnakeGame {

    static public GreedySnake game = new GreedySnake(/*new SnakeTerritory()*/);

    public static EventHandler<KeyEvent> keyHandler() {
        return event -> {
//                System.out.println(event.getCode());
            game.getSnake().changeDirection(event.getCharacter().toCharArray()[0]);
            game.startOver(event.getCode().toString());
        };
    }

    public static EventHandler<ActionEvent> quitHandler() {
        return new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            }
        };
    }

    public static EventHandler<ActionEvent> buttonHandler() {
        return new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                String id = ((Button)event.getSource()).getId();
                if (id.equals("continue")) {
                    game.setGs(STARTED);
                } else if (id.equals("pause") && game.getGs() == STARTED) {
                    game.setGs(PAUSED);
                    System.out.println(event.getSource());
                    ((Button)event.getSource()).setContentDisplay(ContentDisplay.valueOf("Continue"));
                }
            }
        };
    }


    public static void doIt() {
        game.doIt();
    }
}
