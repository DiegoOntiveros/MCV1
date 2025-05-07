package models;

import java.io.*;

public class AutoModel {
    private static final String FILE_PATH = "C:\\Users\\DYNABOOK\\Favorites\\Desktop\\MCV1\\MCV1\\src\\files//Datos";

    public boolean guardarUsuario(String nombre, String password) {
        try {
            File file = new File(FILE_PATH);
            
            // Si el archivo no existe, crea el directorio y el archivo
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            
            // Escribir en el archivo
            try (PrintWriter out = new PrintWriter(new FileWriter(file, true))) {
                out.println(nombre + "," + password);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sesion(String email, String password) {
        // Tu lógica de sesión existente
        return false;
    }
}