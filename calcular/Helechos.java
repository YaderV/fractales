package calcular;

import java.awt.Color;

public class Helechos {
	private Color[][] pixel = new Color[550][550];
	private double x = Math.random();
	private double y = Math.random();

	/**
	 * Convertir coordenada a pixel.
	 * 
	 * Convierte una coordenada cartesiana -2.5 <= x <= 2.5
	 * a su posición equivalente en pixeles de 0 a 550,
	 * para su conversión se realizó una regresión lineal.
	 * 
	 * @param coordenada cartesiana x
	 * @return valor de pixel
	 */
	public static int converX(double x) {
		int pix;
		pix = (int) ((110 * x) + 215);
		return pix;
	}

	/**
	 * Convertir coordenada a pixel.
	 * 
	 * Convierte una coordenada cartesiana 0 <= y <= 10
	 * a su posición equivalente en pixeles de 0 a 550,
	 * para su conversión se realizó una regresión lineal.
	 * 
	 * @param coordenada cartesiana y
	 * @return valor de pixel
	 */
	public static int converY(double y) {
		int pix;
		pix = (int) ((-55 * y) + 550);
		return pix;
	}
	
	/**
	 * Implementa el sistema de funciones iterativas 
	 * del fractal de Barnsley Fern.
	 * 
	 * Realiza un total de 100000000 iteraciones
	 * para implementar las ecuaciones que dibujan
	 * el fractal, los puntos son convertidos a pixeles
	 * verdes y almacenados en un arreglo de colores,
	 * los demás puntos permanecen en su color original
	 * blanco.
	 * 
	 * @return arreglo de colores.
	 */
	public Color[][] calcular() {
		for (int i = 0; i < 550; i++) {
			for (int j = 0; j < 550; j++)
				pixel[i][j] = Color.white;
		}

		for (int i = 0; i < 100000000; i++) {
			double xtemp = 0; // x temporal
			double ytemp = 0; // y temporal
			double r = Math.random(); // numero aleatorio

			if (r <= 0.02) {
				xtemp = 0;
				ytemp = 0.16 * y;
			}

			else if (r <= 0.17) {
				xtemp = (0.85 * x) + (0.04 * y);
				ytemp = (-0.04 * x) + (0.85 * y) + 1.6;
			}

			else if (r <= 0.30) {
				xtemp = (0.2 * x) - (0.26 * y);
				ytemp = (0.23 * x) + (0.22 * y) + 1.6;
			}

			else if (r <= 1) {
				xtemp = (-0.15 * x) + (0.28 * y);
				ytemp = (0.26 * x) + (0.24 * y) + 0.44;
			}
			//El nuevo valor calculado es asignado a los
			//valores permantes de x e y.
			x = xtemp;
			y = ytemp;
			pixel[converX(x)][converY(y)] = Color.green; //Se pinta el punto en verde.
		}
		return pixel;
	}
}
