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
public class Portal extends StaticObject{
    static int [] point;
    ImageView imageView_portal = new ImageView(new Image(getClass().getResourceAsStream("/image_package/portal.png")));

    public Portal() {
    }
    
    public Portal(int[] point) {
        super(point);
        this.point=point;
        imageView_portal.setLayoutX(point[0]);
        imageView_portal.setLayoutY(point[1]);
    }
}
