package calcular;

import java.awt.Color;

public class Julia {
	final int maxInt = 500; // máximo de interaciones
	private NComplejo F;
	private NComplejo C;
	private int iteraciones;
	final private double a = 0.003636364; //aumento por cada iteración
	private Color color;
	private Color pixel[][] = new Color[550][550];
	private int i = 0;
	private int j = 0;
	
	/**
	 * Implementa la función del fractal de Julia
	 * 
	 * Realiza un total de 550 iteraciones en x e y
	 * y evalua la función, dependiendo de su valor 
	 * es asignado a dicho pixel un color que equivale al número 
	 * de iteraciones realizadas.
	 * 
	 * @param entero para determinar el tipo de fractal julia
	 * @return Arreglo de colores.
	 */
	public Color[][] calcular(int c) {
		
		//diferentes constantes C originan diferente graficas.
		if (c < 3) {
			C = new NComplejo(0.285, 0.01);
		}
		else if (c < 5) {
			C = new NComplejo(-0.70176,-0.3842);
		}
		
		else if (c < 8) {
			C = new NComplejo(-0.8, 0.1561);
		}
		
		else {
			C = new NComplejo(-0.4,0.6);
		}
		
		for (double x = -1; x < 1 -a; x+= a) {
			for (double y = -1; y < 1 -a ; y+= a) {
				iteraciones = 0;
				
				F = new NComplejo(x, y);
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