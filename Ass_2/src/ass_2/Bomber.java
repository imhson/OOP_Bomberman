/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Hoangson
 */
public class Bomber extends DynamicObject{
    public static int bombRemain=3;
    ImageView imageView_bomber = new ImageView(new Image(getClass().getResourceAsStream("/image_package/bomber.png")));
    public static int SPEED = 4;

    public Bomber(int[] point) {
        super(point);
        imageView_bomber.setLayoutX(point[0]);
        imageView_bomber.setLayoutY(point[1]);
    }
    
    public void movingBomber (int x, int y){
        imageView_bomber.setLayoutX(x);
        imageView_bomber.setLayoutY(y);        
    }
    
    public void changeSpeed(String change){
        if (change.equals("INCREASE")){
            if (SPEED==1)
                SPEED=2;
            else
                if (SPEED==2){
                    SPEED=4;
                }
        }
        if (change.equals("DECREASE")){
            if (SPEED==4)
                SPEED=2;
            else
                if (SPEED==2){
                    SPEED=1;
                }
        }
    }
}
