/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparcialestrucrtura;

import CircularLinkedList.CircularLinkedList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static proyectoparcialestrucrtura.ListaNumeros.sumaNumeros;

/**
 *
 * @author HP
 */
public class ProyectoParcial extends Application {
    
    private CircularLinkedList<Numero> listanumeros = new CircularLinkedList<>();
    
    @Override
    public void start(Stage primaryStage) {
        ventanaInicio(primaryStage);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void ventanaInicio(Stage primaryStage){
    
        VBox root1 = new VBox();
        
        Label titular = new Label("Ingrese cantidad de numeros");
        Label texto = new Label();
        TextField txtCantidad = new TextField();
        Button btncontinuar = new Button();
        btncontinuar.setText("Crear");
        Label look = new Label();
        Label looksum = new Label();
        HBox box1 = new HBox();
        HBox contenedorRuleta = new HBox();
        box1.getChildren().addAll(titular,texto,txtCantidad,btncontinuar);
        
        btncontinuar.setOnAction((e)->{
            int cantidad = Integer.parseInt(txtCantidad.getText());
            
            for(int i = 1;i<=cantidad;i++){
                Numero num = new Numero();
                num.setNumero((int)(Math.random()*10));
                listanumeros.addLast(num);
            }
            look.setText(listanumeros.toString());
            looksum.setText(""+sumaNumeros(listanumeros));
        });
        
        
        
        
        
        root1.getChildren().addAll(box1,look,looksum);
        Scene scene = new Scene(root1,900,650);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
}
