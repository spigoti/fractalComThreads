package br.univali.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 6200559
 */
public class SinHanLoDeitelGenerator implements FractalGenerator {

    private int nivel = 0;
    private int width = 584;
    private int height = 323;

    private List<Segmento> geraSegmentos(int nivel, int x1, int y1, int x2, int y2) {
        List<Segmento> segmentos = new ArrayList<>();
        if (0 == nivel) {
            segmentos.add(new Segmento(x1, y1, x2, y2));

        } else if (15 == nivel) {
            return segmentos;
        } else {
            //calcula o ponto medio entre as entradas
            int x3 = (x1 + x2) / 2;
            int y3 = (y1 + y2) / 2;
            // calcula um ponto para formação de um triângulo isósceles reto
            int x4 = x1 + (x3 - x1) / 2 - (y3 - y1) / 2;
            int y4 = y1 + (y3 - y1) / 2 + (x3 - x1) / 2;
            // desenha o fractal com 3 chamadas recursivas

            segmentos.addAll(geraSegmentos(nivel - 1, x4, y4, x1, y1));
            segmentos.addAll(geraSegmentos(nivel - 1, x4, y4, x3, y3));
            segmentos.addAll(geraSegmentos(nivel - 1, x4, y4, x2, y2));

        }
        return segmentos;
    }

    @Override
    public void setDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public List<Segmento> generateSegments() {
        List<Segmento> segmentos = new ArrayList<>();
        if (15 != nivel) {

            int x1 = Math.max(40, width / 3);
            int y1 = Math.max(40, height / 4);
            int x2 = Math.max(145, 4 * width / 5);
            int y2 = Math.max(100, 3 * height / 4);
            int x3 = (x2 + x1) / 2;
            int y3 = (y2 + y1) / 2;
            segmentos.addAll(geraSegmentos(nivel, x3, y1, x3, y3));
            segmentos.addAll(geraSegmentos(nivel, x3, y3, x1, y2));
            segmentos.addAll(geraSegmentos(nivel, x3, y3, x2, y2));
            nivel++;

            if (nivel >= 13) {
                nivel = 1;
            }

        }

        return segmentos;

    }

}
