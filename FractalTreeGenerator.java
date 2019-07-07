/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class FractalTreeGenerator implements FractalGenerator {

    private int x1 = 200;
    private int y1 = 250;
    private int nivel = 1;

    private List<Segmento> geraSegmentos(int nivel, int x1, int y1, double angle) {
        List<Segmento> segmentos = new ArrayList<>();

        if (0 == nivel) {
            return segmentos;
        } else {
            float scaleFactor = x1 / 200.0f * 3.2f;
            int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * nivel * scaleFactor);
            int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * nivel * scaleFactor);
            segmentos.add(new Segmento(x1, y1, x2, y2));
            segmentos.addAll(geraSegmentos(nivel - 1, x2, y2, angle - 20));
            segmentos.addAll(geraSegmentos(nivel - 1, x2, y2, angle + 20));
        }
        return segmentos;
    }

    @Override
    public void setDimension(int width, int height) {
        x1 = width;
        y1 = height;
    }

    @Override
    public List<Segmento> generateSegments() {
        List<Segmento> segmentos = new ArrayList<>();
        //int x1 = 200, y1 = 250;
        double angle = -90;

//        for (nivel = 1; nivel < 10; nivel++) {
//            segmentos.addAll(geraSegmentos(nivel, x1, y1, angle));
//        }
        segmentos.addAll(geraSegmentos(nivel, x1, y1, angle));

        nivel++;

        if (nivel >= 10) {
            nivel = 1;
            segmentos.clear();
        }

        return segmentos;
    }

}
