package calcular;

import java.awt.Color;

public class Mandelbrot {
	final int maxInt = 500; // máximo de interaciones
	private NComplejo F;
	private NComplejo C;
	private int iteraciones; 
	//final private double a = 0.003636364; //aumento por cada iteración
	private Color color;
	private Color pixel[][] = new Color[550][550];
	private int i = 0;
	private int j = 0;
	
	/**
	 * Implementa la función del fractal de Mandelbrot
	 * 
	 * Realiza un total de 550 iteraciones en x e y
	 * y evalua la función, dependiendo de su valor 
	 * es asignado a dicho pixel un color que equivale al número 
	 * de iteraciones realizadas.
	 * 
	 * @param rango de datos
	 * @return Arreglo de colores.
	 */
	public Color[][] calcular(int c) {
		double a = (double)(c*2)/550; // calcular el incremento para realizar 550 itereaciones
		for (double x = -c; x < c - a; x+= a) {
			for (double y = -c; y < c - a; y+= a) {
				iteraciones = 0;
		
				F = new NComplejo(0, 0);
				C = new NComplejo(x, y);
				// Prueba que el valor de F no ha salido de la pantalla
				// y no ha excedido el máximo de iteraciones. Evalua función.
				while ((F.posicion() < 2) && (iteraciones < maxInt)) {
					F = F.cuadrado();
					F = F.sumar(C);
					iteraciones++;
				}
				color = new Color(iteraciones);
				pixel[i][j++] = color;
			}
			j = 0;
			i++;
		}
		return pixel;
	}
}