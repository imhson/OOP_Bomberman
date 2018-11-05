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
public class Brick extends StaticObject{
    int [] point;
    ImageView imageView_brick = new ImageView(new Image(getClass().getResourceAsStream("/image_package/brick.png")));
    public Brick(int[] point) {
        super(point);
        this.point=point;
        imageView_brick.setLayoutX(point[0]);
        imageView_brick.setLayoutY(point[1]);
    }
}
