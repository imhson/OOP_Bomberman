/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;

/**
 *
 * @author Hoangson
 */
public class EnemyLooper extends Thread{
    Enemy enemy;
    @Override
    public void run (){
        int cur=0;
        while(!enemy.isDestroyed){
            Random rand = new Random();
            cur=rand.nextInt(4)+1;
            switch(cur){
                case (1):{
                if (enemy.check_Down((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                    while(enemy.check_Down((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                        if (enemy.check_Right((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                            break;
                        }
                        enemy.movingEnemy((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY()+enemy.enemy_SPEED);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                break;
                }
                case (2):{
                if (enemy.check_Up((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                    while(enemy.check_Up((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                        enemy.movingEnemy((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY()-enemy.enemy_SPEED);                
                                            try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }

                    }
                }
                break;
                }
                case (3):
                if (enemy.check_Right((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                    while(enemy.check_Right((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                        enemy.movingEnemy((int)enemy.imageView_enemy.getLayoutX()+enemy.enemy_SPEED,(int)enemy.imageView_enemy.getLayoutY());                
                                            try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }

                    }
                }
                break;
                case (4):
                if (enemy.check_Left((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                    while(enemy.check_Left((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                        enemy.movingEnemy((int)enemy.imageView_enemy.getLayoutX()-enemy.enemy_SPEED,(int)enemy.imageView_enemy.getLayoutY());                
                                            try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }

                    }
                }
                break;
            }
        }
    }


    public EnemyLooper(Enemy enemy) {
        this.enemy = enemy;
    }
    
}
