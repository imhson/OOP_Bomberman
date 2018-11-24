/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

/**
 *
 * @author Hoangson
 */
public class checkContact {
    public static boolean checkContact (int X1, int Y1, int X2, int Y2){
        if (Math.abs(X2-X1)<StaticObject.object_width&&Math.abs(Y2-Y1)<StaticObject.object_height){
            return true;
        }
        else
            return false;
    }
}
