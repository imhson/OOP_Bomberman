/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import javafx.scene.image.ImageView;

/**
 *
 * @author Hoangson
 */
public class DynamicObject {
    int[] point;
    ImageView imageView_dynamicObject;
    public int SPEED;
    public DynamicObject() {
    }

    public DynamicObject(int[] point) {
        this.point = point;
    }

    public DynamicObject(int SPEED) {
        this.SPEED = SPEED;
    }
    
    public boolean check_Up (int pointX,int pointY){
        int locationRow1 = (int) ((pointY-SPEED)/StaticObject.object_height);
        int locationColumn1 = (int) ((pointX)/StaticObject.object_width);
        char tem1 = data.dataMatrix[locationRow1][locationColumn1];
        int locationRow2 = (int) ((pointY-SPEED)/StaticObject.object_height);
        int locationColumn2 = (int) ((pointX+StaticObject.object_width-1)/StaticObject.object_width);
        char tem2 = data.dataMatrix[locationRow2][locationColumn2];
        if ((tem1=='#'||tem1=='*'||tem1=='b')||(tem2=='#'||tem2=='*'||tem2=='b'))
            return false;
        return true;
    }
    public boolean check_Down (int pointX, int pointY){
        int locationRow1 = (int) ((pointY+SPEED+StaticObject.object_height-1)/StaticObject.object_height);
        int locationColumn1 = (int) ((pointX)/StaticObject.object_width);
        char tem1 = data.dataMatrix[locationRow1][locationColumn1];
        int locationRow2 = (int) ((pointY+SPEED+StaticObject.object_height-1)/StaticObject.object_height);
        int locationColumn2 = (int) ((pointX+StaticObject.object_width-1)/StaticObject.object_width);
        char tem2 = data.dataMatrix[locationRow2][locationColumn2];
        if ((tem1=='#'||tem1=='*'||tem1=='b')||(tem2=='#'||tem2=='*'||tem2=='b'))
            return false;
        return true;
    }
    public boolean check_Left (int pointX,int pointY){
        int locationRow1 = (int) ((pointY)/StaticObject.object_height);
        int locationColumn1 = (int) ((pointX-SPEED)/StaticObject.object_width);
        char tem1 = data.dataMatrix[locationRow1][locationColumn1];
        int locationRow2 = (int) ((pointY+StaticObject.object_height-1)/StaticObject.object_height);
        int locationColumn2 = (int) ((pointX-SPEED)/StaticObject.object_width);
        char tem2 = data.dataMatrix[locationRow2][locationColumn2];
        if ((tem1=='#'||tem1=='*'||tem1=='b')||(tem2=='#'||tem2=='*'||tem2=='b'))
            return false;
        return true;
    }
    public boolean check_Right (int pointX,int pointY){
        int locationRow1 = (int) ((pointY)/StaticObject.object_height);
        int locationColumn1 = (int) ((pointX+SPEED+StaticObject.object_width-1)/StaticObject.object_width);
        char tem1 = data.dataMatrix[locationRow1][locationColumn1];
        int locationRow2 = (int) ((pointY+StaticObject.object_height-1)/StaticObject.object_height);
        int locationColumn2 = (int) ((pointX+SPEED+StaticObject.object_width-1)/StaticObject.object_width);
        char tem2 = data.dataMatrix[locationRow2][locationColumn2];
        if ((tem1=='#'||tem1=='*'||tem1=='b')||(tem2=='#'||tem2=='*'||tem2=='b'))
            return false;
        return true;
    }
    
}
