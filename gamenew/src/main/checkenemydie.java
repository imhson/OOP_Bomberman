/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Administrator
 */
public class checkenemydie {
    public boolean enemydiebybomb(int x,int y,int X,int Y,int level){
       if(level==1){
        if(x<X+90 && x>X-90 && y<Y+90 && y>Y-90){
            return true;
        }}
        if(level==2){
        if(x<X+90+45 && x>X-90-45 && y<Y+90+45 && y>Y-90-45){
            return true;
        }}
        return false;
    }
}   
