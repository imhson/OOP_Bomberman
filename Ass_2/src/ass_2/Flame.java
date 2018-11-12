/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import java.util.ArrayList;
import java.util.Date;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Hoangson
 */
public class Flame {
    int centerX;
    int centerY;
    ImageView imageView_flameCenter = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flame_center.png")));
    ImageView[] imageView_flameEnding = new ImageView[4];
    ImageView[][] imageView_flameBody= new ImageView[4][5];

    public void setFlame(int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }
    
    public ArrayList<ImageView> printFlame(){
        boolean UP=true,DOWN=true,RIGHT=true,LEFT=true;
        ArrayList<ImageView> arrayNode = new ArrayList<>();
        imageView_flameCenter.setLayoutX(centerX);
        imageView_flameCenter.setLayoutY(centerY);
        arrayNode.add(imageView_flameCenter);
        for (int i=1;i<=Bomb.power;i++){
            if(UP){
            if(checkUp(this.centerX, this.centerY-i*StaticObject.object_height)){
                if (i==Bomb.power){
                    imageView_flameEnding[0] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flame_ending.png")));
                    imageView_flameEnding[0].setLayoutX(this.centerX);
                    imageView_flameEnding[0].setLayoutY(this.centerY-i*StaticObject.object_height);
                    arrayNode.add(imageView_flameEnding[0]);
                }
                else{
                    imageView_flameBody[0][i] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flame_body.png")));
                    imageView_flameBody[0][i].setLayoutX(this.centerX);
                    imageView_flameBody[0][i].setLayoutY(this.centerY-i*StaticObject.object_height);
                    arrayNode.add(imageView_flameBody[0][i]);
                }
                    
            }
            else
                UP=false;
            }
            if(DOWN){
            if(checkDown(this.centerX, this.centerY+i*StaticObject.object_height)){
                if (i==Bomb.power){
                    imageView_flameEnding[1] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flame_ending.png")));
                    imageView_flameEnding[1].setLayoutX(this.centerX);
                    imageView_flameEnding[1].setLayoutY(this.centerY+i*StaticObject.object_height);
                    imageView_flameEnding[1].setRotate(180);
                    arrayNode.add(imageView_flameEnding[1]);
                }
                else{
                    imageView_flameBody[1][i] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flame_body.png")));
                    imageView_flameBody[1][i].setLayoutX(this.centerX);
                    imageView_flameBody[1][i].setLayoutY(this.centerY+i*StaticObject.object_height);
                    imageView_flameBody[1][i].setRotate(180);
                    arrayNode.add(imageView_flameBody[1][i]);
                }
                    
            }
            else
                DOWN=false;
            }
            if(RIGHT){
            if(checkRight(this.centerX+i*StaticObject.object_width, this.centerY)){
                if (i==Bomb.power){
                    imageView_flameEnding[2] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flame_ending.png")));
                    imageView_flameEnding[2].setLayoutX(this.centerX+i*StaticObject.object_width);
                    imageView_flameEnding[2].setLayoutY(this.centerY);
                    imageView_flameEnding[2].setRotate(90);
                    arrayNode.add(imageView_flameEnding[2]);
                }
                else{
                    imageView_flameBody[2][i] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flame_body.png")));
                    imageView_flameBody[2][i].setLayoutX(this.centerX+i*StaticObject.object_width);
                    imageView_flameBody[2][i].setLayoutY(this.centerY);
                    imageView_flameBody[2][i].setRotate(90);
                    arrayNode.add(imageView_flameBody[2][i]);
                }
                    
            }
            else
                RIGHT=false;
            }
            if(LEFT){
            if(checkLeft(this.centerX-i*StaticObject.object_width, this.centerY)){
                if (i==Bomb.power){
                    imageView_flameEnding[3] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flame_ending.png")));
                    imageView_flameEnding[3].setLayoutX(this.centerX-i*StaticObject.object_width);
                    imageView_flameEnding[3].setLayoutY(this.centerY);
                    imageView_flameEnding[3].setRotate(270);
                    arrayNode.add(imageView_flameEnding[3]);
                }
                else{
                    imageView_flameBody[3][i] = new ImageView(new Image(getClass().getResourceAsStream("/image_package/flame_body.png")));
                    imageView_flameBody[3][i].setLayoutX(this.centerX-i*StaticObject.object_width);
                    imageView_flameBody[3][i].setLayoutY(this.centerY);
                    imageView_flameBody[3][i].setRotate(270);
                    arrayNode.add(imageView_flameBody[3][i]);
                }
                    
            }
            else
                LEFT=false;
            }
        }
        return arrayNode;
    }
    public void setVisible(boolean visible){
        imageView_flameCenter.setVisible(visible);
        for (int i=0;i<=3;i++){
            for (int j=0;j<=3;j++){
                if (imageView_flameBody[i][j]!=null){
                    imageView_flameBody[i][j].setVisible(visible);
                    if(!visible){
                        int row = (int)imageView_flameBody[i][j].getLayoutY()/StaticObject.object_height;
                        int col = (int)imageView_flameBody[i][j].getLayoutX()/StaticObject.object_width;
                        if (data.dataMatrix[row][col]=='*'){
                            data.dataNode[row][col].setVisible(false);
                            data.dataMatrix[row][col]=' ';
                        }
                    }
                }
            }
            if (imageView_flameEnding[i]!=null){
                imageView_flameEnding[i].setVisible(visible);
                    if(!visible){
                        int row = (int)imageView_flameEnding[i].getLayoutY()/StaticObject.object_height;
                        int col = (int)imageView_flameEnding[i].getLayoutX()/StaticObject.object_width;
                        if (data.dataMatrix[row][col]=='*'){
                            data.dataNode[row][col].setVisible(false);
                            data.dataMatrix[row][col]=' ';
                        }
                    }
            }
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
