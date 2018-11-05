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
public class Wall extends StaticObject{
    int [] point;
    ImageView imageView_wall = new ImageView(new Image(getClass().getResourceAsStream("/image_package/wall.png")));
    public Wall(int[] point) {
        super(point);
        this.point=point;
        imageView_wall.setLayoutX(point[0]);
        imageView_wall.setLayoutY(point[1]);
    }
}
