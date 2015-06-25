package Presentacion;

import java.awt.*;
import java.awt.event.*;
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
	
	private final int anchoPantallaJuego = 400;
	private final int altoPantallaJuego = 600;
	
	public MenuPrincipal(){
		iniciarComponentes();
		setTitle("Grupo 1");
		setSize(300, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		this.juego = new Juego(this.anchoPantallaJuego, this.altoPantallaJuego);
	}

	private void iniciarComponentes() {
		this.contenedor=getContentPane();
		this.contenedor.setLayout(null);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.iniciarLabels();
		this.iniciarCajasDeTexto();
		this.iniciarCombos();
		this.iniciarBotones();
		
		this.contenedor.add(lblTitulo);
		this.contenedor.add(txtNombre);
		this.contenedor.add(lblNombre);
		this.contenedor.add(lblDificultad);
		this.contenedor.add(lstDificultades);
		this.contenedor.add(lblAnimal);
		this.contenedor.add(lstAnimales);
		this.contenedor.add(lblContexto);
		this.contenedor.add(lstContextos);
		this.contenedor.add(btnPuntaje);
		this.contenedor.add(btnIniciar);
		this.contenedor.add(btnSalir);
	}
	
	private void iniciarLabels(){
		this.lblTitulo = new JLabel();
		this.lblTitulo.setText("Animales Sueltos");
		this.lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 20));
		this.lblTitulo.setBounds(65, 15, 250, 40);
		
		this.lblNombre = new JLabel();
		this.lblNombre.setText("Nombre: ");
		this.lblNombre.setBounds(50, 130, 280, 23);
		
		this.lblDificultad = new JLabel();
		this.lblDificultad.setText("Dificultad");
		this.lblDificultad.setBounds(50, 305, 100, 23);
		
		this.lblAnimal = new JLabel();
		this.lblAnimal.setText("Animal");
		this.lblAnimal.setBounds(50, 185, 100, 23);
		
		this.lblContexto = new JLabel();
		this.lblContexto.setText("Contexto");
		this.lblContexto.setBounds(50, 245, 100, 23);
	}
	
	private void iniciarCajasDeTexto(){
		this.txtNombre = new JTextField();
		this.txtNombre.setBounds(130, 130, 90, 23);
	}
	
	private void iniciarBotones(){
		this.btnIniciar = new JButton();
		this.btnIniciar.setText("Iniciar Partida");
		this.btnIniciar.setBounds(80, 80, 130, 23);
		this.btnIniciar.addActionListener(this);

		this.btnPuntaje = new JButton();
		this.btnPuntaje.setText("Puntajes");
		this.btnPuntaje.setBounds(80, 375, 130, 23);
		this.btnPuntaje.addActionListener(this);
		
		this.btnSalir = new JButton();
		this.btnSalir.setText("Salir");
		this.btnSalir.setBounds(95, 420, 100, 23);
		this.btnSalir.addActionListener(this);
	}
	
	private void iniciarCombos(){
		this.lstDificultades = new JComboBox<ComboBoxItem>();
		this.lstDificultades.addItem(new ComboBoxItem(Dificultad.facil));
		this.lstDificultades.addItem(new ComboBoxItem(Dificultad.medio));
		this.lstDificultades.addItem(new ComboBoxItem(Dificultad.dificil));
		this.lstDificultades.setBounds(130, 305, 100, 23);
		this.lstDificultades.setSelectedIndex(0);
		
		this.lstAnimales = new JComboBox<ComboBoxItem>();
		this.lstAnimales.addItem(new ComboBoxItem(1, "Ave"));
		this.lstAnimales.addItem(new ComboBoxItem(2, "Reptil"));
		this.lstAnimales.addItem(new ComboBoxItem(3, "Mamifero"));
		this.lstAnimales.setBounds(130, 185, 100, 23);
		this.lstAnimales.setSelectedIndex(0);
		
		this.lstContextos = new JComboBox<ComboBoxItem>();
		this.lstContextos.addItem(new ComboBoxItem(1, "Aire"));
		this.lstContextos.addItem(new ComboBoxItem(2, "Tierra"));
		this.lstContextos.addItem(new ComboBoxItem(3, "Agua"));
		this.lstContextos.setBounds(130, 245, 100, 23);
		this.lstContextos.setSelectedIndex(0);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIniciar)
			iniciarPartida();
		if(e.getSource()==btnPuntaje)
			obtenerPuntajes();			
		if(e.getSource()==btnSalir)
			System.exit(0);
	}
	
	private void iniciarPartida(){
		try{
			this.validarIniciar();
			
			Partida partida = juego.nuevaPartida();
			partida.elegirNombre(txtNombre.getText());
			partida.elegirContexto(lstContextos.getItemAt(lstContextos.getSelectedIndex()).obtenerValor());
			partida.elegirAnimal(lstAnimales.getItemAt(lstAnimales.getSelectedIndex()).obtenerValor());
			partida.elegirDificultad(Dificultad.obtenerDificultad(lstDificultades.getItemAt(lstDificultades.getSelectedIndex()).obtenerValor()));
			// p.configurarElemento(tipoElemento,puntos)
			// ...
			
			JFrame frame = new JFrame("Partida");
			PantallaPartida pantallaPartida = new PantallaPartida(partida, this.anchoPantallaJuego, this.altoPantallaJuego);
			frame.add(pantallaPartida);
			frame.setSize(this.altoPantallaJuego, this.anchoPantallaJuego);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					partida.deleteObservers();
				}
			});
			
			pantallaPartida.iniciarPartida();
			
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
