package graficos;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import calcular.Helechos;
import calcular.Julia;
import calcular.Mandelbrot;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class Fractal extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fractal frame = new Fractal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fractal() {
		setTitle("Fractales - Métodos Numéricos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final Graficar grafica = new Graficar();
		grafica.setBackground(SystemColor.controlHighlight);
		grafica.setBounds(20, 10, 550, 550);
		contentPane.add(grafica);
		
		final JComboBox tipoFractal = new JComboBox();
		tipoFractal.setModel(new DefaultComboBoxModel(new String[] {"Mandelbrot", "Julia", "Hoja de helechos"}));
		tipoFractal.setBounds(611, 46, 143, 24);
		contentPane.add(tipoFractal);
		
		JButton btnGraficar = new JButton("Graficar");
		btnGraficar.setBounds(611, 94, 117, 25);
		contentPane.add(btnGraficar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(611, 131, 117, 25);
		contentPane.add(btnLimpiar);
		
		JLabel lblEcuacin = new JLabel("Tipo Actual:");
		lblEcuacin.setBounds(611, 175, 96, 15);
		contentPane.add(lblEcuacin);
		
		final JLabel ecuacion = new JLabel("");
		ecuacion.setBounds(611, 189, 123, 15);
		contentPane.add(ecuacion);
		
		final JSlider zoom = new JSlider();
		zoom.setValue(1);
		zoom.setMaximum(10);
		zoom.setMinimum(1);
		zoom.setBounds(586, 216, 200, 16);
		contentPane.add(zoom);
		
		//click sobre el boton graficar
		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcion = tipoFractal.getSelectedIndex();
				String formula = null;
				Mandelbrot m = new Mandelbrot();
				Julia j = new Julia();
				Helechos h = new Helechos();
				int a = zoom.getValue();
				if (opcion == 0) {
					formula = "mandelbrot";
					grafica.dibujar(m.calcular(a));
				}
				
				else if (opcion == 1) {
					formula = "Julia";
					grafica.dibujar(j.calcular(a));
					
				}
				
				else if (opcion == 2) {
					grafica.dibujar(h.calcular());
					formula = "Helechos";
				}
				ecuacion.setText(formula);	
			}
		});
		
		//click sobre el boton limpiar
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grafica.limpiar();
				ecuacion.setText("");
			}
		});
	}
}
