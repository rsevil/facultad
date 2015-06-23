package Presentacion;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;

import javax.swing.*;

import Modelo.*;

public class MenuPrincipal extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private Container contenedor;
	
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblDificultad;
	private JLabel lblAnimal;
	private JLabel lblContexto;
	
	private JButton btnIniciar;
	private JButton btnPuntaje;
	private JButton btnSalir;
	
	private JTextField txtNombre;
	private JComboBox<ComboBoxItem> lstDificultades;
	private JComboBox<ComboBoxItem> lstAnimales;
	private JComboBox<ComboBoxItem> lstContextos;
	
	private Juego juego;
	
	private final int anchoPantallaJuego = 1024;
	private final int altoPantallaJuego = 768;
	
	public MenuPrincipal(){
		iniciarComponentes();
		setTitle("Grupo 1");
		setSize(300, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		juego = new Juego(this.anchoPantallaJuego, this.altoPantallaJuego);
	}

	private void iniciarComponentes() {
		contenedor=getContentPane();
		contenedor.setLayout(null);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		iniciarLabels();
		iniciarCajasDeTexto();
		iniciarCombos();
		iniciarBotones();
		
		contenedor.add(lblTitulo);
		contenedor.add(txtNombre);
		contenedor.add(lblNombre);
		contenedor.add(lblDificultad);
		contenedor.add(lstDificultades);
		contenedor.add(lblAnimal);
		contenedor.add(lstAnimales);
		contenedor.add(lblContexto);
		contenedor.add(lstContextos);
		contenedor.add(btnPuntaje);
		contenedor.add(btnIniciar);
		contenedor.add(btnSalir);
	}
	
	private void iniciarLabels(){
		lblTitulo = new JLabel();
		lblTitulo.setText("Animales Sueltos");
		lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 20));
		lblTitulo.setBounds(65, 15, 250, 40);
		
		lblNombre = new JLabel();
		lblNombre.setText("Nombre: ");
		lblNombre.setBounds(50, 130, 280, 23);
		
		lblDificultad = new JLabel();
		lblDificultad.setText("Dificultad");
		lblDificultad.setBounds(50, 305, 100, 23);
		
		lblAnimal = new JLabel();
		lblAnimal.setText("Animal");
		lblAnimal.setBounds(50, 185, 100, 23);
		
		lblContexto = new JLabel();
		lblContexto.setText("Contexto");
		lblContexto.setBounds(50, 245, 100, 23);
	}
	
	private void iniciarCajasDeTexto(){
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 130, 90, 23);
	}
	
	private void iniciarBotones(){
		btnIniciar = new JButton();
		btnIniciar.setText("Iniciar Partida");
		btnIniciar.setBounds(80, 80, 130, 23);
		btnIniciar.addActionListener(this);

		btnPuntaje = new JButton();
		btnPuntaje.setText("Puntajes");
		btnPuntaje.setBounds(80, 375, 130, 23);
		btnPuntaje.addActionListener(this);
		
		btnSalir = new JButton();
		btnSalir.setText("Salir");
		btnSalir.setBounds(95, 420, 100, 23);
		btnSalir.addActionListener(this);
	}
	
	private void iniciarCombos(){
		lstDificultades = new JComboBox<ComboBoxItem>();
		lstDificultades.addItem(new ComboBoxItem(Dificultad.facil.obtenerValor(), Dificultad.facil.toString()));
		lstDificultades.addItem(new ComboBoxItem(Dificultad.medio.obtenerValor(), Dificultad.medio.toString()));
		lstDificultades.addItem(new ComboBoxItem(Dificultad.dificil.obtenerValor(), Dificultad.dificil.toString()));
		lstDificultades.setBounds(130, 305, 100, 23);
		lstDificultades.setSelectedIndex(0);
		
		lstAnimales = new JComboBox<ComboBoxItem>();
		lstAnimales.addItem(new ComboBoxItem(1, "Ave"));
		lstAnimales.addItem(new ComboBoxItem(2, "Reptil"));
		lstAnimales.addItem(new ComboBoxItem(3, "Mamifero"));
		lstAnimales.setBounds(130, 185, 100, 23);
		lstAnimales.setSelectedIndex(0);
		
		lstContextos = new JComboBox<ComboBoxItem>();
		lstContextos.addItem(new ComboBoxItem(1, "Aire"));
		lstContextos.addItem(new ComboBoxItem(2, "Tierra"));
		lstContextos.addItem(new ComboBoxItem(3, "Agua"));
		lstContextos.setBounds(130, 245, 100, 23);
		lstContextos.setSelectedIndex(0);
	}
	
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource()==btnIniciar)
		{
			iniciarPartida();
		}
		if(evento.getSource()==btnPuntaje){
			obtenerPuntajes();			
		}
		if(evento.getSource()==btnSalir){
			System.exit(0);
		}
	}
	
	private void iniciarPartida(){
		try{
			validarIniciar();
			
			Partida partida = juego.nuevaPartida();
			partida.elegirNombre(txtNombre.getText());
			partida.elegirAnimal(lstAnimales.getItemAt(lstAnimales.getSelectedIndex()).obtenerValor());
			partida.elegirDificultad(Dificultad.obtenerDificultad(lstDificultades.getItemAt(lstDificultades.getSelectedIndex()).obtenerValor()));
			partida.elegirContexto(lstContextos.getItemAt(lstContextos.getSelectedIndex()).obtenerValor());
			// p.configurarElemento(tipoElemento,puntos)
			// ...
			
			JFrame frame = new JFrame("Partida");
			PantallaPartida pantallaPartida = new PantallaPartida(partida, this.altoPantallaJuego, this.anchoPantallaJuego);
			frame.add(pantallaPartida);
//			frame.setSize(this.altoPantallaJuego, this.anchoPantallaJuego);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					partida.deleteObservers();
				}
			});
			
		}catch(Exception ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	
	private void obtenerPuntajes(){
		// TODO: En un popupsito mostrar una tabla con los 10 
		// primeros puntajes ordenados de mayor a menor
		juego.obtenerPuntajes();
	}
	
	private void validarIniciar() throws Exception {
		if (txtNombre.getText() == null)
			throw new Exception("El campo \"Nombre\" no puede estar vacio");
	}
}
