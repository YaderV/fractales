package calcular;

public class NComplejo {
	//Clase de número complejo
	//definido a + bi.
	
	private double r;
	private double i;
	
	/**
	 * Construye un número complejo
	 * 
	 * Crea un número complejo con una parte real y
	 * una imaginaria, de la forma a + bi.
	 * 
	 * @param Parte real del número.
	 * @param Parte imaginaria del número.
	 */
	public NComplejo(double real, double imaginario) {
		r = real;
		i = imaginario;
	}
	
	
	public double getR() {
		return r;
	}
	
	public double getI() {
		return i;
	}
	
	
	/**
	 * Sumar número complejo
	 * 
	 * Suma al mismo número complejo otro número
	 * complejo C, la operación se realiza siguiendo
	 * las propiedades de números complejos.
	 * 
	 * @param Número complejo C
	 * @return La suma del mismo número complejo + C.
	 */
	public NComplejo cuadrado() {
		double a = this.getR();
		double b = this.getI();
		r = (a*a - b*b);
		i = (a*b + b*a);
		return this;
	}
	
	/**
	 * Eleva al cuadrado un número complejo
	 * 
	 * Eleva al cuadrado el mismo número complejo,
	 * la operación se realiza multiplicando por si 
	 * mismo el número y siguiendo las propiedades
	 * de números complejos.
	 *
	 * @return el cuadrado del mismo número complejo.
	 */
	public NComplejo sumar(NComplejo C) {
		double a = this.getR();
		double b = this.getI();
		double c = C.getR();
		double d = C.getI();
		r = a + c;
		i = b - d;
		return this;
	}
	
	//Devuelve una posición absoluta del número
	//complejo, su implementación es determinar
	//si el número se encuentra dentro de un 
	//intervalo definido de coordenadas cartesianas
	//o fuera de el.
	/**
	 * Devolver posición cartesiana
	 * 
	 * Determina si el número aún sigue dentro
	 * de un radio determinado dentro de un plano
	 * de coordenadas cartesianas. Se utiliza como 
	 * condicion en funciones de Julia y Mandelbrot.
	 *
	 * @return posicion entera.
	 */
	public double posicion() {
		double a;
		a = Math.abs(this.getR()) + Math.abs(this.getI());
		return a/2;
		
	}
}
