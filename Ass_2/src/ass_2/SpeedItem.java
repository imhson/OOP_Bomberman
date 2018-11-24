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
public class SpeedItem extends Item{
    ImageView imageView_SpeedItem = new ImageView(new Image(getClass().getResourceAsStream("/image_package/SpeedItem.png")));
    public SpeedItem(int[] point) {
        super(point);
        imageView_SpeedItem.setLayoutX(point[0]);
        imageView_SpeedItem.setLayoutY(point[1]);
    }
    
}
