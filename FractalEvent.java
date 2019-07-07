/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model;

import java.awt.Color;

/**
 *
 * @author 6200559
 */
public class FractalEvent {
    private int x1;
    private int y1;
    public static final int MIN_NIVEL = 0;
    public static final int MAX_NIVEL = 15;
    private int nivel = MIN_NIVEL;
    private Color cor;

    public FractalEvent(int x1, int y1, Color cor) {
        this.x1 = x1;
        this.y1 = y1;
        this.cor = cor;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
