/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
class PaintMap extends JPanel implements Runnable,ActionListener{
    Scanner sc;
    Toolkit t=Toolkit.getDefaultToolkit();  
    localMap local = null;
    public static char arr[][] = new char[100][100];
    Thread thread;
    
    int x=45;
    int y=45;
    
    public void setLocalX(int localX) {
        this.localX = localX;
    }

    public void setLocalY(int localY) {
        this.localY = localY;
    }

    public static void setVector(int vector) {
        PaintMap.vector = vector;
    }
    int localX;
    int localY;
    int X;
    int Y;
    public static int Go_Down=2;
    public static int Go_UP =3;
    public static int Go_Left=4;
    public static int Go_Right=5;
    public static int vector=0;
    public PaintMap(){
        addKeyListener(new attack());
        setFocusable(true);
        thread = new Thread(this);
        thread.start();
    }
    int dem=1;
    public void Paintmap(Graphics g) {    
      try{
       File file = new File("src\\main\\Map\\Map.txt");
       sc = new Scanner(file);
      }
      catch(FileNotFoundException e)
      { System.out.println(e);
      }    
           sc.hasNextLine() ;
           String line ;
           line = sc.nextLine();          
           for(int i=0 ; i<3; i++){
           sc.hasNextLine(); 
           String[] elements;
           elements = line.split("::"); 
           local= new localMap(elements[0],elements[1], elements[2]);
           }  int count=0;
            
           while(sc.hasNextLine()){
                 String line1 ;
               
                 line1 = sc.nextLine();
                 
                 for(int i=0;i<local.C;i++){      
                     if(dem==1){
                         System.out.print(arr[count][i]);
                     arr[count][i]=line1.charAt(i);
                     
                     }
                     if(arr[count][i]=='i')
                     {
                     Image I=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\item_shoe.png");
                     g.drawImage(I,(count)*45,i*45,this);
                     }
                     if(arr[count][i]=='t')
                     {
                     Image I=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\item_bombsize.png");
                     g.drawImage(I,(count)*45,i*45,this);
                     }
                     if(arr[count][i]=='#'){
                     Image I=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\box1.png");
                     g.drawImage(I,(count)*45,i*45,this);
                     }
                     if(arr[count][i]=='*'){
                     Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\box2.png");
                     g.drawImage(a,(count)*45,i*45,this);
                     }
                     
                 }
                 System.out.println("\n");
                 count++;
                 
            }
            dem++;
            System.out.println(count);
    }   
      public void PaintBackground(Graphics g){
       Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\backgroud_stone.png");
                     g.drawImage(a,0,0,this);
      }
      public void paintBoom(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\bomb.png");
        g.drawImage(a,X,Y,this);
        arr[X/45][Y/45]='b';
      }
      public void paintBoomBang(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\bombbang.png");
        g.drawImage(a,X-45,Y-45,this);}
      public void paintBoomBangdown(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\bombbang_down_1.png");
        g.drawImage(a,X,Y,this);}
      public void paintBoomBangleft(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\bombbang_left_1.png");
        g.drawImage(a,X-45,Y,this);}
       public void paintBoomBangright(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\bombbang_right_1.png");
        g.drawImage(a,X,Y,this);}
        public void paintBoomBangup(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\bombbang_up_2.png");
        g.drawImage(a,X,Y-45,this);
        }
        public void paintBoomBangdown2(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\bombbang_down_2.png");
        g.drawImage(a,X,Y,this);}
      public void paintBoomBangleft2(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\bombbang_left_2.png");
        g.drawImage(a,X-90,Y,this);}
       public void paintBoomBangright2(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\bombbang_right_2.png");
        g.drawImage(a,X,Y,this);}
        public void paintBoomBangup2(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\bombbang_up_1.png");
        g.drawImage(a,X,Y-90,this);
        }
        public void paintgameover(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\Gameover.png");
        g.drawImage(a,100,220,this);
        }
        public void paintgamewin(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\Youwin!.png");
        g.drawImage(a,100,220,this);
        }
        public void paintdeadbyenemy(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\dead.png");
        g.drawImage(a,ac.x,ac.y,this);
        }
        public void paintdeadbybomb(Graphics g){
       
        Image a=t.getImage("F:\\java\\gamenew\\src\\main\\picture\\bomber_dead.png");
        g.drawImage(a,ac.x,ac.y,this);
        }
        
    
      bomber ac =new bomber();
      enemy en= new enemy();
      int time=1;
      int soluong=1;
       public void Checkitemspeed(int x,int y,int X,int Y){
        if(x==X && y==Y){
            arr[5][2]=' ';
            Speed=5;
        }
       }
         public void Checkitembombsize(int x,int y,int X,int Y){
        if(x==X && y==Y){
            arr[7][2]=' ';
            bomlevel=2;
        }
       }
       checkdead check = new checkdead();
       int gameover1=0;
       int gameover2=0;
       int win=0;
       int exit=0;
       int bomlevel=1;
      public void xulinomno(Graphics g){
          if(arr[(X/45)][Y/45+1]=='#' && arr[(X/45)][Y/45-1]=='#'){ 
              if(bomlevel==1)
              { paintBoomBangleft(g);
                paintBoomBangright(g);}
              if(bomlevel==2)
              { paintBoomBangleft2(g);
                paintBoomBangright2(g);}
          
          }   
                
          if(arr[(X/45)][Y/45+1]==' ' && arr[(X/45)][Y/45-1]==' ' && arr[(X/45+1)][Y/45]==' ' && arr[(X/45-1)][Y/45]==' '){ 
              if(bomlevel==1)
              {paintBoomBangleft(g);
              paintBoomBangright(g);
              paintBoomBangup(g);
              paintBoomBangdown(g);}
               if(bomlevel==2)
              {paintBoomBangleft2(g);
              paintBoomBangright2(g);
              paintBoomBangup2(g);
              paintBoomBangdown2(g);}
          }
           if( arr[(X/45+1)][Y/45]=='#' && arr[(X/45-1)][Y/45]=='#'){ 
               if(bomlevel==1){ 
               paintBoomBangup(g);
               paintBoomBangdown(g);
               }
                if(bomlevel==2){ 
               paintBoomBangup2(g);
               paintBoomBangdown2(g);
               }
           }
           if(arr[(X/45)][Y/45+1]==' ' &&  arr[(X/45)][Y/45-1]=='#' && arr[(X/45+1)][Y/45]==' ' && arr[(X/45-1)][Y/45]==' '){ 
               if(bomlevel==1){
               paintBoomBangleft(g);
               paintBoomBangright(g);
               paintBoomBangdown(g);
               }
               if(bomlevel==2){
               paintBoomBangleft2(g);
               paintBoomBangright2(g);
               paintBoomBangdown2(g);
               }
            }
           if((arr[(X/45)][Y/45+1]=='*' || arr[(X/45)][Y/45+1]=='i'||arr[(X/45)][Y/45+1]=='t') &&  arr[(X/45)][Y/45-1]=='#' && arr[(X/45+1)][Y/45]==' ' && arr[(X/45-1)][Y/45]==' '){ 
             if(bomlevel==1){
               paintBoomBangleft(g);
              paintBoomBangright(g);
               paintBoomBangdown(g);}
             if(bomlevel==2){
               paintBoomBangleft2(g);
              paintBoomBangright2(g);
               paintBoomBangdown2(g);}
            if(X/45==5 && Y/45+1==2)
               arr[(X/45)][Y/45+1]='i';
            else if(X/45==7 && Y/45+1==2)
               arr[(X/45)][Y/45+1]='t';
            else 
            {
                arr[(X/45)][Y/45+1]=' ';
            }
         
          }
           
            if(arr[(X/45)][Y/45+1]=='*' && arr[(X/45)][Y/45-1]==' ' && arr[(X/45+1)][Y/45]==' ' && arr[(X/45-1)][Y/45]==' '){ 
              if(bomlevel==1){
              paintBoomBangleft(g);
              paintBoomBangright(g);
              paintBoomBangup(g);
              paintBoomBangdown(g);}
               if(bomlevel==2){
              paintBoomBangleft2(g);
              paintBoomBangright2(g);
              paintBoomBangup2(g);
              paintBoomBangdown2(g);}
              arr[(X/45)][Y/45+1]=' ';
          }
             if(arr[(X/45)][Y/45+1]=='#' &&  arr[(X/45)][Y/45-1]==' ' && arr[(X/45+1)][Y/45]==' ' && arr[(X/45-1)][Y/45]==' '){ 
             if(bomlevel==1){
                 paintBoomBangleft(g);
              paintBoomBangright(g);
               paintBoomBangup(g);}
             if(bomlevel==2){
                 paintBoomBangleft2(g);
              paintBoomBangright2(g);
               paintBoomBangup2(g);}
               
              }
             if(arr[(X/45)][Y/45+1]==' ' &&  arr[(X/45)][Y/45-1]=='*' && arr[(X/45+1)][Y/45]==' ' && arr[(X/45-1)][Y/45]==' '){ 
             if(bomlevel==1){
                 paintBoomBangleft(g);
              paintBoomBangright(g);
               paintBoomBangup(g);}
              if(bomlevel==2){
                 paintBoomBangleft2(g);
              paintBoomBangright2(g);
               paintBoomBangup2(g);}
               arr[(X/45)][Y/45-1]=' ';
               
              }
              if(arr[(X/45)][Y/45+1]=='#' &&  arr[(X/45)][Y/45-1]=='*' && arr[(X/45+1)][Y/45]==' ' && arr[(X/45-1)][Y/45]==' '){ 
                if(bomlevel==1){
                  paintBoomBangleft(g);
              paintBoomBangright(g);
               paintBoomBangup(g);}
                 if(bomlevel==2){
                  paintBoomBangleft2(g);
              paintBoomBangright2(g);
               paintBoomBangup2(g);}
               arr[(X/45)][Y/45-1]=' ';
              }
            if(arr[(X/45)][Y/45+1]=='*' && (arr[(X/45)][Y/45-1]=='*' || arr[(X/45)][Y/45-1]=='i' || arr[(X/45)][Y/45-1]=='t')  && arr[(X/45+1)][Y/45]==' ' && arr[(X/45-1)][Y/45]==' '){ 
              if(bomlevel==1){
              paintBoomBangleft(g);
              paintBoomBangright(g);
              paintBoomBangup(g);
              paintBoomBangdown(g);}
              if(bomlevel==2){
              paintBoomBangleft2(g);
              paintBoomBangright2(g);
              paintBoomBangup2(g);
              paintBoomBangdown2(g);}
              arr[(X/45)][Y/45+1]=' ';
              arr[(X/45)][Y/45-1]=' ';
          }
           
      }
      public void paint(Graphics g){
       PaintBackground(g);
       Paintmap(g);
        
       if(vector!=0 && Y!=0 ){
           if(time<60)
           {   
               paintBoom(g);   
            
           }
            
           if(time>=61 && time<70)
           {   
           
               xulinomno(g);
                arr[X/45][Y/45]=' ';
               
           }
          
            if(time>=61 && time<70)
            {   
                if(check.checkdeadbybomb(ac.x, ac.y, X, Y,bomlevel)==true)
                {   gameover2=1;
                    if(gameover2==1)
                {   paintdeadbybomb(g);
                     paintgameover(g);
                     
                }
                }
                if(ced.enemydiebybomb(en.localeX, en.localeY, X, Y,bomlevel)== true)
                 {   win=1;
                    if(win==1)
                {   paintgamewin(g);
                         
                }
                }
            }
        } 
       
       if(vector==0)
           ac.paintdown(g);
        if(vector==2)
       {   
           ac.paintdown(g);
       }
      else if(vector==3)
       {   
            ac.paintup(g);
       }
      else  if(vector==4)
       {   
            ac.paintleft(g);
           
       }
      else  if(vector==5)
      {    
            ac.paintright(g);
       }
       if(en.status==0){
           en.paintdown(g);
       }
        if(en.status==1){
           en.paintright(g);
       } 
        if(en.status==2){
           en.paintleft(g);
       } 
        if(en.status==3){
           en.paintup(g);
       } 
        if(en.status==4){
           en.paintdown(g);
       }
        
         
         if(check.checkdeadbyenemy(ac.x, ac.y, en.localeX, en.localeY)== true )
        {   
           gameover1=1;
            if(gameover1==1)
         {
             paintdeadbyenemy(g);
             paintgameover(g);
             
             
         }
        }
         
         
      }
    checkenemydie ced = new checkenemydie();
    public void run() {
        while(true){
         en.enemyrun();
        if(gameover1==1){
            exit++;
        }
        if(gameover2==1){
            exit++;
        }
        if(win==1){
            exit++;
            en.status=0;
        }
        if(exit==50){
            System.exit(0);
        }
         System.out.println(en.localeX + " "+ en.localeY);
          System.out.println(ac.x + " "+ ac.y);
        if(vector!=0  )
        {   soluong=0;
            if(time<70)
            {   
                time++;
                System.out.println(X/45 +" "+ (Y/45+1));
            }
            if(time==70)
           { soluong=1;
            
           }
        
        } 
         if(X/45==5 && Y/45+1==2){
            Checkitemspeed(ac.x/45, ac.y/45, X/45, Y/45+1);
        }
         if(X/45==7 && Y/45+1==2){
            Checkitembombsize(ac.x/45, ac.y/45, X/45, Y/45+1);
        }
       
        if(vector==0){ac.x=0;ac.y=45;
        repaint();
        }
       else if(vector==3  ){
           repaint();
          int dem=0;
           int dem1=0;
            for(int i=0;i<15;i++){
                for(int j=0;j<11;j++){
                    if(arr[i][j]=='*'|| arr[i][j]=='#' || arr[i][j]=='b'  ){
                        int a=i*45;
                        int b=j*45;
                        if(ac.y-b>=45){
                            dem++;
                        }
                        if((ac.y-b>=45 && Math.abs(ac.x-a)>=45)||(ac.y-b)>45 && ac.x-a==0){
                            dem1++;
                        }
                       }
                }
            }
            if(dem==dem1 && ac.y>45){
                ac.y=ac.y+localY;
            }
                       }
       else if(vector==2 ){ 
           repaint();
             int dem=0;
           int dem1=0;
            for(int i=0;i<15;i++){
                for(int j=0;j<11;j++){
                    if(arr[i][j]=='*'||arr[i][j]=='#' || arr[i][j]=='b'){
                        int b=j*45;
                        int a=i*45;
                        if(b-ac.y>=45){
                            dem++;
                        }
                        if((b-ac.y>=45 && Math.abs(ac.x-a)>=45)||(b-ac.y)>45&& ac.x-a==0){
                            dem1++;
                        }
                       }
                }
            }
            
            if(dem==dem1&& ac.y<450){
                ac.y=ac.y+localY;
            }
           
           
        }
       else if(vector==4 && x!=0) {
           repaint();
       int dem=0;
       int dem1=0;
            for(int i=0;i<=15;i++){
                for(int j=0;j<=11;j++){
                    if(arr[i][j]=='*'||arr[i][j]=='#' || arr[i][j]=='b'){
                        int a=i*45;
                        if(ac.x-a>=45){
                            dem++;
                        }
                         int b=j*45;
                        if((ac.x-a>=45&&Math.abs(ac.y-b)>=45)||(ac.x-a)>45&& ac.y-b==0){
                            dem1++;
                        }
                       }
                }
            }
            
            if(dem==dem1&& ac.x>0){
                ac.x=ac.x+localX;
            }
       }
       else if(vector==5 ){
           repaint();
         int dem=0;
          int dem1=0;
            for(int i=0;i<15;i++){
                for(int j=0;j<11;j++){
                    if(arr[i][j]=='*'||arr[i][j]=='#'|| arr[i][j]=='b'){
                        int a=i*45;
                        if(a-ac.x>=45){
                            dem++;
                        }
                        int b=j*45;
                        if((a-ac.x>=45&&Math.abs(ac.y-b)>=45)||(a-ac.x)>45&& ac.y-b==0){
                            dem1++;
                        }
                       }
                }
            }
        if(dem==dem1&& ac.x<630){
                ac.x=ac.x+localX;
            }
        
       }
        try {
                thread.sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(PaintMap.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
}
public static int Speed=3; 
 private class attack extends KeyAdapter  {
    @Override
    public void keyPressed(KeyEvent e) { 
            if(e.getKeyCode()==KeyEvent.VK_UP){
                  setVector(Go_UP);
                setLocalY(-Speed);
                
              }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                 setVector(Go_Down);
                setLocalY(Speed);
              }
            if(e.getKeyCode()==KeyEvent.VK_LEFT){
                 setVector(Go_Left);
                setLocalX(-Speed);
              }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                  setVector(Go_Right);
                setLocalX(Speed);
            }
            if(e.getKeyCode()==KeyEvent.VK_SPACE && soluong==1){
                time=1;
                soluong=0;
               X=(ac.x/45)*45 ;
                Y=(ac.y/45)*45;
                System.out.println(X+ " "+Y);
                
               
            }
            if(e.getKeyCode()==KeyEvent.VK_SPACE  && exit==1){
                System.exit(0);
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
            if(e.getKeyCode()==KeyEvent.VK_UP){
                 vector=Go_UP;
                localY=0;
              }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                vector=Go_Down;
                localY=0;
              }
            if(e.getKeyCode()==KeyEvent.VK_LEFT){
                vector=Go_Left;
                localX=0;
              }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                 vector=Go_Right;
                  localX=0;
            }    
              if(e.getKeyCode()==KeyEvent.VK_SPACE && soluong==1){
                X=(ac.x/45)*45 ;
                Y=(ac.y/45)*45;
                 
                  setVector(6);
               
            }
              if(e.getKeyCode()==KeyEvent.VK_SPACE  && exit==1){
               
            }
    }
    };
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
