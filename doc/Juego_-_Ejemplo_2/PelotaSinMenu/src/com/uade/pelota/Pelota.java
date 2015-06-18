package com.uade.pelota;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Pelota {
    
    private Image balon;
    //Coordenadas de la pelota
    private int X;       
    private int Y;

    private int velocidad_X;
    private int velocidad_Y;

    private int limite_izquierda=0;
    private int limite_derecha;
    private int limite_superior=0;
    private int limite_inferior;

     public Pelota(int x, int y) {
        //coordenadas iniciales
        this.X = x; this.Y = y;
        //imagen de la pelota
        balon = new ImageIcon(getClass().getResource("pelota.png")).getImage();
    }

    //dado las dimensiones del contendor JPanel
   public void LimitesXY(int width, int height) {
        limite_derecha  = width  - balon.getWidth(null);
        limite_inferior = height - balon.getHeight(null);
    }

   //recalcula variables para dar la sensacion de movimiento
   public void move() {
        //nueva posicion
        X += velocidad_X;
        Y += velocidad_Y;
        //controla que la pelota no salga de los limites del contenedor
        if (X < this.limite_izquierda) {
            X = 0;     
            velocidad_X = -velocidad_X; 
        } else if (X > limite_derecha) {
            X = limite_derecha; 
            velocidad_X = -velocidad_X; 
        }
        if (Y < this.limite_superior) {
            Y = 0;
            velocidad_Y = -velocidad_Y;

        } else if (Y > limite_inferior) {
            Y =  limite_inferior;
            velocidad_Y = -velocidad_Y;
        }
    }

    public void setVelocidadXY(){
        velocidad_X = getNumberRandom(4);
        velocidad_Y = getNumberRandom(8);
    }
    
    public void dibujar(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(balon, X, Y, null);
    }

    //devuelve un nœmero aleatorio entre 1 y MAX
    private int getNumberRandom(int Max){
        return (int) (Math.random()*Max+1);
    }
}
