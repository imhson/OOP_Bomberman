/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Hoangson
 */
public class Bomb extends StaticObject{
    int [] point;
    ArrayList<ImageView> arrNode;
    boolean isExplode=false;
    boolean isEnd = false;
    Flame flame = new Flame();
    public static int power=1;
    public long setTime;
    final static int delayExplosion = 3500;  //miliseconds
    ImageView imageView_bomb = new ImageView(new Image(getClass().getResourceAsStream("/image_package/bomb.png")));
    public Bomb(int[] point) {
        point[0]=((point[0]+object_width/2)/object_width)*object_width;
        point[1]=((point[1]+object_height/2)/object_height)*object_height;
        this.point=point;
        super.point=point;
        flame.centerX=point[0];
        this.flame.centerY=point[1];
        imageView_bomb.setLayoutX(point[0]);
        imageView_bomb.setLayoutY(point[1]);
    }

    public void setPoint(int[] point) {
        point[0]=((point[0]+object_width/2)/object_width)*object_width;
        point[1]=((point[1]+object_height/2)/object_height)*object_height;
        this.point = point;
        flame.centerX = point[0];
        flame.centerY = point[1];
        imageView_bomb.setLayoutX(point[0]);
        imageView_bomb.setLayoutY(point[1]);
    }
    
    public Bomb() {
    }
    
    public void explode(Pane root){
        arrNode= flame.printFlame();
        for (int i=0;i<arrNode.size();i++){
            root.getChildren().add(arrNode.get(i));
            if (data.dataMatrix[(int)arrNode.get(i).getLayoutY()/StaticObject.object_height][(int)arrNode.get(i).getLayoutX()/StaticObject.object_width]=='*'){
                data.dataMatrix[(int)arrNode.get(i).getLayoutY()/StaticObject.object_height][(int)arrNode.get(i).getLayoutX()/StaticObject.object_width]=' ';
                data.dataNode[(int)arrNode.get(i).getLayoutY()/StaticObject.object_height][(int)arrNode.get(i).getLayoutX()/StaticObject.object_width].setVisible(false);
            }
        }
        root.getChildren().remove(this.imageView_bomb);
    }

    public void setEnd(Pane root) {
        for (Node element:arrNode){
            root.getChildren().remove(element);
        }
    }
    
}
