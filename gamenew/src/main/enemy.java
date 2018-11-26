/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import static main.bomber.x;
import static main.bomber.y;
import java.util.Random;
import static main.PaintMap.arr;
/**
 *
 * @author Administrator
 */
public class enemy extends JPanel{
     Toolkit t=Toolkit.getDefaultToolkit();
    int localeX=45;
    int localeY=315;
     public void paintdown(Graphics g){
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\enemy_down.png");
                     g.drawImage(a, localeX,localeY,this);

    }
     public void paintup(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\enemy_up.png");
        g.drawImage(a,localeX,localeY,this);

    }
    public void paintleft(Graphics g){
        
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\enemy_left.png");
        g.drawImage(a,localeX,localeY,this);
 
    }
    public void paintright(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\enemy_right.png");
        g.drawImage(a,localeX,localeY,this);
 
    }
    public  int status=1;
    Random rd=new Random();
    public void enemyrun(){
      int std=rd.nextInt(9);
       
       
       
       if(status==1){
       int dem=0;
          int dem1=0;
            for(int i=0;i<15;i++){
                for(int j=0;j<11;j++){
                    if(arr[i][j]=='*'||arr[i][j]=='#'|| arr[i][j]=='b'){
                        int a=i*45;
                        if(a-localeX>=45){
                            dem++;
                        }
                        int b=j*45;
                        if((a-localeX>=45&&Math.abs(localeY-b)>=45)||(a-localeX)>45&& localeY-b==0){
                            dem1++;
                        }
                       }
                }
            }
        if(dem==dem1&& localeX<630){
               localeX=localeX+3;
            }
            
             if( localeX==585 )
                status=3;
            
         
        } //phai
       if(status==2){
       int dem=0;
       int dem1=0;
            for(int i=0;i<=15;i++){
                for(int j=0;j<=11;j++){
                    if(arr[i][j]=='*'||arr[i][j]=='#' || arr[i][j]=='b'){
                        int a=i*45;
                        if(localeX-a>=45){
                            dem++;
                        }
                         int b=j*45;
                        if((localeX-a>=45 &&Math.abs(localeY-b)>=45)||(localeX-a)>45&& localeY-b==0){
                            dem1++;
                        }
                       }
                }
            }
            
            if(dem==dem1&& localeX>=0){
               localeX=localeX-3;
            }
            if(localeX==45 ){
               status=4;
            }
       }    //trai
       if(status==3){
            int dem=0;
           int dem1=0;
            for(int i=0;i<15;i++){
                for(int j=0;j<11;j++){
                    if(arr[i][j]=='*'|| arr[i][j]=='#' || arr[i][j]=='b'  ){
                        int a=i*45;
                        int b=j*45;
                        if(localeY-b>=45){
                            dem++;
                        }
                        if((localeY-b>=45 && Math.abs(localeX-a)>=45)||(localeY-b)>45 && localeX-a==0){
                            dem1++;
                        }
                       }
                }
            }
            
            if(dem==dem1 && localeY>=45){
                localeY=localeY-3;
            } 
           
            
            if( localeY==225 )
                status=2;
            
       }//len;
       if(status==4) {
        int dem=0;
           int dem1=0;
            for(int i=0;i<15;i++){
                for(int j=0;j<11;j++){
                    if(arr[i][j]=='*'||arr[i][j]=='#' || arr[i][j]=='b'){
                        int b=j*45;
                        int a=i*45;
                        if(b-localeY>=45){
                            dem++;
                        }
                        if((b-localeY>=45 && Math.abs(localeX-a)>=45)||(b-localeY)>45&& localeX-a==0){
                            dem1++;
                        }
                       }
                }
            }
            
            if(dem==dem1&& localeY<=405){
                localeY=localeY+3;
            }
            if(dem==dem1&& localeY==405){
                status=1;
            }
       } //xuong
        
        
    }
}
