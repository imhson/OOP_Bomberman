/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import javafx.animation.AnimationTimer;
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
    static boolean gameOver = false;
    @Override
    public void start(Stage primaryStage) {
        final int width = 600;
        final int height = 480;
        primaryStage.setTitle("Bomberman");
        Pane root = new Pane();
        Scene primaryScene = new Scene(root, width, height);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        StaticObject staticObject = new StaticObject();
        int level = staticObject.loadFromMatrix("/data_package/matrix_1.txt", root);
        
        int [] pointStart_bomber = {StaticObject.object_width,StaticObject.object_height};
        Bomber bomber = new Bomber(pointStart_bomber);
        
        int [] pointStart_enemyBalloom = {520,396};
        int [] pointStart_enemyOneal = {520,36};
        
        Balloom balloom = new Balloom(pointStart_enemyBalloom);
        Oneal oneal = new Oneal(pointStart_enemyOneal);
        
        EnemyLooper enemyBalloomLooper = new EnemyLooper(balloom);
        EnemyLooper enemyOnealLooper = new EnemyLooper(oneal);
        
        enemyOnealLooper.start();
        enemyBalloomLooper.start();
        root.getChildren().addAll(bomber.imageView_bomber,balloom.imageView_enemy,oneal.imageView_enemy);
        //dieu khien nhan vat
        primaryScene.setOnKeyPressed(action ->{
            if (action.getCode()==KeyCode.UP){
                if (bomber.check_Up((int)bomber.imageView_bomber.getLayoutX(), (int)bomber.imageView_bomber.getLayoutY())){
                    bomber.movingBomber((int)bomber.imageView_bomber.getLayoutX(),(int)bomber.imageView_bomber.getLayoutY()-Bomber.SPEED);
                    bomber.checkItem(bomber);
                }
            }
            else{
            if (action.getCode()==KeyCode.LEFT){
                if (bomber.check_Left((int)bomber.imageView_bomber.getLayoutX(), (int)bomber.imageView_bomber.getLayoutY())){
                    bomber.movingBomber((int)bomber.imageView_bomber.getLayoutX()-Bomber.SPEED,(int)bomber.imageView_bomber.getLayoutY());
                    bomber.checkItem(bomber);
                }
            }
            else{
            if (action.getCode()==KeyCode.DOWN){
                if (bomber.check_Down((int)bomber.imageView_bomber.getLayoutX(), (int)bomber.imageView_bomber.getLayoutY())){
                    bomber.movingBomber((int)bomber.imageView_bomber.getLayoutX(),(int)bomber.imageView_bomber.getLayoutY()+Bomber.SPEED);
                    bomber.checkItem(bomber);
                }
            }
            else{
            if (action.getCode()==KeyCode.RIGHT){
                if (bomber.check_Right((int)bomber.imageView_bomber.getLayoutX(), (int)bomber.imageView_bomber.getLayoutY())){
                    bomber.movingBomber((int)bomber.imageView_bomber.getLayoutX()+Bomber.SPEED,(int)bomber.imageView_bomber.getLayoutY());
                    bomber.checkItem(bomber);
                }
            }
            else{
            if (action.getCode()==KeyCode.SPACE){
                if (bomber.bombRemain>0){
                    int[] point_bomb={(int)bomber.imageView_bomber.getLayoutX(), (int)bomber.imageView_bomber.getLayoutY()};
                    Bomb bomb = new Bomb(point_bomb);
                    root.getChildren().add(bomb.imageView_bomb);
                    bomb.setTime = System.currentTimeMillis();
                    data.dataMatrix[(int)bomb.imageView_bomb.getLayoutY()/StaticObject.object_height][(int)bomb.imageView_bomb.getLayoutX()/StaticObject.object_width]='b';
                    bomber.bombRemain--;
                    new AnimationTimer() {
                        @Override
                        public void handle(long now) {
                            if (System.currentTimeMillis()-bomb.setTime>bomb.delayExplosion&&bomb.delayExplosion>0&&!bomb.isExplode){
                                bomb.explode(root,balloom,oneal,bomber);
                                data.dataMatrix[(int)bomb.imageView_bomb.getLayoutY()/StaticObject.object_height][(int)bomb.imageView_bomb.getLayoutX()/StaticObject.object_width]=' ';
                                bomber.bombRemain++;
                                bomb.isExplode=true;
                                }
                            
                            if (System.currentTimeMillis()-bomb.setTime>bomb.delayExplosion+500&&!bomb.isEnd){
                                    bomb.setEnd(root);
                                    bomb.isEnd=true;
                            }
                        }
                    }.start();
                }
            }
            }
            }
            }
            }
        });
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!gameOver)
                    gameOver = checkContact.checkContact((int) bomber.imageView_bomber.getLayoutX(), (int) bomber.imageView_bomber.getLayoutY(), (int) balloom.imageView_enemy.getLayoutX(), (int) balloom.imageView_enemy.getLayoutY())&&checkContact.checkContact((int) bomber.imageView_bomber.getLayoutX(), (int) bomber.imageView_bomber.getLayoutY(), (int) oneal.imageView_enemy.getLayoutX(), (int) oneal.imageView_enemy.getLayoutY());
                if (balloom.isDestroyed){
                    enemyBalloomLooper.stop();
                    balloom.imageView_enemy.setVisible(false);
                }
                if (oneal.isDestroyed){
                    enemyOnealLooper.stop();
                    oneal.imageView_enemy.setVisible(false);
                }
                if (gameOver){
                    primaryStage.close();
                }
                if (balloom.isDestroyed&&oneal.isDestroyed){
                    if (checkContact.checkContact((int) bomber.imageView_bomber.getLayoutX(), (int) bomber.imageView_bomber.getLayoutY(), (int) balloom.imageView_enemy.getLayoutX(), (int) balloom.imageView_enemy.getLayoutY())){
                        System.out.println("win");
                        
                    }
                }
            }
        }.start();
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
