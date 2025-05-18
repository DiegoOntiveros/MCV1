package Controlls;

import views.Views;

public class autocontroller {

    private Views vista;

    public autocontroller() {
        // Inicializa la clase Views
        vista = new Views();
    }

    // Método para iniciar la ventana principal (Inicio de sesión)
    public void iniciarLogin() {
        vista.setVisible(true); // Muestra la ventana principal
    }

    // Método para manejar la lógica de registro
    public void mostrarRegistro() {
        vista.mostrarVentanaRegistro(); // Llama al método de registro en Views
    }

    public static void main(String[] args) {
        // Crea una instancia del controlador y abre la ventana principal
        autocontroller controlador = new autocontroller();
        controlador.iniciarLogin();
    }
}