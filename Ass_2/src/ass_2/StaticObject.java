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
                    {
                        int [] point ={(int)column*object_width,(int)row*object_height};
                        Grass grass = new Grass(point);
                        group.getChildren().add(grass.imageView_grass);
                    }
                    if (lineData.charAt(i)=='#'){
                        int [] point ={(int)column*object_width,(int)row*object_height};
                        Wall wall = new Wall(point);
                        data.dataNode[row][column] = wall.imageView_wall;
                        group.getChildren().add(data.dataNode[row][column]);
                        continue;
                    }
                    if (lineData.charAt(i)=='*'){
                        int [] point ={(int)column*object_width,(int)row*object_height};
                        Brick brick = new Brick(point);
                        data.dataNode[row][column] = brick.imageView_brick;
                        group.getChildren().add(data.dataNode[row][column]);
                        continue;
                    }
                    if (lineData.charAt(i)=='x'){
                        int [] point ={(int)column*object_width,(int)row*object_height};
                        Brick brick = new Brick(point);
                        data.dataNode[row][column] = brick.imageView_brick;
                        Portal portal = new Portal(point);
                        data.dataMatrix[row][column] = '*';
                        Portal.point = point;
                        group.getChildren().addAll(portal.imageView_portal, data.dataNode[row][column]);
                    }
                    if (lineData.charAt(i)=='s'){
                        int [] point ={(int)column*object_width,(int)row*object_height};
                        SpeedItem speedItem = new SpeedItem(point);
                        data.dataNode[row][column] = speedItem.imageView_SpeedItem;
                        group.getChildren().add(data.dataNode[row][column]);
                        continue;
                    }
                    if (lineData.charAt(i)=='f'){
                        int [] point ={(int)column*object_width,(int)row*object_height};
                        FlameItem flameItem = new FlameItem(point);
                        data.dataNode[row][column] = flameItem.imageView_FlameItem;
                        group.getChildren().add(data.dataNode[row][column]);
                        continue;
                    }
                    if (lineData.charAt(i)=='o'){
                        int [] point ={(int)column*object_width,(int)row*object_height};
                        BombItem bombItem = new BombItem(point);
                        data.dataNode[row][column] = bombItem.imageView_bombItem;
                        group.getChildren().add(data.dataNode[row][column]);
                        continue;
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
