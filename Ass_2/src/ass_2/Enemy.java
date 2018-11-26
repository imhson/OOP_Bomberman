/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Hoangson
 */
public class Enemy extends DynamicObject{
    ImageView imageView_enemy = new ImageView(new Image(getClass().getResourceAsStream("/image_package/enemy.png")));
    public int enemy_SPEED;
    public int dir=1,passed=0;
    boolean isDestroyed=false;
    public Enemy(int[] point) {
        super(point);
        this.isDestroyed = false;
        imageView_enemy.setLayoutX(point[0]);
        imageView_enemy.setLayoutY(point[1]);
    }

    public Enemy() {
    }
    
    public void movingEnemy (int x, int y){
        imageView_enemy.setLayoutX(x);
        imageView_enemy.setLayoutY(y);    
    }
    public void run (Enemy enemy){
        switch(this.dir){
            case(1):{
                if (enemy.check_Down((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                    enemy.movingEnemy((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY()+enemy.enemy_SPEED);
                    if ((int)enemy.imageView_enemy.getLayoutX()%StaticObject.object_width==0&&(int)enemy.imageView_enemy.getLayoutY()%StaticObject.object_height==0){
                            this.passed++;
                        }
                        if (this.passed==7){
                            this.passed=0;
                            Random rand = new Random();
                            this.dir = rand.nextInt(4)+1;
                            break;
                        }
                }
                else{
                    Random rand = new Random();
                    this.dir = rand.nextInt(4)+1;
                }
                break;
            }
            case(2):{
                if(enemy.check_Up((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                    enemy.movingEnemy((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY()-enemy.enemy_SPEED);                                    
                    if ((int)enemy.imageView_enemy.getLayoutX()%StaticObject.object_width==0&&(int)enemy.imageView_enemy.getLayoutY()%StaticObject.object_height==0){
                            this.passed++;
                        }
                        if (this.passed==7){
                            this.passed=0;
                            Random rand = new Random();
                            this.dir = rand.nextInt(4)+1;
                            break;
                        }
                    
                }
                else{
                    Random rand = new Random();
                    this.dir = rand.nextInt(4)+1;
                }
                break;
            }
            case(3):{
                if (enemy.check_Right((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                    enemy.movingEnemy((int)enemy.imageView_enemy.getLayoutX()+enemy.enemy_SPEED,(int)enemy.imageView_enemy.getLayoutY());  
                    if ((int)enemy.imageView_enemy.getLayoutX()%StaticObject.object_width==0&&(int)enemy.imageView_enemy.getLayoutY()%StaticObject.object_height==0){
                            this.passed++;
                        }
                        if (this.passed==7){
                            this.passed=0;
                            Random rand = new Random();
                            this.dir = rand.nextInt(4)+1;
                            break;
                        }
                }
                else{
                    Random rand = new Random();
                    this.dir = rand.nextInt(4)+1;
                }
                break;
            }
            case(4):{
                if (enemy.check_Left((int)enemy.imageView_enemy.getLayoutX(),(int)enemy.imageView_enemy.getLayoutY())){
                    enemy.movingEnemy((int)enemy.imageView_enemy.getLayoutX()-enemy.enemy_SPEED,(int)enemy.imageView_enemy.getLayoutY());  
                    if ((int)enemy.imageView_enemy.getLayoutX()%StaticObject.object_width==0&&(int)enemy.imageView_enemy.getLayoutY()%StaticObject.object_height==0){
                            this.passed++;
                        }
                        if (this.passed==7){
                            this.passed=0;
                            Random rand = new Random();
                            this.dir = rand.nextInt(4)+1;
                            break;
                        }
                }
                else{
                    Random rand = new Random();
                    this.dir = rand.nextInt(4)+1;
                }
                break;
            }

        }
    }
}
