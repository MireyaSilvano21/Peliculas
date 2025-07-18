package org.example.peliculas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HelloController {
    @FXML
    private AnchorPane contenedorCentral;

    @FXML
    private void mostararAñadir() throws IOException {
        cargarVentana("añadirPelicula.fxml");
    }

    @FXML
    private void mostrarPeliculas() throws IOException {
        cargarVentana("listaPeliculas.fxml");
    }

    @FXML
    private void mostrarEliminar() throws IOException {
        cargarVentana("eliminarPeliculas.fxml");
    }

    @FXML
    private void mostrarModificar() throws IOException {
        cargarVentana("modificar.fxml");
    }

    @FXML
    private void cargarVentana(String rutafxml) throws IOException {
        AnchorPane vista = FXMLLoader.load(getClass().getResource(rutafxml));
        AnchorPane.setTopAnchor(vista, 0.0);
        AnchorPane.setBottomAnchor(vista, 0.0);
        AnchorPane.setLeftAnchor(vista, 0.0);
        AnchorPane.setRightAnchor(vista, 0.0);
        contenedorCentral.getChildren().setAll(vista);
    }
}