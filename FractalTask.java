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
public class FractalTask implements Runnable {

    private List<FractalListener> listeners = new ArrayList<>();
    private Executor executor = Executors.newCachedThreadPool();

    private FractalGenerator generator;

    public FractalTask(FractalGenerator generator) {
        this.generator = generator;
    }

    public void addListener(FractalListener fe) {
        listeners.add(fe);
    }

    public FractalGenerator getGenerator() {
        return generator;
    }
    
    public FractalTask() {
        executor.execute((Runnable) this);
    }

    @Override
    public void run() {
        while(true) {
            List<Segmento> segmentos = generator.generateSegments();
        
            for (FractalListener listener : listeners) {
                listener.segmentosGerados(segmentos);
            }
            
//            try {
//                Thread.sleep(500);
//            }
//            catch(Exception e) {
//                
//            }
        }

    }

}
