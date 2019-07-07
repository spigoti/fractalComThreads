/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author 6200559
 */
public class FractalTaskCombo implements Runnable {

    private FractalListener listener1;
    private FractalListener listener2;
    private Executor executor = Executors.newCachedThreadPool();

    private FractalGenerator generator1;
    private FractalGenerator generator2;

    public FractalTaskCombo(FractalGenerator generator1, FractalGenerator generator2) {
        this.generator1 = generator1;
        this.generator2 = generator2;
    }

    public void addListeners(FractalListener l1, FractalListener l2) {
        this.listener1 = l1;
        this.listener2 = l2;
    }

    public FractalTaskCombo() {
        executor.execute((Runnable) this);
    }

    @Override
    public void run() {
        while (true) {
            List<Segmento> segmentos = generator1.generateSegments();

            listener1.segmentosGerados(segmentos);

            segmentos = generator2.generateSegments();

            listener2.segmentosGerados(segmentos);

//            try {
//                Thread.sleep(500);
//            } catch (Exception e) {
//
//            }
        }

    }
    
    public void setDimension(int w, int h) {
        generator1.setDimension(w, h);
        generator2.setDimension(w, h);
    }

}
