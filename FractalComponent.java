/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.view;

import br.univali.model.Segmento;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

/**
 *
 * @author 6200559
 */
public class FractalComponent extends JComponent{

    private double x1;
    private double y1;
    private Color cor;
    public static final int MIN_NIVEL = 0;
    public static final int MAX_NIVEL = 15;
    private double nivel = MIN_NIVEL;

    private List<Segmento> segmentos = new ArrayList<>();

    public void addSegmentos(List<Segmento> segmentos) {
        synchronized(this.segmentos) {
            this.segmentos.clear();
            this.segmentos.addAll(segmentos);
        }
        
        repaint();
    }
    
    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public Color getCor() {
        return cor;
    }

    public static int getMIN_NIVEL() {
        return MIN_NIVEL;
    }

    public static int getMAX_NIVEL() {
        return MAX_NIVEL;
    }

    public double getNivel() {
        return nivel;
    }

    public void setX1(double x1) {
        this.x1 = x1;
        
    }

    public void setY1(double y1) {
        this.y1 = y1;
        
    }

    public void setCor(Color cor) {
        this.cor = cor;
       
    }

    public void setNivel(double nivel) {
        this.nivel = nivel;
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
       
        
        g.setColor(Color.BLACK);
        
        //System.out.println("Tamanho da lista ="+segmentos.size());
        
        synchronized(segmentos) {
            for (Segmento s : segmentos) {
            
                g.drawLine((int) s.getX1(), (int) s.getY1(), (int) s.getX2(), (int) s.getY2());
            
            }
            segmentos.clear(); 
        }
    }
    
    

}
