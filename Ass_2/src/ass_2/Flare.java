/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import java.util.Date;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Hoangson
 */
public class Flare{
    int centerX;
    int centerY;
    ImageView imageView_flareCenter = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flare_center.png")));
    ImageView[] imageView_flareEnding = new ImageView[4];
    ImageView[][] imageView_flareBody= new ImageView[4][5];

    public Flare(int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }
    public void printFlare(Pane root){
        boolean UP=true,DOWN=true,RIGHT=true,LEFT=true;
        
        imageView_flareCenter.setLayoutX(centerX);
        imageView_flareCenter.setLayoutY(centerY);
        root.getChildren().add(imageView_flareCenter);
        for (int i=1;i<=Bomb.power;i++){
            if(checkUp(this.centerX, this.centerY-i*StaticObject.object_height)&&UP){
                if (i==Bomb.power){
                    imageView_flareEnding[0] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flare_ending.png")));
                    imageView_flareEnding[0].setLayoutX(this.centerX);
                    imageView_flareEnding[0].setLayoutY(this.centerY-i*StaticObject.object_height);
                    root.getChildren().add(imageView_flareEnding[0]);
                }
                else{
                    imageView_flareBody[0][i] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flare_body.png")));
                    imageView_flareBody[0][i].setLayoutX(this.centerX);
                    imageView_flareBody[0][i].setLayoutY(this.centerY-i*StaticObject.object_height);
                    root.getChildren().add(imageView_flareBody[0][i]);
                }
                    
            }
            else
                UP=false;
            if(checkDown(this.centerX, this.centerY+i*StaticObject.object_height)&&DOWN){
                if (i==Bomb.power){
                    imageView_flareEnding[1] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flare_ending.png")));
                    imageView_flareEnding[1].setLayoutX(this.centerX);
                    imageView_flareEnding[1].setLayoutY(this.centerY+i*StaticObject.object_height);
                    imageView_flareEnding[1].setRotate(180);
                    root.getChildren().add(imageView_flareEnding[1]);
                }
                else{
                    imageView_flareBody[1][i] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flare_body.png")));
                    imageView_flareBody[1][i].setLayoutX(this.centerX);
                    imageView_flareBody[1][i].setLayoutY(this.centerY+i*StaticObject.object_height);
                    root.getChildren().add(imageView_flareBody[1][i]);
                }
                    
            }
            else
                DOWN=false;
            if(checkRight(this.centerX+i*StaticObject.object_width, this.centerY)&&RIGHT){
                if (i==Bomb.power){
                    imageView_flareEnding[2] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flare_ending.png")));
                    imageView_flareEnding[2].setLayoutX(this.centerX+i*StaticObject.object_width);
                    imageView_flareEnding[2].setLayoutY(this.centerY);
                    imageView_flareEnding[2].setRotate(90);
                    root.getChildren().add(imageView_flareEnding[2]);
                }
                else{
                    imageView_flareBody[2][i] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flare_body.png")));
                    imageView_flareBody[2][i].setLayoutX(this.centerX+i*StaticObject.object_width);
                    imageView_flareBody[2][i].setLayoutY(this.centerY);
                    imageView_flareBody[2][i].setRotate(90);
                    root.getChildren().add(imageView_flareBody[2][i]);
                }
                    
            }
            else
                RIGHT=false;
            if(checkLeft(this.centerX-i*StaticObject.object_width, this.centerY)&&LEFT){
                if (i==Bomb.power){
                    imageView_flareEnding[3] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flare_ending.png")));
                    imageView_flareEnding[3].setLayoutX(this.centerX-i*StaticObject.object_width);
                    imageView_flareEnding[3].setLayoutY(this.centerY);
                    imageView_flareEnding[3].setRotate(270);
                    root.getChildren().add(imageView_flareEnding[3]);
                }
                else{
                    imageView_flareBody[3][i] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flare_body.png")));
                    imageView_flareBody[3][i].setLayoutX(this.centerX-i*StaticObject.object_width);
                    imageView_flareBody[3][i].setLayoutY(this.centerY);
                    imageView_flareBody[3][i].setRotate(90);
                    root.getChildren().add(imageView_flareBody[3][i]);
                }
                    
            }
            else
                LEFT=false;
        }
    }
    public boolean checkUp(int pointX, int pointY){
        int locationRow = (pointY/StaticObject.object_height);
        int locationColumn = pointX/StaticObject.object_width;
        char tem = data.dataMatrix[locationRow][locationColumn];
        if (tem=='#'||tem=='b')
            return false;
        else
            return true;
    }
    public boolean checkDown(int pointX, int pointY){
        int locationRow = pointY/StaticObject.object_height;
        int locationColumn = pointX/StaticObject.object_width;
        char tem = data.dataMatrix[locationRow][locationColumn];
        if (tem=='#'||tem=='b')
            return false;
        else
            return true;
    }
    public boolean checkRight(int pointX, int pointY){
        int locationRow = pointY/StaticObject.object_height;
        int locationColumn = pointX/StaticObject.object_width;
        char tem = data.dataMatrix[locationRow][locationColumn];
        if (tem=='#'||tem=='b')
            return false;
        else
            return true;
    }
    public boolean checkLeft(int pointX, int pointY){
        int locationRow = pointY/StaticObject.object_height;
        int locationColumn = pointX/StaticObject.object_width;
        char tem = data.dataMatrix[locationRow][locationColumn];
        if (tem=='#'||tem=='b')
            return false;
        else
            return true;
    }

}
