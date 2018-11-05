/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Hoangson
 */
public class StaticObject {
    int [] point;
    ImageView imageView_staticObject;
    final static int object_width = 40;
    final static int object_height = 36;

    public StaticObject() {
    }

    public StaticObject(int[] point) {
        this.point = point;
    }
    public int loadFromMatrix (String path,Pane group){
        int level = 0;
        int column,row=-2;
        InputStream inpputStream = this.getClass().getResourceAsStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(inpputStream);
        try(BufferedReader br = new BufferedReader(inputStreamReader)){
            level = br.read();
            String lineData=br.readLine();
            while (lineData!=null){
                row++;
                for (int i=0;i<lineData.length();i++){
                    column=i;
                    data.dataMatrix[row][column] = lineData.charAt(i);
                    if (lineData.charAt(i)=='#'){
                        int [] point ={(int)column*object_width,(int)row*object_height};
                        Wall wall = new Wall(point);
                        group.getChildren().add(wall.imageView_wall);
                        continue;
                    }
                    if (lineData.charAt(i)=='*'){
                        int [] point ={(int)column*object_width,(int)row*object_height};
                        Brick brick = new Brick(point);
                        group.getChildren().add(brick.imageView_brick);
                        continue;
                    }
                    if (lineData.charAt(i)=='x'){
                        int [] point ={(int)column*object_width,(int)row*object_height};
                        Portal portal = new Portal(point);
                        group.getChildren().add(portal.imageView_portal);
                    }
                    else{
                        int [] point ={(int)column*object_width,(int)row*object_height};
                        Grass grass = new Grass(point);
                        group.getChildren().add(grass.imageView_grass);

                    }
                }
                lineData = br.readLine();
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return level;
    }
    
}
