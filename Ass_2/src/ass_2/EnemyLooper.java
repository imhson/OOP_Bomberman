/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import java.util.Random;

/**
 *
 * @author Hoangson
 */
public class EnemyLooper extends Thread{
    Enemy enemy;
    @Override
    public void run (){
        int cur;
        int passed=0;
        while(!enemy.isDestroyed){
            Random rand = new Random();
            if(enemy instanceof Oneal){
                enemy.enemy_SPEED = rand.nextInt(4)+1;
                while(enemy.enemy_SPEED == 3 )
                    enemy.enemy_SPEED = rand.nextInt(4)+1;
            }
            cur=rand.nextInt(4)+1;
            switch(cur){
                case (1):{
                if (enemy.check_Down((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                    while(enemy.check_Down((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                        enemy.movingEnemy((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY()+enemy.enemy_SPEED);
                        if ((int)enemy.imageView_enemy.getLayoutX()%StaticObject.object_width==0&&(int)enemy.imageView_enemy.getLayoutY()%StaticObject.object_height==0){
                            passed++;
                        }
                        if (passed==7){
                            passed=0;
                            break;
                        }
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
                        if ((int)enemy.imageView_enemy.getLayoutX()%StaticObject.object_width==0&&(int)enemy.imageView_enemy.getLayoutY()%StaticObject.object_height==0){
                            passed++;
                        }
                        if (passed==7){
                            passed=0;
                            break;
                        }
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
                        if ((int)enemy.imageView_enemy.getLayoutX()%StaticObject.object_width==0&&(int)enemy.imageView_enemy.getLayoutY()%StaticObject.object_height==0){
                            passed++;
                        }
                        if (passed==7){
                            passed=0;
                            break;
                        }                        
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
                        if ((int)enemy.imageView_enemy.getLayoutX()%StaticObject.object_width==0&&(int)enemy.imageView_enemy.getLayoutY()%StaticObject.object_height==0){
                            passed++;
                        }
                        if (passed==7){
                            passed=0;
                            break;
                        }                        
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
