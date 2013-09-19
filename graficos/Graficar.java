package graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")

public class Graficar extends Canvas {
	/**
	 * Dibujar
	 * 
	 * Dibuja en una área de 550px por 550px
	 * puntos de colores determinador por un 
	 * arreglo.
	 *
	 * @param Arreglo bidimensional con los colores
	 * de cada pixel.
	 */
	public void dibujar(Color c[][]) {
		Graphics g = getGraphics();
		for (int i = 0; i < 550; i++) {
			for (int j = 0; j < 550; j++) {
				g.setColor(c[i][j]);
				g.drawLine(i, j, i+1, j+1);
			}
		}
	}
		
	/**
	 * Limpiar
	 * 
	 * Colorea al color original (blanco) el área
	 * de dibujo.
	 */
	public void limpiar() {
		Graphics g = getGraphics();
		for (int i = 0; i < 550; i++) {
			for (int j = 0; j < 550; j++) {
				g.drawLine(i, j, i+1, j+1);
				g.setColor(Color.white);
			}
		}
	}
}
