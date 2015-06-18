package com.uade.pelota;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel{
     
    //instancia a la pelota en posicion (X,Y) => (0,0)
    private Pelota mipelota = new Pelota(0, 0);        
    private Timer timer;
    
    //Constructor
    public Panel(Dimension d) {
        this.setSize(d);
        this.setPreferredSize(d);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(new Color(0,255,0));
        mipelota.LimitesXY(getWidth(), getHeight());
        //para la animaci—n
        timer = new Timer(16, new ActionListener (){
            public void actionPerformed(ActionEvent e) {                
                mipelota.move();  
                repaint();    
            }
        });
    }

    //Controla el inicio y fin de la animaci—n
    public void animar(boolean turnOnOff) {
        if (turnOnOff) {
            mipelota.setVelocidadXY();
            timer.start(); 
        } else {
            timer.stop();
        }
    }

    //pinta la animaci—n
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        mipelota.dibujar(g);
    }

}
