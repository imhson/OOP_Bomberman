/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Hoangson
 */
public class Ass_2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        final int width = 600;
        final int height = 480;
        
        primaryStage.setTitle("Bomberman");
        Pane root = new Pane();
        StaticObject staticObject = new StaticObject();
        int level = staticObject.loadFromMatrix("/data_package/matrix_1.txt", root);
        int [] pointStart_bomber = {StaticObject.object_width,StaticObject.object_height};
        Bomber bomber = new Bomber(pointStart_bomber);
        Scene primaryScene = new Scene(root, width, height);
        
        //dieu khien nhan vat
        primaryScene.setOnKeyPressed(action ->{
            if (action.getCode()==KeyCode.W){
                if (bomber.check_Up((int)bomber.imageView_bomber.getLayoutX(), (int)bomber.imageView_bomber.getLayoutY())){
                    bomber.movingBomber((int)bomber.imageView_bomber.getLayoutX(),(int)bomber.imageView_bomber.getLayoutY()-bomber.SPEED);
                }
            }
            else{
            if (action.getCode()==KeyCode.A){
                if (bomber.check_Left((int)bomber.imageView_bomber.getLayoutX(), (int)bomber.imageView_bomber.getLayoutY())){
                    bomber.movingBomber((int)bomber.imageView_bomber.getLayoutX()-bomber.SPEED,(int)bomber.imageView_bomber.getLayoutY());
                }
            }
            else{
            if (action.getCode()==KeyCode.S){
                if (bomber.check_Down((int)bomber.imageView_bomber.getLayoutX(), (int)bomber.imageView_bomber.getLayoutY())){
                    bomber.movingBomber((int)bomber.imageView_bomber.getLayoutX(),(int)bomber.imageView_bomber.getLayoutY()+bomber.SPEED);
                }
            }
            else{
            if (action.getCode()==KeyCode.D){
                if (bomber.check_Right((int)bomber.imageView_bomber.getLayoutX(), (int)bomber.imageView_bomber.getLayoutY())){
                    bomber.movingBomber((int)bomber.imageView_bomber.getLayoutX()+bomber.SPEED,(int)bomber.imageView_bomber.getLayoutY());
                }
            }
            else{
            if (action.getCode()==KeyCode.SPACE){
                if (bomber.bombRemain>0){
                    int[] point_bomb={(int)bomber.imageView_bomber.getLayoutX(), (int)bomber.imageView_bomber.getLayoutY()};
                    Bomb bomb = new Bomb(point_bomb);
                    root.getChildren().add(bomb.imageView_bomb);
                    data.dataMatrix[(int)bomb.imageView_bomb.getLayoutY()/StaticObject.object_height][(int)bomb.imageView_bomb.getLayoutX()/StaticObject.object_width]='b';
                    bomber.bombRemain--;
                    
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask(){
                    @Override
                    public void run(){
                        bomb.explode(root);
                        data.dataMatrix[(int)bomb.imageView_bomb.getLayoutY()/StaticObject.object_height][(int)bomb.imageView_bomb.getLayoutX()/StaticObject.object_width]=' ';
                        bomber.bombRemain++;
                    }
                    }, bomb.delayExplosion);
                }
            }
            }
            }
            }
            }
        });
        
        root.getChildren().add(bomber.imageView_bomber);

        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
