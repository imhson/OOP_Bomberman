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
    public static int bombRemain=1;
    ImageView imageView_bomber = new ImageView(new Image(getClass().getResourceAsStream("/image_package/bomber.png")));
    public static int SPEED = 1;

    public Bomber(int[] point) {
        super(point);
        imageView_bomber.setLayoutX(point[0]);
        imageView_bomber.setLayoutY(point[1]);
    }
    
    public void movingBomber (int x, int y){
        imageView_bomber.setLayoutX(x);
        imageView_bomber.setLayoutY(y);        
    }
    public void checkItem (Bomber bomber){
        int locationColumn = (int) (bomber.imageView_bomber.getLayoutX())/StaticObject.object_width;
        int locationRow = (int) (bomber.imageView_bomber.getLayoutY())/StaticObject.object_height;
        char item = data.dataMatrix[locationRow][locationColumn];
        if (item=='s'){
            Bomber.changeSpeed("INCREASE");
            data.dataNode[locationRow][locationColumn].setVisible(false);
            data.dataMatrix[locationRow][locationColumn]=' ';
        }
        if (item=='f'){
            Bomb.power++;
            data.dataNode[locationRow][locationColumn].setVisible(false);
            data.dataMatrix[locationRow][locationColumn]=' ';
        }
        if (item=='o'){
            Bomber.bombRemain++;
            data.dataNode[locationRow][locationColumn].setVisible(false);
            data.dataMatrix[locationRow][locationColumn]=' ';
        }
    }

    public static void changeSpeed(String change){
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
