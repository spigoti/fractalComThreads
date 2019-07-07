/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model;

/**
 *
 * @author 6200559
 */
public class Segmento {

    private double x1, x2, y1, y2;

    public Segmento(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Segmento(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
    

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    @Override
    public String toString() {
        return "Segmento{" + "x1=" + x1 + ", x2=" + x2 + ", y1=" + y1 + ", y2=" + y2 + '}';
    }
    

}
