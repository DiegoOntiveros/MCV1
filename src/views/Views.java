package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Views extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Color COLOR_BASE = Color.decode("#bde0fe");

    public Views() {
        // Configuración de la ventana
        this.setTitle("Registro de datos para el INE");
        this.setSize(650, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(COLOR_BASE);

        // Configuración de componentes
        configurarLabels();
        configurarCamposTexto();
        configurarOpcionesGenero();
        configurarBotones();
    }

    private void configurarLabels() {
        JLabel textoBase = new JLabel("Registro de datos", SwingConstants.CENTER);
        textoBase.setBounds(20, 15, 320, 50);
        textoBase.setFont(new Font("Arial Black", Font.BOLD, 24));
        textoBase.setOpaque(true);
        textoBase.setBackground(Color.WHITE);
        textoBase.setForeground(Color.BLACK);
        this.add(textoBase);

        JLabel nombreLabel = new JLabel("Ingrese su nombre completo:", SwingConstants.CENTER);
        nombreLabel.setBounds(10, 80, 350, 50);
        nombreLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        nombreLabel.setOpaque(true);
        nombreLabel.setBackground(COLOR_BASE);
        nombreLabel.setForeground(Color.BLACK);
        this.add(nombreLabel);

        JLabel passwordLabel = new JLabel("Ingrese su contraseña:", SwingConstants.CENTER);
        passwordLabel.setBounds(10, 180, 280, 50);
        passwordLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        passwordLabel.setOpaque(true);
        passwordLabel.setBackground(COLOR_BASE);
        passwordLabel.setForeground(Color.BLACK);
        this.add(passwordLabel);

        JLabel ciudadLabel = new JLabel("Escoja su ciudad:", SwingConstants.CENTER);
        ciudadLabel.setBounds(15, 300, 220, 50);
        ciudadLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        ciudadLabel.setOpaque(true);
        ciudadLabel.setBackground(COLOR_BASE);
        ciudadLabel.setForeground(Color.BLACK);
        this.add(ciudadLabel);

        JLabel generoLabel = new JLabel("Escoja su género:", SwingConstants.CENTER);
        generoLabel.setBounds(10, 380, 250, 50);
        generoLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        generoLabel.setOpaque(true);
        generoLabel.setBackground(COLOR_BASE);
        generoLabel.setForeground(Color.BLACK);
        this.add(generoLabel);
    }

    private void configurarCamposTexto() {
        JTextField barraNombre = new JTextField();
        barraNombre.setBounds(20, 130, 250, 30);
        this.add(barraNombre);

        JPasswordField barraPassword = new JPasswordField();
        barraPassword.setBounds(20, 240, 250, 30);
        this.add(barraPassword);

        String[] ciudades = {"Cabo San Lucas", "La Paz", "San José", "Ciudad Constitución"};
        JComboBox<String> listaCiudades = new JComboBox<>(ciudades);
        listaCiudades.setBounds(20, 360, 150, 30);
        this.add(listaCiudades);
    }

    private void configurarOpcionesGenero() {
        JRadioButton hombre = new JRadioButton("Hombre");
        hombre.setBounds(20, 450, 100, 30);
        hombre.setBackground(COLOR_BASE);

        JRadioButton mujer = new JRadioButton("Mujer");
        mujer.setBounds(20, 490, 100, 30);
        mujer.setBackground(COLOR_BASE);

        JRadioButton noDefinido = new JRadioButton("No definido");
        noDefinido.setBounds(20, 530, 150, 30);
        noDefinido.setBackground(COLOR_BASE);

        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(hombre);
        grupoGenero.add(mujer);
        grupoGenero.add(noDefinido);

        this.add(hombre);
        this.add(mujer);
        this.add(noDefinido);
    }

    private void configurarBotones() {
        JButton botonRegistro = new JButton("Registrarse");
        botonRegistro.setBounds(50, 680, 150, 50);
        botonRegistro.setBackground(Color.decode("#ffd60a"));
        botonRegistro.setFont(new Font("Arial", Font.BOLD, 15));
        botonRegistro.setOpaque(true);
        botonRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Registro completado.");
            }
        });
        this.add(botonRegistro);

        JButton botonInicioSesion = new JButton("Iniciar sesión");
        botonInicioSesion.setBounds(250, 680, 150, 50);
        botonInicioSesion.setBackground(Color.WHITE);
        botonInicioSesion.setFont(new Font("Arial", Font.BOLD, 15));
        botonInicioSesion.setOpaque(true);
        botonInicioSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Redirigiendo al inicio de sesión.");
            }
        });
        this.add(botonInicioSesion);
    }

    public static void main(String[] args) {
        new Views().setVisible(true);
    }

	public void login() {
		// TODO Auto-generated method stub
		
	}
}
