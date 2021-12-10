
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */

class Gulle{
    
    private int x;
    
    private int y;

    public Gulle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}

public class Oyun extends JPanel implements ActionListener,KeyListener {
    Timer timer = new Timer(5,this);
    
    Random random = new Random();
    
    private int sure = 0;
    
    private ArrayList<Gulle> gulleler = new ArrayList<Gulle>();
    
    private int gulle_sinir = 20;
    
    private int gulle_sayisi = 20;// 10 a cekilecek
    
    private int harcanan_gulle = 0;
    
    private int doldurma_suresi = 0;
   // private ArrayList<gulleNpc> gulle_npc = new ArrayList<gulleNpc>();
    
    
    static int gemi_sag = 1;
    
    static int gemi_sol = 0;
    
    static int gemi_asagi = 0;
    
    static int gemi_yukari = 0;
    
    private BufferedImage image;
    
    private BufferedImage image2;
    
    private BufferedImage image3;
    
    private BufferedImage image4;
    
    private BufferedImage d_image;
    
    private BufferedImage d_image2;
    
    private BufferedImage d_image3;
    
    private BufferedImage d2_image;
    
    private BufferedImage d2_image2;
    
    private BufferedImage d3_image;
    
    private BufferedImage d3_image2;
    
    private BufferedImage image_can;
    
    private BufferedImage image_seviye;
    
    private BufferedImage image_gulle;
     
    private int gemiX=250;
    
    private int gemidirX=20;
    
    private int gemiY=400;
    
    private int gemidirY=20;
    
    
    private int gulledirX = 10;
    
    private int gulledirY = 10;
    
    
    static int d_gemi_sag = 1;
    
    static int d_gemi_sol = 0;
    
    private int d_gemiX=300;
    
    private int d_gemidirX=50;
    
    private int d_gemiY=50;
    
    private int d_gemi_can = 100;
    
    private int d_gemi2X =200;
    
    private int d_gemi2dirX=70;
    
    private int d_gemi2Y = 150;
    
    private int d2_gemi_sag = 1;
    
    private int d2_gemi_sol = 0;
    
    private int d_gemi2_can = 120;
    
    
    // np3 özellikler
     private int d_gemi3X =500;
    
    private int d_gemi3dirX=70;
    
    private int d_gemi3Y = 250;
    
    private int d3_gemi_sag = 1;
    
    private int d3_gemi_sol = 0;
    
    private int d_gemi3_can = 160;
    // np3 özellikler 
    
    static int npc1_patlama = 0;
    
    static int npc2_patlama = 0;
    
    static int npc3_patlama = 0;
    
    static int sayac = 0;
    
    static int sayac2 = 0; 
    
    static int sayac3 = 0;
    
    static int sayac_t = 0;// level2 bitirici
    
    static int sayac_t2 = 0;// level3 bitirici
    
    static int level = 1;
    
    static int dakika = 0;
    
   // private int d_gulledirY=5;
    
    public void gulle_ses(){
        
        AudioInputStream stream;
        try {
            stream = AudioSystem.getAudioInputStream(new File("ates.wav"));
            
            Clip clip = AudioSystem.getClip();
        
            clip.open(stream);
            clip.start();
        
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void level_gecildi_ses(){
        
        
    }
    
    // gecici olarak askida
    public void npc_patlama(){
        
         /*
        askıda
        
        if (level==1) {
            npc1_patlama = 1;
        }
        */
        AudioInputStream stream;
        try {
            stream = AudioSystem.getAudioInputStream(new File("patlama.wav"));
            
            Clip clip = AudioSystem.getClip();
        
            clip.open(stream);
            clip.start();
        
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void level1(){
        
        gemiX=250;
        gemiY=400;
        
        String mesaj = "Tebrikler! Tüm düşmanları yok ettin."+"\n"+
                       "Seviye 2 ' ye geçmek için OK ' a basınız.";
        JOptionPane.showMessageDialog(this,mesaj);
       //timer.start();
    }
    
    public void level2(){
        
       gemiX=250;
       gemiY=400;
       
        String mesaj = "Tebrikler! Tüm düşmanları yok ettin."+"\n"+
                       "Seviye 3 ' e geçmek için OK ' a basınız.";
        JOptionPane.showMessageDialog(this,mesaj);
        
        
    }
    
    public void level3(){
       gemiX=250;
       gemiY=400;
       
        String mesaj = "Tebrikler! Tüm düşmanları yok ettin."+"\n"+
                       "Seviye 4(Final Seviye) ' e geçmek için OK ' a basınız.";
        JOptionPane.showMessageDialog(this,mesaj);
        
    }
    
    public void finall(){
              
        String mesaj = "Tebrikler! Oyundaki tüm seviyeleri başarıyla bitirdin!";
        JOptionPane.showMessageDialog(this,mesaj);
        
    }    
    public boolean kontrolEt(){
        
        for(Gulle gulle : gulleler){
        
 
        if (new Rectangle(gulle.getX(),gulle.getY(),10,10).intersects(new Rectangle(d_gemiX,d_gemiY,d_image.getWidth(),d_image.getHeight()))) {
            // topun bulunduğu  x ve y ve 20 ye 20 yapıcaz 2 si çarpışınca true döncek
            // ifin içinde bir ateş ürettik bir de top ürettik 
            d_gemi_can-=20;
             gulleler.remove(gulle);
            if (d_gemi_can==0) {
             npc1_patlama=1;
            
            return true;
            }
           
        }
      
        else if(new Rectangle(gulle.getX(),gulle.getY(),10,10).intersects(new Rectangle(d_gemiX,d_gemiY,d_image2.getWidth(),d_image2.getHeight()))) {
            // topun bulunduğu  x ve y ve 20 ye 20 yapıcaz 2 si çarpışınca true döncek
            // ifin içinde bir ateş ürettik bir de top ürettik 
            d_gemi_can-=20;
             gulleler.remove(gulle);
            if (d_gemi_can==0) {
             npc1_patlama=1;
             
             
            
             
            return true;
            }
        }
        else if(new Rectangle(gulle.getX(),gulle.getY(),10,10).intersects(new Rectangle(d_gemiX,d_gemiY,d_image3.getWidth(),d_image3.getHeight()))) {
            // topun bulunduğu  x ve y ve 20 ye 20 yapıcaz 2 si çarpışınca true döncek
            // ifin içinde bir ateş ürettik bir de top ürettik 
             d_gemi_can-=20;
              gulleler.remove(gulle);
            if (d_gemi_can==0) {
             npc1_patlama=1;
             
             
             
            return true;
            }
        }
        
    }
          return false;
    }
    
    public boolean kontrolEt2(){
        
        for(Gulle gulle : gulleler){
              if (new Rectangle(gulle.getX(),gulle.getY(),10,10).intersects(new Rectangle(d_gemi2X,d_gemi2Y,d2_image.getWidth(),d2_image.getHeight()))) {
            // topun bulunduğu  x ve y ve 20 ye 20 yapıcaz 2 si çarpışınca true döncek
            // ifin içinde bir ateş ürettik bir de top ürettik 
            d_gemi2_can-=20;
            gulleler.remove(gulle);
                  if (d_gemi2_can == 0) {
                      npc2_patlama=1;
                      return true;
                  }
        }
         else if (new Rectangle(gulle.getX(),gulle.getY(),10,10).intersects(new Rectangle(d_gemi2X,d_gemi2Y,d2_image.getWidth(),d2_image2.getHeight()))) {
            // topun bulunduğu  x ve y ve 20 ye 20 yapıcaz 2 si çarpışınca true döncek
            // ifin içinde bir ateş ürettik bir de top ürettik 
            d_gemi2_can-=20;
            gulleler.remove(gulle);
                  if (d_gemi2_can == 0) {
                      npc2_patlama=1;
                      return true;
            
                  } 
        }
            
            
        }
        return false;
    }
    
    public boolean kontrolEt3(){
        
        for(Gulle gulle : gulleler){
              if (new Rectangle(gulle.getX(),gulle.getY(),10,10).intersects(new Rectangle(d_gemi3X,d_gemi3Y,d3_image.getWidth(),d3_image.getHeight()))) {
            // topun bulunduğu  x ve y ve 20 ye 20 yapıcaz 2 si çarpışınca true döncek
            // ifin içinde bir ateş ürettik bir de top ürettik 
            d_gemi3_can-=20;
            gulleler.remove(gulle);
                  if (d_gemi3_can == 0) {
                      npc3_patlama=1;
                      return true;
                  }
        }
         else if (new Rectangle(gulle.getX(),gulle.getY(),10,10).intersects(new Rectangle(d_gemi3X,d_gemi3Y,d3_image.getWidth(),d3_image2.getHeight()))) {
            // topun bulunduğu  x ve y ve 20 ye 20 yapıcaz 2 si çarpışınca true döncek
            // ifin içinde bir ateş ürettik bir de top ürettik 
            d_gemi3_can-=20;
            gulleler.remove(gulle);
                  if (d_gemi3_can == 0) {
                      npc3_patlama=1;
                      return true;
            
                  } 
        }
        }
        return false;
    } 
    public Oyun() {
        // oyuncu gemisi simgeleri
        try {
            image=ImageIO.read(new FileInputStream(new File("gemi_sag.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            image2=ImageIO.read(new FileInputStream(new File("gemi_sol.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
         
          try {
            image3=ImageIO.read(new FileInputStream(new File("gemi_yukari.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
          
           try {
            image4=ImageIO.read(new FileInputStream(new File("gemi_asagi.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           try {
            d_image=ImageIO.read(new FileInputStream(new File("d_gemi_sag.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
              try {
            d_image2=ImageIO.read(new FileInputStream(new File("d_gemi_sol.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
              
             try {
           d_image3=ImageIO.read(new FileInputStream(new File("d_gemi_asagi.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
              
             
            // npc 2 simgesi
               try {
            d2_image=ImageIO.read(new FileInputStream(new File("d_gemi_sag.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
              try {
            d2_image2=ImageIO.read(new FileInputStream(new File("d_gemi_sol.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
              
            // npc 3 simgesi
                  try {
            d3_image=ImageIO.read(new FileInputStream(new File("d_gemi_sag.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
              try {
            d3_image2=ImageIO.read(new FileInputStream(new File("d_gemi_sol.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }  
              
              // can simgesi eklenmesi
               try {
            image_can=ImageIO.read(new FileInputStream(new File("can.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
             // seviye simgesi eklenmesi
                 try {
            image_seviye=ImageIO.read(new FileInputStream(new File("seviye.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
            // gulle simgesi eklenmesi
                  try {
           image_gulle=ImageIO.read(new FileInputStream(new File("gulle.png")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
        setBackground(Color.WHITE);
        
        timer.start();
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        
       
        sure+=5;
        doldurma_suresi+=5;
        
        if (doldurma_suresi % 1200 == 0) {
            doldurma_suresi=0;
            if (gulle_sayisi >= gulle_sinir) {
                
            }
            else{
                gulle_sayisi++;
             
            }
        }
           
        for(Gulle gulle : gulleler){
            
            if (gulle.getY()<=0) {
                gulleler.remove(gulle);
            }
            
        }
        
        g.drawImage(image_seviye,10,28,image_seviye.getWidth()/2,image_seviye.getHeight()/2,this);
        g.drawString("Seviye : "+level,45,45);
        g.drawImage(image_gulle,6,60,image_gulle.getWidth()/7,image_gulle.getHeight()/7,this);
        g.drawString("Gülle : "+gulle_sayisi+"/"+gulle_sinir,45,80);
        if (level==1) {
           g.drawImage(image_can,d_gemiX-40,d_gemiY+65,image_can.getWidth()/15,image_can.getHeight()/15,this);
           g.drawString("Yaşam Puanı : "+d_gemi_can,d_gemiX-10, d_gemiY+80);
           
        if (kontrolEt()) {
            
            npc1_patlama = 1;
            sayac++;
         
        }

        if (npc1_patlama==0) {
            // npc hala hayatta
        if (d_gemi_sag == 1) {
         g.drawImage(d_image,d_gemiX,d_gemiY,d_image.getWidth(),d_image.getHeight(),this);
         
        }
        else if(d_gemi_sol == 1){
         g.drawImage(d_image2,d_gemiX,d_gemiY,d_image2.getWidth(),d_image2.getHeight(),this);   
        }     
        }
        else{
            if (sayac==1 && level==1) {
           
                try {
                   Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
                }  
                          
                level++;
                npc1_patlama = 0;
                d_gemi_can = 100; 
                  
                level1();
                for(Gulle gulle : gulleler)
                {
                    
                    gulleler.remove(gulle);
                    
                }
                 try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
                }              
               
            }
        }
        }
        else if(level==2){
           // level2();
           
            if (d_gemi_can > 0) {
        
           g.drawString("Yaşam Puanı : "+d_gemi_can,d_gemiX-10, d_gemiY+80);
           g.drawImage(image_can,d_gemiX-40,d_gemiY+65,image_can.getWidth()/15,image_can.getHeight()/15,this);
            }
            if (d_gemi2_can > 0) {
               g.drawString("Yaşam Puanı : "+d_gemi2_can,d_gemi2X-10, d_gemi2Y+80);
           g.drawImage(image_can,d_gemi2X-40,d_gemi2Y+65,image_can.getWidth()/15,image_can.getHeight()/15,this);
    
            }
        
            if (kontrolEt()) {
                
                npc1_patlama = 1;
                sayac++;
                
            }
            
            if (sayac == 1) {
             //  npc_patlama();
            }
            
            if (npc1_patlama==0){
            // npc hala hayatta
        if (d_gemi_sag == 1) {
         g.drawImage(d_image,d_gemiX,d_gemiY,d_image.getWidth(),d_image.getHeight(),this);
         
        }
        else if(d_gemi_sol == 1){
         g.drawImage(d_image2,d_gemiX,d_gemiY,d_image2.getWidth(),d_image2.getHeight(),this);   
        }     
        }
            if (kontrolEt2()) {
                
                npc2_patlama = 1;
                sayac2++;
            }
            
            if (sayac2 == 1) {
               // npc_patlama(); 
            }
             // npc 2 hayattaysa
        if (npc2_patlama==0) {
             if (d2_gemi_sag == 1) {
         g.drawImage(d2_image,d_gemi2X,d_gemi2Y,d2_image.getWidth(),d2_image.getHeight(),this);
         
        }
        else if(d2_gemi_sol == 1){
         g.drawImage(d2_image2,d_gemi2X,d_gemi2Y,d2_image2.getWidth(),d2_image2.getHeight(),this);   
        }  
        }
            if (npc2_patlama == 1 && npc1_patlama == 1) {
                sayac_t++;
            }
        
            if (npc2_patlama==1 && npc1_patlama==1 && sayac_t == 1) {
               
               level++;
               npc1_patlama = 0;
               npc2_patlama = 0;
               d_gemi_can = 100;
               d_gemi2_can = 120;
               level2();
               
               for(Gulle gulle : gulleler){
                   
                   gulleler.remove(gulle);
                   
               }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
                }  
                 
            }   
        }
        
        else if (level==3) {
              if (d_gemi_can > 0) {
                   
           g.drawString("Yaşam Puanı : "+d_gemi_can,d_gemiX-10, d_gemiY+80);
           g.drawImage(image_can,d_gemiX-40,d_gemiY+65,image_can.getWidth()/15,image_can.getHeight()/15,this);
            }
            if (d_gemi2_can > 0) {
           g.drawString("Yaşam Puanı : "+d_gemi2_can,d_gemi2X-10, d_gemi2Y+80);
           g.drawImage(image_can,d_gemi2X-40,d_gemi2Y+65,image_can.getWidth()/15,image_can.getHeight()/15,this);
    
            }
            if (d_gemi3_can >0) {
           g.drawString("Yaşam Puanı : "+d_gemi3_can,d_gemi3X-10, d_gemi3Y+80);
           g.drawImage(image_can,d_gemi3X-40,d_gemi3Y+65,image_can.getWidth()/15,image_can.getHeight()/15,this);
         
            }
            // npc1 vurulma
             if (kontrolEt()) {
                
                npc1_patlama = 1;
                sayac++;
                
            }
            
            if (npc1_patlama==0){
            // npc hala hayatta
        if (d_gemi_sag == 1) {
         g.drawImage(d_image,d_gemiX,d_gemiY,d_image.getWidth(),d_image.getHeight(),this);
         
        }
        else if(d_gemi_sol == 1){
         g.drawImage(d_image2,d_gemiX,d_gemiY,d_image2.getWidth(),d_image2.getHeight(),this);   
        }     
        }
            // npc2 vurulma
             if (kontrolEt2()) {
                
                npc2_patlama = 1;
                sayac2++;
                
            }           
             // npc 2 hayattaysa
        if (npc2_patlama==0) {
             if (d2_gemi_sag == 1) {
         g.drawImage(d2_image,d_gemi2X,d_gemi2Y,d2_image.getWidth(),d2_image.getHeight(),this);
         
        }
        else if(d2_gemi_sol == 1){
         g.drawImage(d2_image2,d_gemi2X,d_gemi2Y,d2_image2.getWidth(),d2_image2.getHeight(),this);   
        }  
        }
        
        // npc3 ile ilgili
         if (kontrolEt3()) {
                
                npc3_patlama = 1;
                sayac3++;                 
            }
          
         if (npc3_patlama==0) {
             if (d3_gemi_sag == 1) {
         g.drawImage(d3_image,d_gemi3X,d_gemi3Y,d3_image.getWidth(),d3_image.getHeight(),this);
         
        }
        else if(d3_gemi_sol == 1){
         g.drawImage(d3_image2,d_gemi3X,d_gemi3Y,d3_image2.getWidth(),d3_image2.getHeight(),this);   
        }  
        }
        // tüm npclerin vurulması
            
          if (npc1_patlama == 1 && npc2_patlama == 1 && npc3_patlama == 1) {
                sayac_t2++;
            }
             if (npc1_patlama==1 && npc2_patlama==1 && npc3_patlama == 1 && sayac_t2 == 1) {
                   level++;
               npc1_patlama = 0;
               npc2_patlama = 0;
               npc3_patlama = 0;
               d_gemi_can = 100;
               d_gemi2_can = 120;
               d_gemi3_can = 160;
               
               finall();
             
               for(Gulle gulle : gulleler){
                   
                   gulleler.remove(gulle);
                   
               } 
                try {
                    Thread.sleep(3000);
                   
                    System.exit(0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }
            
        }  
       
        // oyuncu gemisi
        if (gemi_sag==1) {
        g.drawImage(image,gemiX,gemiY,image.getWidth(), image.getHeight(),this);     
        }
        else if(gemi_sol==1){
        g.drawImage(image2,gemiX,gemiY,image2.getWidth(), image2.getHeight(),this);    
        }
        else if(gemi_yukari==1){
        g.drawImage(image3,gemiX,gemiY,image3.getWidth(), image3.getHeight(),this); 
        }
        else if(gemi_asagi==1){
        g.drawImage(image4,gemiX,gemiY,image4.getWidth(), image4.getHeight(),this); 
        }
        
        g.setColor(Color.black);
        
        for(Gulle gulle : gulleler){
            
            g.fillOval(gulle.getX(), gulle.getY(), 10, 10);
        }

    }

    @Override
    public void repaint() {
        super.repaint(); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         
        if (sure%600==0) {
         int a = random.nextInt(100);
              
            if (a%2==0){
            d_gemiX+=d_gemidirX; 
            d_gemi_sag = 1;
            d_gemi_sol = 0;
            }
            else{
            d_gemiX-=d_gemidirX;
            d_gemi_sol = 1;
            d_gemi_sag = 0;
            }
          
            if (d_gemiX<=150){
                d_gemiX=150;
            }
            else if(d_gemiX>=950){
                d_gemiX=950;
            }
                 
        }
           // npc2 
        if (sure%600==0) {
         int a = random.nextInt(100);
          // rastgele sayi uretimiyle rastgele npcleri hareket ettirdik
         
            if (a%2==0){
            d_gemi2X+=d_gemi2dirX; 
            d2_gemi_sag = 1;
            d2_gemi_sol = 0;
            }
            else{
            d_gemi2X-=d_gemi2dirX;
            d2_gemi_sol = 1;
            d2_gemi_sag = 0;
            }
          
            if (d_gemi2X<=150){
                d_gemi2X=150;
            }
            else if(d_gemi2X>=950){
                d_gemi2X=950;
            }        
        }
        
        // npc3
        if (sure%600==0) {
         int a = random.nextInt(100);
                    
            if (a%2==0){
            d_gemi3X+=d_gemi3dirX; 
            d3_gemi_sag = 1;
            d3_gemi_sol = 0;
            }
            else{
            d_gemi3X-=d_gemi3dirX;
            d3_gemi_sol = 1;
            d3_gemi_sag = 0;
            }
            //şimidlik  50 yapıldı solda oyun degerleri gösterilcek
            if (d_gemi3X<=150){
                d_gemi3X=150;
            }
            else if(d_gemi3X>=950){
                d_gemi3X=950;
            }    
        }     
        for(Gulle gulle : gulleler ){
          
          gulle.setY(gulle.getY()-gulledirY);
          
        }
        
    repaint();

    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
      
        int c = e.getKeyCode();
        
        if (c==KeyEvent.VK_RIGHT) {
            gemi_sag=1;
            gemi_sol=0;
            gemi_asagi=0;
            gemi_yukari=0;
            
            gemiX+=gemidirX;
        }
        else if(c==KeyEvent.VK_LEFT){
            gemi_sol=1;
            gemi_sag=0;
            gemi_asagi=0;
            gemi_yukari=0;
            
            gemiX-=gemidirX;
        }
        else if(c==KeyEvent.VK_UP){
            gemi_yukari=1;
            gemi_sag=0;
            gemi_sol=0;
            gemi_asagi=0;
            
            gemiY-=gemidirY;
        }
        else if(c==KeyEvent.VK_DOWN){
            gemi_asagi=1;
            gemi_yukari=0;
            gemi_sag=0;
            gemi_sol=0;
            
            gemiY+=gemidirY;
        }
        else if(c==KeyEvent.VK_SPACE){
            
            if (gulle_sayisi > 0) {
               if (gemi_sag==1) {
               gulleler.add(new Gulle(gemiX+55,gemiY+28));
            }
            else if(gemi_sol==1){
                gulleler.add(new Gulle(gemiX+100,gemiY+28));
            }
            gulle_ses();
            gulle_sayisi--;
            harcanan_gulle++;                
            }

        }
        if (gemiX<=0) {
            gemiX=0;
            
        }
        else if(gemiX>=932){
            gemiX=932;
        }
        
        if (gemiY<=0) {
            gemiY=0;
        }
        else if(gemiY>=490){
            gemiY=490;
        }
        else if(gemiY<=350){
            gemiY=350;
        }
        
        repaint();
     
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
