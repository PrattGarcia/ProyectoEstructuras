/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparcialestrucrtura;

import CircularLinkedList.CircularLinkedList;
import java.util.ListIterator;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static proyectoparcialestrucrtura.ListaNumeros.sumaNumeros;

/**
 *
 * @author HP
 */
public class ProyectoParcial extends Application {
    
    private CircularLinkedList<Numero> listanumeros = new CircularLinkedList<>();
    private CircularLinkedList<Numero> listanumeros2 = new CircularLinkedList<>();
    
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
        Label look2 = new Label();
        Label looksum = new Label();
        HBox box1 = new HBox();
        HBox contenedorRuleta = new HBox();
        box1.getChildren().addAll(titular,texto,txtCantidad,btncontinuar);
        Pane ruleta = new Pane();
        contenedorRuleta.getChildren().add(ruleta);
        contenedorRuleta.setAlignment(Pos.CENTER);
        btncontinuar.setOnAction((e)->{
            int cantidad = Integer.parseInt(txtCantidad.getText());
            
            for(int i = 1;i<=cantidad;i++){
                Numero num = new Numero();
                num.setNumero((int)(Math.random()*10));
                listanumeros.addLast(num);
            }
            for(int i = 1;i<=cantidad;i++){
                Numero num = new Numero();
                num.setNumero((int)(Math.random()*10));
                listanumeros2.addLast(num);
            }
            look.setText(listanumeros.toString());
            look2.setText(listanumeros2.toString());
            looksum.setText(""+sumaNumeros(listanumeros));
            posicionarNumeros(ruleta);
        });
        
        root1.getChildren().addAll(box1,look,look2,looksum,contenedorRuleta);
        Scene scene = new Scene(root1,1800,900);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    public void posicionarNumeros(Pane paneruleta){
        //Método que recorre con un iterador la lista de niños y los posiciona de forma circular con un fórmula
        if(!paneruleta.getChildren().isEmpty()){
            paneruleta.getChildren().clear();
        }
        ListIterator<Numero> itPart = listanumeros.ListIterator();
        Numero number = itPart.next();
        
        for (double i = 0; i <= 360; i += 360 / (listanumeros.getEffectiveSize())+1) {
            
            Double x =  340 + 300 * Math.cos(Math.toRadians(i));
            Double y =  265 + 300 * Math.sin(Math.toRadians(i));
            
            Button btns =  new Button("" + number.getNumero());
            btns.setRotate(i+90);
            btns.relocate(x, y);
            paneruleta.getChildren().add(btns);
            System.out.println(""+number.getNumero());
            number = itPart.next();
        }
        

    }
}
