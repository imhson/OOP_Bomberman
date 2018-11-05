/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Hoangson
 */
public class Bomb extends StaticObject{
    int [] point;
    Flare flare;
    public static int power=1;
    final static int delayExplosion = 3500;  //miliseconds
    ImageView imageView_bomb = new ImageView(new Image(getClass().getResourceAsStream("/image_package/bomb.png")));
    public Bomb(int[] point) {
        point[0]=((point[0]+object_width/2)/object_width)*object_width;
        point[1]=((point[1]+object_height/2)/object_height)*object_height;
        this.point=point;
        super.point=point;
        flare = new Flare(point[0], point[1]);
        imageView_bomb.setLayoutX(point[0]);
        imageView_bomb.setLayoutY(point[1]);
    }
    public void explode(Pane root){
        
        flare.printFlare(root);
    }
}
