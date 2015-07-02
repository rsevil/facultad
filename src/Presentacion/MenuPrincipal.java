package Presentacion;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

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
	
	private JLabel lblLadrillo;
	private JLabel lblLata;
	private JLabel lblAsteroide;
	private JLabel lblEstrella;
	private JLabel lblFruta;
	private JLabel lblCarne;
	private JLabel lblVerdura;
	
	private JTextField txtLadrillo;
	private JTextField txtLata;
	private JTextField txtAsteroide;
	private JTextField txtEstrella;
	private JTextField txtFruta;
	private JTextField txtCarne;
	private JTextField txtVerdura;
	
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
	
	private int puntajeAsteroide;
	private int puntajeLata;
	private int puntajeLadrillo;
	private int puntajeEstrella;
	private int puntajeCarne;
	private int puntajeVerdura;
	private int puntajeFruta;
	
	public MenuPrincipal(){
		iniciarComponentes();
		setTitle("Grupo 1");
		setSize(600, 450);
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
		
		this.contenedor.add(lblAsteroide);
		this.contenedor.add(txtAsteroide);
		
		this.contenedor.add(lblLata);
		this.contenedor.add(txtLata);
		
		this.contenedor.add(lblEstrella);
		this.contenedor.add(txtEstrella);
		
		this.contenedor.add(lblLadrillo);
		this.contenedor.add(txtLadrillo);
		
		this.contenedor.add(lblCarne);
		this.contenedor.add(txtCarne);
		
		this.contenedor.add(lblVerdura);
		this.contenedor.add(txtVerdura);
		
		this.contenedor.add(lblFruta);
		this.contenedor.add(txtFruta);
		
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
		this.lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36));
		this.lblTitulo.setBounds(145, 35, 400, 40);
		
		this.lblNombre = new JLabel();
		this.lblNombre.setText("Nombre: ");
		this.lblNombre.setBounds(50, 130, 280, 23);
		
		this.lblAnimal = new JLabel();
		this.lblAnimal.setText("Animal");
		this.lblAnimal.setBounds(50, 185, 100, 23);
		
		this.lblContexto = new JLabel();
		this.lblContexto.setText("Contexto");
		this.lblContexto.setBounds(50, 245, 100, 23);
		
		this.lblDificultad = new JLabel();
		this.lblDificultad.setText("Dificultad");
		this.lblDificultad.setBounds(50, 305, 100, 23);
		
		this.lblAsteroide = new JLabel();
		this.lblAsteroide.setText("Asteroide");
		this.lblAsteroide.setBounds(270, 130, 280, 23);
		
		this.lblLata = new JLabel();
		this.lblLata.setText("Lata");
		this.lblLata.setBounds(270, 185, 280, 23);
		
		this.lblEstrella = new JLabel();
		this.lblEstrella.setText("Estrella");
		this.lblEstrella.setBounds(270, 245, 280, 23);
		
		this.lblLadrillo = new JLabel();
		this.lblLadrillo.setText("Ladrillo");
		this.lblLadrillo.setBounds(270, 305, 280, 23);
		
		this.lblCarne = new JLabel();
		this.lblCarne.setText("Carne");
		this.lblCarne.setBounds(450, 130, 280, 23);
		
		this.lblVerdura = new JLabel();
		this.lblVerdura.setText("Verdura");
		this.lblVerdura.setBounds(450, 185, 280, 23);
		
		this.lblFruta = new JLabel();
		this.lblFruta.setText("Fruta");
		this.lblFruta.setBounds(450, 245, 280, 23);
	}
	
	private void iniciarCajasDeTexto(){
		this.txtNombre = new JTextField();
		this.txtNombre.setBounds(130, 130, 90, 23);
		
		this.txtAsteroide = new JTextField();
		this.txtAsteroide.setText("1");
		this.txtAsteroide.setBounds(350, 130, 50, 23);
		
		this.txtLata = new JTextField();
		this.txtLata.setText("1");
		this.txtLata.setBounds(350, 185, 50, 23);
		
		this.txtEstrella = new JTextField();
		this.txtEstrella.setText("1");
		this.txtEstrella.setBounds(350, 245, 50, 23);
		
		this.txtLadrillo = new JTextField();
		this.txtLadrillo.setText("1");
		this.txtLadrillo.setBounds(350, 305, 50, 23);
		
		this.txtCarne = new JTextField();
		this.txtCarne.setText("1");
		this.txtCarne.setBounds(520, 130, 50, 23);
		
		this.txtVerdura = new JTextField();
		this.txtVerdura.setText("1");
		this.txtVerdura.setBounds(520, 185, 50, 23);
		
		this.txtFruta = new JTextField();
		this.txtFruta.setText("1");
		this.txtFruta.setBounds(520, 245, 50, 23);
	}
	
	private void iniciarBotones(){
		this.btnIniciar = new JButton();
		this.btnIniciar.setText("Iniciar Partida");
		this.btnIniciar.setBounds(80, 375, 130, 23);
		this.btnIniciar.addActionListener(this);

		this.btnPuntaje = new JButton();
		this.btnPuntaje.setText("Puntajes");
		this.btnPuntaje.setBounds(230, 375, 130, 23);
		this.btnPuntaje.addActionListener(this);
		
		this.btnSalir = new JButton();
		this.btnSalir.setText("Salir");
		this.btnSalir.setBounds(380, 375, 130, 23);
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
		this.lstAnimales.addItem(new ComboBoxItem(TipoAnimal.ave));
		this.lstAnimales.addItem(new ComboBoxItem(TipoAnimal.reptil));
		this.lstAnimales.addItem(new ComboBoxItem(TipoAnimal.mamifero));
		this.lstAnimales.setBounds(130, 185, 100, 23);
		this.lstAnimales.setSelectedIndex(0);
		
		this.lstContextos = new JComboBox<ComboBoxItem>();
		this.lstContextos.addItem(new ComboBoxItem(TipoContexto.aire));
		this.lstContextos.addItem(new ComboBoxItem(TipoContexto.tierra));
		this.lstContextos.addItem(new ComboBoxItem(TipoContexto.agua));
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
			partida.elegirContexto(
					TipoContexto.obtenerTipoContexto(
							lstContextos
								.getItemAt(lstContextos.getSelectedIndex())
								.obtenerValor()));
			partida.elegirAnimal(
					TipoAnimal.obtenerTipoAnimal(
							lstAnimales
								.getItemAt(lstAnimales.getSelectedIndex())
								.obtenerValor()));
			
			partida.elegirDificultad(
					Dificultad.obtenerDificultad(
							lstDificultades
								.getItemAt(lstDificultades.getSelectedIndex())
								.obtenerValor()));
			
			partida.configurarElemento(TipoElemento.verdura,puntajeVerdura);
			partida.configurarElemento(TipoElemento.fruta,puntajeFruta);
			partida.configurarElemento(TipoElemento.carne,puntajeCarne);
			partida.configurarElemento(TipoElemento.asteroide,puntajeAsteroide);
			partida.configurarElemento(TipoElemento.estrella,puntajeEstrella);
			partida.configurarElemento(TipoElemento.lata,puntajeLata);
			partida.configurarElemento(TipoElemento.ladrillo,puntajeLadrillo);
			
			JFrame frame = new JFrame("Partida");
			PantallaPartida pantallaPartida = new PantallaPartida(partida, this.anchoPantallaJuego, this.altoPantallaJuego);
			frame.add(pantallaPartida);
			frame.setSize(this.altoPantallaJuego, this.anchoPantallaJuego);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.pack();
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					try{
						pantallaPartida.cerrarPartida();
					}catch(Exception ex){
						JOptionPane.showMessageDialog(frame, ex.toString());
					}
				}
			});
			
			pantallaPartida.iniciarPartida();
		}catch(Exception ex){
			if (ex.getMessage().isEmpty()){
				JOptionPane.showMessageDialog(this, ex.toString());				
			}else{
				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
		}
	}
	
	private void obtenerPuntajes(){
		// TODO: En un popupsito mostrar una tabla con los 10 
		// primeros puntajes ordenados de mayor a menor
		
		//obtener la lista de puntajes del juego
		List<Puntaje> puntajes = new ArrayList<Puntaje>(juego.obtenerPuntajes());

		//Ordenar la lista, hay que usar un Comparator<Puntaje>
		//http://stackoverflow.com/questions/2477261/how-to-sort-a-collectiont
		Collections.sort(
			puntajes, 
			new Comparator<Puntaje>(){
				public int compare(Puntaje p, Puntaje p1){
					//para que de de mayor a menor
					return (int)-(p.obtenerPuntos() - p1.obtenerPuntos());
				}
			});
			
		//Aca hay que probar que pasa si la lista
		//tiene menos de 10 elementos
		//http://www.leveluplunch.com/java/examples/limit-or-take-first-elements-from-list/
		int max = 10;
		if (puntajes.size() < max)
			max = puntajes.size();
		puntajes = puntajes.subList(0, max);
		
		Object columnas[] = {"Nombre","Animal","Puntos"};
		Object filas[][] = new Object[max][3];
		int i = 0;
		for(Puntaje p : puntajes){
			filas[i][0] = p.obtenerNombre();
			filas[i][1] = p.obtenerAnimal();
			filas[i][2] = String.format("%.2f", p.obtenerPuntos());
			i++;
		}
		
		JFrame frame = new JFrame("Puntajes");
		JTable table = new JTable(filas,columnas);
		JScrollPane scrollPane = new JScrollPane(table);
		
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setSize(300,150);
		frame.setVisible(true);
	}
	
	private void validarIniciar() throws Exception {
		if (txtNombre.getText().isEmpty())
			throw new Exception("El campo \"Nombre\" no puede estar vacio");
		
		if (txtAsteroide.getText().isEmpty())
			throw new Exception("El campo \"Asteroide\" no puede estar vacio");
		
		if (txtLata.getText().isEmpty())
			throw new Exception("El campo \"Lata\" no puede estar vacio");
		
		if (txtLadrillo.getText().isEmpty())
			throw new Exception("El campo \"Ladrillo\" no puede estar vacio");
		
		if (txtEstrella.getText().isEmpty())
			throw new Exception("El campo \"Estrella\" no puede estar vacio");
		
		if (txtCarne.getText().isEmpty())
			throw new Exception("El campo \"Carne\" no puede estar vacio");
		
		if (txtVerdura.getText().isEmpty())
			throw new Exception("El campo \"Verdura\" no puede estar vacio");
		
		if (txtFruta.getText().isEmpty())
			throw new Exception("El campo \"Fruta\" no puede estar vacio");
		
		try{
			puntajeAsteroide = Integer.parseInt(txtAsteroide.getText());
		}catch(NumberFormatException ex){
			throw new Exception("El campo \"Asteroide\" tiene que ser un numero entero");
		}
		
		try{
			puntajeLata = Integer.parseInt(txtLata.getText());
		}catch(NumberFormatException ex){
			throw new Exception("El campo \"Lata\" tiene que ser un numero entero positivo");
		}
		
		try{
			puntajeLadrillo = Integer.parseInt(txtLadrillo.getText());
		}catch(NumberFormatException ex){
			throw new Exception("El campo \"Ladrillo\" tiene que ser un numero entero");
		}
		
		try{
			puntajeEstrella = Integer.parseInt(txtEstrella.getText());
		}catch(NumberFormatException ex){
			throw new Exception("El campo \"Estrella\" tiene que ser un numero entero");
		}
		
		try{
			puntajeCarne = Integer.parseInt(txtCarne.getText());
		}catch(NumberFormatException ex){
			throw new Exception("El campo \"Carne\" tiene que ser un numero entero");
		}
		
		try{
			puntajeVerdura = Integer.parseInt(txtVerdura.getText());
		}catch(NumberFormatException ex){
			throw new Exception("El campo \"Verdura\" tiene que ser un numero entero");
		}
		
		try{
			puntajeFruta = Integer.parseInt(txtFruta.getText());
		}catch(NumberFormatException ex){
			throw new Exception("El campo \"Fruta\" tiene que ser un numero entero");
		}
		
		if (puntajeAsteroide < 0)
			throw new Exception("El campo \"Asteroide\" tiene que ser un numero entero positivo");
		
		if (puntajeLata < 0)
			throw new Exception("El campo \"Lata\" tiene que ser un numero entero positivo");
		
		if (puntajeLadrillo < 0)
			throw new Exception("El campo \"Ladrillo\" tiene que ser un numero entero positivo");
		
		if (puntajeEstrella < 0)
			throw new Exception("El campo \"Estrella\" tiene que ser un numero entero positivo");
		
		if (puntajeCarne < 0)
			throw new Exception("El campo \"Carne\" tiene que ser un numero entero positivo");
		
		if (puntajeVerdura < 0)
			throw new Exception("El campo \"Verdura\" tiene que ser un numero entero positivo");
		
		if (puntajeFruta < 0)
			throw new Exception("El campo \"Fruta\" tiene que ser un numero entero positivo");
	}
}
