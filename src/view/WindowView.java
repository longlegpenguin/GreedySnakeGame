package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import view.utils.drawingUtils;
import viewModel.GreedySnakeGame;
import javafx.scene.text.Text;

import static view.utils.drawingUtils.*;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class WindowView extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Demo");
        stage.setHeight(800);
        stage.setWidth(800);
        stage.setTitle("Greedy Snake");

        BorderPane root = new BorderPane();

        final Canvas[] layer = {new Canvas(500, 500)};

        final GraphicsContext[] gc = {layer[0].getGraphicsContext2D()};
        drawBackground(gc[0], GreedySnakeGame.game);
        drawGameModel(gc[0], GreedySnakeGame.game);


        FileInputStream input = new FileInputStream("src/logo.jpg");

        Image logo = new Image(input);
        ImageView imageView = new ImageView(logo);
        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        Label ME = new Label("GREEDY SNAKE", imageView);
        ME.setTextFill(Color.DARKGOLDENROD);
        ME.setFont(new Font("Arial", 30));
        ME.setAlignment(Pos.CENTER);

        HBox heading = new HBox(ME);
        heading.setSpacing(50);
        heading.setAlignment(Pos.CENTER);
        heading.setMinHeight(100);
        heading.setMargin(ME, new Insets(30));


        Button continu = new Button("Continue(^C)");
        continu.setId("continue");
        Button quit = new Button("Quit(^Q)");
        Button pause = new Button("Pause(^P)");
        pause.setId("pause");
        continu.setOnAction(GreedySnakeGame.buttonHandler());
        quit.setOnAction(GreedySnakeGame.quitHandler());
        pause.setOnAction(GreedySnakeGame.buttonHandler());
        HBox buttons = new HBox(continu, pause, quit);
        buttons.setSpacing(40);
        buttons.setAlignment(Pos.CENTER);
        buttons.setMinHeight(100);

        Text score = new Text("Score: 0");
        score.setFill(Color.DARKGOLDENROD);
        score.setScaleX(2);
        score.setScaleY(2);
        HBox scoreHolder = new HBox(score);
        scoreHolder.setAlignment(Pos.CENTER);

        VBox footer = new VBox(scoreHolder, buttons);
        root.backgroundProperty().set(new Background(new BackgroundFill(Color.NAVY,new CornerRadii(5),new Insets(0))));
        root.setBottom(footer);
        root.setCenter(layer[0]);
        root.setTop(heading);
        root.addEventHandler(KeyEvent.ANY, GreedySnakeGame.keyHandler());
        stage.setScene(new Scene(root));
        stage.show();

        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                // Here comes your void to refresh the whole application.
                GreedySnakeGame.doIt();
                gc[0].clearRect(0, 0, layer[0].getWidth(), layer[0].getHeight());
                drawingUtils.drawBackground(gc[0], GreedySnakeGame.game);
                drawingUtils.drawGameModel(gc[0], GreedySnakeGame.game);
                score.setText("Score: " + GreedySnakeGame.game.getScore());
            }
        }, 200, 200);
    }



    public static void main(String[] args) {
        launch();
    }
}