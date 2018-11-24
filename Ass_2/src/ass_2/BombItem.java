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
public class BombItem extends Item{
    ImageView imageView_bombItem = new ImageView(new Image(getClass().getResourceAsStream("/image_package/BombItem.png")));
    public BombItem(int[] point) {
        super(point);
        imageView_bombItem.setLayoutX(point[0]);
        imageView_bombItem.setLayoutY(point[1]);
    }
    
}
