package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Views extends JFrame {

    private static final long serialVersionUID = 1L;
    public static final Color COLOR_BASE = Color.decode("#a2d2ff");

    public Views() {
        // Configuración de la ventana principal (Inicio de sesión)
        this.setTitle("Inicio de sesión");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(COLOR_BASE);
        this.setLocationRelativeTo(null);

        // Componentes de inicio de sesión
        JLabel textobase = new JLabel("Inicio de sesión:", SwingConstants.CENTER);
        textobase.setBounds(100, 30, 300, 50);
        textobase.setFont(new Font("Arial black", Font.BOLD, 24));
        textobase.setBackground(Color.decode("#ffc8dd"));
        textobase.setOpaque(true);
        textobase.setForeground(Color.black);
        this.add(textobase);

        JLabel Nombre = new JLabel("Ingrese su nombre completo:");
        Nombre.setBounds(100, 100, 300, 30);
        Nombre.setFont(new Font("Arial black", Font.BOLD, 16));
        Nombre.setForeground(Color.black);
        this.add(Nombre);

        JTextField barra_nombre = new JTextField();
        barra_nombre.setBounds(100, 140, 300, 30);
        this.add(barra_nombre);

        JLabel Password = new JLabel("Ingrese su contraseña:");
        Password.setBounds(100, 200, 300, 30);
        Password.setFont(new Font("Arial black", Font.BOLD, 16));
        Password.setForeground(Color.black);
        this.add(Password);

        JPasswordField barra_password = new JPasswordField();
        barra_password.setBounds(100, 240, 300, 30);
        this.add(barra_password);

        JButton boton_login = new JButton("Iniciar sesión");
        boton_login.setBounds(100, 300, 150, 40);
        boton_login.setBackground(Color.decode("#ffd60a"));
        boton_login.setFont(new Font("Arial black", Font.BOLD, 14));
        this.add(boton_login);

        JButton boton_registro = new JButton("Registrarse");
        boton_registro.setBounds(260, 300, 150, 40);
        boton_registro.setBackground(Color.WHITE);
        boton_registro.setFont(new Font("Arial black", Font.BOLD, 14));
        this.add(boton_registro);

        // Acción para el botón de inicio de sesión
        
           

        // Acción para el botón de registro
        boton_registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaRegistro();
            }
        });

        this.setVisible(true);
    }

    // Método para mostrar la ventana de registro
    public void mostrarVentanaRegistro() {
        JFrame frameRegistro = new JFrame("Registro");
        frameRegistro.setSize(500, 500);
        frameRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameRegistro.setLayout(null);
        frameRegistro.getContentPane().setBackground(COLOR_BASE);
        frameRegistro.setLocationRelativeTo(null);

        JLabel label = new JLabel("Ventana de Registro", SwingConstants.CENTER);
        label.setBounds(100, 50, 300, 50);
        label.setFont(new Font("Arial black", Font.BOLD, 24));
        label.setForeground(Color.black);
        frameRegistro.add(label);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(150, 100, 200, 30);
        frameRegistro.add(nombreField);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 200, 30);
        frameRegistro.add(passwordField);
        
        JButton enviarButton = new JButton("Enviar");
        enviarButton.setBounds(150, 200, 100, 30);
        frameRegistro.add(enviarButton);

        // Botón de cancelar
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(260, 200, 100, 30);
        cancelarButton.addActionListener(e -> frameRegistro.dispose());
        frameRegistro.add(cancelarButton);

        frameRegistro.setVisible(true);
    }

    public static void main(String[] args) {
        new Views();
    }
}
