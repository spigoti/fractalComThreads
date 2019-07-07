
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model;

import java.util.List;

/**
 *
 * @author 6200559
 */
public interface FractalGenerator {
 
    List<Segmento> generateSegments();
    
    void setDimension(int width, int height);
   
}
