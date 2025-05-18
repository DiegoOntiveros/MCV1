package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.AutoModel;

public class Views extends JFrame {

    private static final long serialVersionUID = 1L;
    public static final Color COLOR_BASE = Color.decode("#a2d2ff");
    private AutoModel model;

    public Views() {
        model = new AutoModel();
        initUI();
    }

    private void initUI() {
        // Configuración básica de la ventana
        setTitle("Inicio de sesión");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(COLOR_BASE);
        setLocationRelativeTo(null);

        // Componentes de la interfaz
        createLoginComponents();
        setVisible(true); // ¡IMPORTANTE! Esto debe estar al final
    }

    private void createLoginComponents() {
        JLabel textobase = new JLabel("Inicio de sesión:", SwingConstants.CENTER);
        textobase.setBounds(100, 30, 300, 50);
        textobase.setFont(new Font("Arial black", Font.BOLD, 24));
        textobase.setBackground(Color.decode("#ffc8dd"));
        textobase.setOpaque(true);
        textobase.setForeground(Color.black);
        add(textobase);

        JLabel Nombre = new JLabel("Ingrese su nombre completo:");
        Nombre.setBounds(100, 100, 300, 30);
        Nombre.setFont(new Font("Arial black", Font.BOLD, 16));
        Nombre.setForeground(Color.black);
        add(Nombre);

        JTextField barra_nombre = new JTextField();
        barra_nombre.setBounds(100, 140, 300, 30);
        add(barra_nombre);

        JLabel Password = new JLabel("Ingrese su contraseña:");
        Password.setBounds(100, 200, 300, 30);
        Password.setFont(new Font("Arial black", Font.BOLD, 16));
        Password.setForeground(Color.black);
        add(Password);

        JPasswordField barra_password = new JPasswordField();
        barra_password.setBounds(100, 240, 300, 30);
        add(barra_password);

        JButton boton_login = new JButton("Iniciar sesión");
        boton_login.setBounds(100, 300, 150, 40);
        boton_login.setBackground(Color.decode("#ffd60a"));
        boton_login.setFont(new Font("Arial black", Font.BOLD, 14));
        boton_login.addActionListener(e -> {
            String email = barra_nombre.getText();
            String password = new String(barra_password.getPassword());
            if(model.sesion(email, password)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
                Panel panel = new Panel();
                panel.show();
                dispose();
                
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(boton_login);

        JButton boton_registro = new JButton("Registrarse");
        boton_registro.setBounds(260, 300, 150, 40);
        boton_registro.setBackground(Color.WHITE);
        boton_registro.setFont(new Font("Arial black", Font.BOLD, 14));
        boton_registro.addActionListener(e -> mostrarVentanaRegistro());
        add(boton_registro);
    }

    public void mostrarVentanaRegistro() {
        JDialog dialog = new JDialog(this, "Registro", true);
        dialog.setSize(400, 350);
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(COLOR_BASE);
        dialog.setLocationRelativeTo(this);

        JLabel label = new JLabel("Registro de nuevo usuario", SwingConstants.CENTER);
        label.setBounds(50, 20, 300, 30);
        label.setFont(new Font("Arial black", Font.BOLD, 18));
        dialog.add(label);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(50, 70, 100, 25);
        dialog.add(nombreLabel);

        JTextField nombreField = new JTextField();
        nombreField.setBounds(150, 70, 200, 25);
        dialog.add(nombreField);

        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setBounds(50, 120, 100, 25);
        dialog.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 120, 200, 25);
        dialog.add(passField);

        JButton btnEnviar = new JButton("Registrar");
        btnEnviar.setBounds(100, 180, 100, 30);
        btnEnviar.addActionListener(e -> {
            String nombre = nombreField.getText();
            String password = new String(passField.getPassword());
            
            if(nombre.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(model.guardarUsuario(nombre, password)) {
                JOptionPane.showMessageDialog(dialog, "Usuario registrado con éxito");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Error al registrar usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.add(btnEnviar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(220, 180, 100, 30);
        btnCancelar.addActionListener(e -> dialog.dispose());
        dialog.add(btnCancelar);

        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Views();
        });
    }
}