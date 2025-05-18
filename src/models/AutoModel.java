package models;

import java.sql.*;
import java.util.ArrayList;

public class AutoModel {

    // URL de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/usuario";

    // Usuario y contraseña de MySQL
    private static final String USER = "root"; // Cambia por tu usuario
    private static final String PASSWORD = "root1"; // Cambia por tu contraseña

    /**
     * Método para obtener una conexión a la base de datos.
     * 
     * @return Connection o null si falla
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método para insertar un usuario en la base de datos.
     * 
     * @param nombre Nombre del usuario.
     * @param password Contraseña del usuario.
     * @return true si el usuario fue guardado correctamente.
     */
    public boolean guardarUsuario(String nombre, String password) {
        String sql = "INSERT INTO usuario (nombre, password) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, password);

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para validar sesión con nombre y contraseña.
     * 
     * @param nombre Nombre del usuario.
     * @param password Contraseña del usuario.
     * @return true si las credenciales son correctas.
     */
    public boolean sesion(String nombre, String password) {
        String sql = "SELECT * FROM usuario WHERE nombre = ? AND password = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Devuelve true si encontró un usuario

        } catch (SQLException e) {
            System.err.println("Error al validar sesión: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para obtener todos los usuarios registrados.
     * 
     * @return Lista de cadenas con los datos de los usuarios.
     */
    public ArrayList<String> obtenerUsuarios() {
        ArrayList<String> usuarios = new ArrayList<>();
        String sql = "SELECT nombre, password, correo, telefono FROM usuario";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String password = rs.getString("password");
                String correo = rs.getString("correo");
                String telefono = rs.getString("telefono");
                usuarios.add(nombre + " | " + password + " | " + correo + " | " + telefono);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    /**
     * Método main para probar las funcionalidades.
     */
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Conexión exitosa a la base de datos.");
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }

        AutoModel model = new AutoModel();

        // Prueba guardar usuario
        boolean guardado = model.guardarUsuario("Maria Lopez", "1234");
        System.out.println(guardado ? "Usuario guardado" : "Error al guardar usuario");

        // Prueba login
        boolean login = model.sesion("Maria Lopez", "1234");
        System.out.println(login ? "Login correcto" : "Login incorrecto");

        // Prueba obtener usuarios
        ArrayList<String> usuarios = model.obtenerUsuarios();
        System.out.println("Usuarios registrados:");
        for (String u : usuarios) {
            System.out.println(u);
        }
    }

public boolean eliminarUsuario(String nombre) {
    String sql = "DELETE FROM usuario WHERE nombre = ?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nombre);

        int filasEliminadas = stmt.executeUpdate();
        return filasEliminadas > 0;

    } catch (SQLException e) {
        System.err.println("Error al eliminar usuario: " + e.getMessage());
        return false;
    }
}
public boolean actualizarUsuario(String nombreActual, String nuevoNombre, String nuevaPassword, String nuevoCorreo, String nuevoTelefono) {
    String sql = "UPDATE usuario SET nombre = ?, password = ?, correo = ?, telefono = ? WHERE nombre = ?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nuevoNombre);
        stmt.setString(2, nuevaPassword);
        stmt.setString(3, nuevoCorreo);
        stmt.setString(4, nuevoTelefono);
        stmt.setString(5, nombreActual);

        int filasActualizadas = stmt.executeUpdate();
        return filasActualizadas > 0;

    } catch (SQLException e) {
        System.err.println("Error al actualizar usuario: " + e.getMessage());
        return false;
    }
}
}