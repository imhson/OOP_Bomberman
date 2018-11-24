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
public class FlameItem extends Item{
    ImageView imageView_FlameItem = new ImageView(new Image(getClass().getResourceAsStream("/image_package/FlameItem.png")));
    public FlameItem(int[] point) {
        super(point);
        imageView_FlameItem.setLayoutX(point[0]);
        imageView_FlameItem.setLayoutY(point[1]);
    }
    
}
