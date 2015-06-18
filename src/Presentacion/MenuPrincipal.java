package Presentacion;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

public class MenuPrincipal extends JFrame implements ActionListener {
	
	private Container contenedor;
	JLabel etiquetaTextField;
	JLabel labelTitulo;
	JLabel etiquetaDificultad;
	JLabel etiquetaAnimal;
	JLabel etiquetaContexto;
	JButton Iniciar;
	JButton Puntaje;
	JButton Salir;
	JComboBox Dificultad;
	JComboBox Animal;
	JComboBox Contexto;
	
	JTextField cajaDeTexto;
	
	public MenuPrincipal(){
		iniciarComponentes();
		setTitle("Grupo 1");
		setSize(300, 500);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void iniciarComponentes() {
		contenedor=getContentPane();
		contenedor.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		labelTitulo= new JLabel();
		labelTitulo.setText("Animales Sueltos");
		labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 20));
		labelTitulo.setBounds(65, 15, 250, 40);
		
		etiquetaTextField= new JLabel();
		etiquetaTextField.setText("Nombre: ");
		etiquetaTextField.setBounds(50, 130, 280, 23);

		cajaDeTexto = new JTextField();
		cajaDeTexto.setBounds(130, 130, 90, 23);
		
		Iniciar= new JButton();
		Iniciar.setText("Iniciar Partida");
		Iniciar.setBounds(80, 80, 130, 23);
		Iniciar.addActionListener(this);

		Puntaje= new JButton();
		Puntaje.setText("Puntajes");
		Puntaje.setBounds(80, 375, 130, 23);
		Puntaje.addActionListener(this);
		
		Salir= new JButton();
		Salir.setText("Salir");
		Salir.setBounds(95, 420, 100, 23);
		Salir.addActionListener(this);
		
		etiquetaDificultad= new JLabel();
		etiquetaDificultad.setText("Dificultad");
		etiquetaDificultad.setBounds(50, 305, 100, 23);
		
		Dificultad = new JComboBox();
		Dificultad.addItem("Facil");
		Dificultad.addItem("Medio");
		Dificultad.addItem("Dificil");
		Dificultad.setBounds(130, 305, 100, 23);
		Dificultad.setSelectedIndex(0);
		
		etiquetaAnimal= new JLabel();
		etiquetaAnimal.setText("Animal");
		etiquetaAnimal.setBounds(50, 185, 100, 23);
		
		Animal = new JComboBox();
		Animal.addItem("Reptil");
		Animal.addItem("Mamifero");
		Animal.addItem("Ave");
		Animal.setBounds(130, 185, 100, 23);
		Animal.setSelectedIndex(0);
		
		etiquetaContexto= new JLabel();
		etiquetaContexto.setText("Contexto");
		etiquetaContexto.setBounds(50, 245, 100, 23);
		
		Contexto = new JComboBox();
		Contexto.addItem("Agua");
		Contexto.addItem("Aire");
		Contexto.addItem("Tierra");
		Contexto.setBounds(130, 245, 100, 23);
		Contexto.setSelectedIndex(0);
		

		contenedor.add(labelTitulo);
		contenedor.add(cajaDeTexto);
		contenedor.add(etiquetaTextField);
		contenedor.add(etiquetaDificultad);
		contenedor.add(Dificultad);
		contenedor.add(etiquetaAnimal);
		contenedor.add(Animal);
		contenedor.add(etiquetaContexto);
		contenedor.add(Contexto);
		contenedor.add(Puntaje);
		contenedor.add(Iniciar);
		contenedor.add(Salir);
	}
	
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource()==Iniciar)
		{
			// TODO programar para que abra otra ventana y empiece el juego
			
			// Partida p = juego.nuevaPartida()
			// p.elegirNombre(cajaDeTexto.Text)
			// p.elegirAnimal(animal)
			// p.elegirDificultad(...)
			// p.elegirContexto(...)
			// p.configurarElemento(tipoElemento,puntos)
			// p.configurarElemento(tipoElemento2,puntos)
			// p.configurarElemento(tipoElemento3,puntos)
			// p.configurarElemento(tipoElemento4,puntos)
			// p.configurarElemento(tipoElemento5,puntos)
			// ..
			// p.iniciar()
		}
		if(evento.getSource()==Puntaje){
			// TODO programar para que muestre lista de puntajes			
		}
		if(evento.getSource()==Salir){
			System.exit(0);
		}
	}
	
	private String validaEvento() {
		String cad="Seleccionados : \n";
		cad+=Dificultad.getSelectedItem()+"\n";
		cad+=Animal.getSelectedItem()+"\n";
		cad+=Contexto.getSelectedItem()+"\n";
		return cad;
	}
}
