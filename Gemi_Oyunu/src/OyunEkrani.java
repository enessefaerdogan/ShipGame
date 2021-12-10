
import java.awt.HeadlessException;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class OyunEkrani extends JFrame {

    public OyunEkrani(String string) throws HeadlessException {
        super(string);
    }
    
    
    public static void main(String[] args){
        
        OyunEkrani ekran = new OyunEkrani("Gemi Oyunu");
        
        ekran.setResizable(false);
        
        ekran.setFocusable(false);
        
        ekran.setSize(1100,700);
        
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        Oyun oyun = new Oyun();
        
        oyun.requestFocus();
        
        oyun.addKeyListener(oyun);
        
        oyun.setFocusable(true);
        
        oyun.setFocusTraversalKeysEnabled(false);
        
        ekran.add(oyun);
        
        ekran.setVisible(true);
    }
}
