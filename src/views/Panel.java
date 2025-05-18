package views;

import models.AutoModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel {

    private JFrame frame;

    public Panel() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 255, 240));
        frame.setBounds(100, 100, 659, 382);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(207, 10, 204, 51);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(10, 10, 184, 31);
        panel.add(panel_1);

        JLabel lblNewLabel = new JLabel("Menu");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel_1.add(lblNewLabel);

        JButton btnVerDatos = new JButton("Ver datos");
        btnVerDatos.setBounds(88, 135, 105, 116);
        frame.getContentPane().add(btnVerDatos);

        JButton btnEliminarDatos = new JButton("Eliminar datos");
        btnEliminarDatos.setBounds(233, 135, 124, 116);
        frame.getContentPane().add(btnEliminarDatos);
        btnEliminarDatos.addActionListener(e -> {
            // Obtén la lista de usuarios
            ArrayList<String> usuarios = new AutoModel().obtenerUsuarios();

            if (usuarios.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No hay usuarios registrados para eliminar.");
                return;
            }

            // Muestra un diálogo para seleccionar el usuario a eliminar
            String usuarioAEliminar = (String) JOptionPane.showInputDialog(
                frame,
                "Selecciona un usuario para eliminar:",
                "Eliminar usuario",
                JOptionPane.QUESTION_MESSAGE,
                null,
                usuarios.toArray(),
                usuarios.get(0)
            );

            if (usuarioAEliminar != null) {
                // Llama al método para eliminar el usuario
                boolean eliminado = new AutoModel().eliminarUsuario(usuarioAEliminar.split(" | ")[0]);
                if (eliminado) {
                    JOptionPane.showMessageDialog(frame, "Usuario eliminado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Error al eliminar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        JButton btnAgregarDatos = new JButton("ActualizarDatos");
        btnAgregarDatos.setBounds(414, 135, 132, 116);
        frame.getContentPane().add(btnAgregarDatos);
        btnAgregarDatos.addActionListener(e -> {
            // Obtén la lista de usuarios
            ArrayList<String> usuarios = new AutoModel().obtenerUsuarios();

            if (usuarios.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No hay usuarios registrados para actualizar.");
                return;
            }

            // Selecciona el usuario a actualizar
            String usuarioAActualizar = (String) JOptionPane.showInputDialog(
                frame,
                "Selecciona un usuario para actualizar:",
                "Actualizar usuario",
                JOptionPane.QUESTION_MESSAGE,
                null,
                usuarios.toArray(),
                usuarios.get(0)
            );

            if (usuarioAActualizar != null) {
                // Abre un nuevo diálogo para actualizar los datos
                JDialog dialog = new JDialog(frame, "Actualizar Usuario", true);
                dialog.setSize(400, 400);
                dialog.setLayout(null);
                dialog.setLocationRelativeTo(frame);

                JLabel nombreLabel = new JLabel("Nuevo Nombre:");
                nombreLabel.setBounds(50, 50, 120, 25);
                dialog.add(nombreLabel);

                JTextField nombreField = new JTextField();
                nombreField.setBounds(180, 50, 200, 25);
                dialog.add(nombreField);

                JLabel passwordLabel = new JLabel("Nueva Contraseña:");
                passwordLabel.setBounds(50, 100, 120, 25);
                dialog.add(passwordLabel);

                JTextField passwordField = new JTextField();
                passwordField.setBounds(180, 100, 200, 25);
                dialog.add(passwordField);

                JLabel correoLabel = new JLabel("Nuevo Correo:");
                correoLabel.setBounds(50, 150, 120, 25);
                dialog.add(correoLabel);

                JTextField correoField = new JTextField();
                correoField.setBounds(180, 150, 200, 25);
                dialog.add(correoField);

                JLabel telefonoLabel = new JLabel("Nuevo Teléfono:");
                telefonoLabel.setBounds(50, 200, 120, 25);
                dialog.add(telefonoLabel);

                JTextField telefonoField = new JTextField();
                telefonoField.setBounds(180, 200, 200, 25);
                dialog.add(telefonoField);

                JButton btnGuardar = new JButton("Guardar");
                btnGuardar.setBounds(100, 300, 100, 30);
                btnGuardar.addActionListener(ev -> {
                    String nuevoNombre = nombreField.getText();
                    String nuevaPassword = passwordField.getText();
                    String nuevoCorreo = correoField.getText();
                    String nuevoTelefono = telefonoField.getText();

                    if (nuevoNombre.isEmpty() || nuevaPassword.isEmpty()) {
                        JOptionPane.showMessageDialog(dialog, "El nombre y la contraseña son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean actualizado = new AutoModel().actualizarUsuario(
                        usuarioAActualizar.split(" | ")[0],
                        nuevoNombre,
                        nuevaPassword,
                        nuevoCorreo,
                        nuevoTelefono
                    );

                    if (actualizado) {
                        JOptionPane.showMessageDialog(dialog, "Usuario actualizado con éxito.");
                        dialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Error al actualizar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                dialog.add(btnGuardar);

                JButton btnCancelar = new JButton("Cancelar");
                btnCancelar.setBounds(220, 300, 100, 30);
                btnCancelar.addActionListener(ev -> dialog.dispose());
                dialog.add(btnCancelar);

                dialog.setVisible(true);
            }
        });


        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        btnSalir.setForeground(new Color(255, 255, 255));
        btnSalir.setBackground(new Color(255, 0, 0));
        btnSalir.setBounds(10, 10, 85, 21);
        frame.getContentPane().add(btnSalir);

        btnVerDatos.addActionListener(e -> {
            AutoModel model = new AutoModel();
            ArrayList<String> usuarios = model.obtenerUsuarios();

            if (usuarios.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No hay usuarios registrados.");
            } else {
                // Concatenamos todos los usuarios en un solo String
                StringBuilder sb = new StringBuilder();
                for (String u : usuarios) {
                    sb.append(u).append("\n");
                }
                JOptionPane.showMessageDialog(frame, sb.toString(), "Usuarios registrados", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }


    public void show() {
        frame.setVisible(true);
    }
}
