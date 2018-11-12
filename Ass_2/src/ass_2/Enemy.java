/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.animation.Transition.*;
import javafx.util.Duration;

/**
 *
 * @author Hoangson
 */
public class Enemy extends DynamicObject{
    ImageView imageView_enemy = new ImageView(new Image(getClass().getResourceAsStream("/image_package/enemy.png")));
    public static int enemy_SPEED = 4;
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
}
