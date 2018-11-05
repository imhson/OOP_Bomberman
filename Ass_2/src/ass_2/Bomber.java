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
    int [] point;
    public static int bombRemain=1;
    ImageView imageView_bomber = new ImageView(new Image(getClass().getResourceAsStream("/image_package/bomber.png")));
    public static int bomber_SPEED = 4;

    public Bomber(int[] point) {
        super(point);
        super.SPEED=bomber_SPEED;
        imageView_bomber.setLayoutX(point[0]);
        imageView_bomber.setLayoutY(point[1]);
    }
    
    public void movingBomber (int x, int y){
        imageView_bomber.setLayoutX(x);
        imageView_bomber.setLayoutY(y);        
    }
    
    public void changeSpeed(String change){
        if (change.equals("INCREASE")){
            if (bomber_SPEED==1)
                bomber_SPEED=2;
            else
                if (bomber_SPEED==2){
                    bomber_SPEED=4;
                }
        }
        if (change.equals("DECREASE")){
            if (bomber_SPEED==4)
                bomber_SPEED=2;
            else
                if (bomber_SPEED==2){
                    bomber_SPEED=1;
                }
        }
        super.SPEED=bomber_SPEED;
    }
}
